package com.kasih.orderservice.service;

import com.kasih.orderservice.model.Order;
import com.kasih.orderservice.repository.OrderRepository;
import com.kasih.orderservice.VO.Pelanggan;
import com.kasih.orderservice.VO.Produk;
import com.kasih.orderservice.VO.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    // ... (di dalam kelas OrderService)

    // Method LENGKAP: Mengambil Order + Produk + Pelanggan
    public List<ResponseTemplate> getOrderWithProdukById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Order order = getOrderById(id);
        ServiceInstance serviceInstance = discoveryClient.getInstances("PRODUK").get(0);
        Produk produk = restTemplate.getForObject(serviceInstance.getUri() + "/api/produk/"
                + order.getProdukId(), Produk.class);
                serviceInstance = discoveryClient.getInstances("PELANGGAN").get(0);
        Pelanggan pelanggan = restTemplate.getForObject(serviceInstance.getUri() + "/api/pelanggan/"
                + order.getPelangganId(), Pelanggan.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        vo.setPelanggan(pelanggan);
        responseList.add(vo);
        return responseList;
    }


    
    // public ResponseTemplate getOrderWithProdukById(Long id) {
    // // 2. Buat objek ResponseTemplate untuk diisi
    // ResponseTemplate vo = new ResponseTemplate();

    // // 3. Ambil Order dari database dan tangani jika tidak ada
    // Order order = orderRepository.findById(id)
    // .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

    // // 4. Panggil Product Service untuk mendapatkan detail produk
    // // - URL diperbaiki (menambahkan "/")
    // // - Parameter class diperbaiki (Produk.class)
    // Produk produk = restTemplate.getForObject("http://localhost:8081/api/produk/"
    // + order.getProdukId(),
    // Produk.class);

    // // 5. Panggil Pelanggan Service untuk mendapatkan detail pelanggan
    // // - URL diperbaiki
    // // - LOGIKA ID DIPERBAIKI (menggunakan getPelangganId())
    // // - Parameter class diperbaiki
    // Pelanggan pelanggan =
    // restTemplate.getForObject("http://localhost:8082/api/pelanggan/" +
    // order.getPelangganId(),
    // Pelanggan.class);

    // // 6. Set semua objek ke dalam ResponseTemplate
    // vo.setOrder(order);
    // vo.setProduk(produk);
    // vo.setPelanggan(pelanggan);

    // // 7. Kembalikan satu objek ResponseTemplate, bukan list
    // return vo;
    // }

    public Order createOrder(Order order) {
        if (order.getTanggal() == null || order.getTanggal().isEmpty()) {
            order.setTanggal(LocalDate.now().toString());
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        existingOrder.setProdukId(orderDetails.getProdukId());
        existingOrder.setPelangganId(orderDetails.getPelangganId());
        existingOrder.setJumlah(orderDetails.getJumlah());
        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setTotal(orderDetails.getTotal());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrderById(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}