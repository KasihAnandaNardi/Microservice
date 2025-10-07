package com.kasih.peminjamanservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kasih.peminjamanservice.model.Peminjaman;
import com.kasih.peminjamanservice.repository.PeminjamanRepository;
import com.kasih.peminjamanservice.vo.Anggota;
import com.kasih.peminjamanservice.vo.Buku;
import com.kasih.peminjamanservice.vo.ResponseTemplate;

@Service
public class PeminjamanService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public PeminjamanService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<Peminjaman> getAllPeminjaman() {
        return peminjamanRepository.findAll();
    }

    public Peminjaman getPeminjamanById(Long id) {
        return peminjamanRepository.findById(id).orElse(null);
    }

    public Peminjaman createPeminjaman(Peminjaman peminjaman) {
        Peminjaman savedPeminjamanan = peminjamanRepository.save(peminjaman);
        rabbitTemplate.convertAndSend(exchange, routingKey, savedPeminjamanan);
        return savedPeminjamanan;
    }

    public void deletePeminjaman(Long id) {
        peminjamanRepository.deleteById(id);
    }

    public List<ResponseTemplate> getPeminjamanWithAnggotaBukuById(Long id) {
        Peminjaman peminjaman = getPeminjamanById(id);
        if (peminjaman == null) {
            return Collections.emptyList();
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("API-GATEWAY");
        if (instances.isEmpty()) {
            throw new RuntimeException("API-GATEWAY not found");
        }
        ServiceInstance serviceInstance = instances.get(0);

        Anggota anggota = restTemplate.getForObject(
                serviceInstance.getUri() + "/api/anggota/" + peminjaman.getAnggotaId(), Anggota.class);
        Buku buku = restTemplate.getForObject(
                serviceInstance.getUri() + "/api/buku/" + peminjaman.getBukuId(), Buku.class);

        ResponseTemplate vo = new ResponseTemplate();
        vo.setPeminjaman(peminjaman);
        vo.setAnggota(anggota);
        vo.setBuku(buku);

        return Collections.singletonList(vo);
    }
}
