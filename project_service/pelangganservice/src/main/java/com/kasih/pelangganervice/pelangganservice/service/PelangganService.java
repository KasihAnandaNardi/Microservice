package com.kasih.pelangganervice.pelangganservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasih.pelangganervice.pelangganservice.model.Pelanggan;
import com.kasih.pelangganervice.pelangganservice.repository.PelangganRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Optional<Pelanggan> getPelangganById(Long id) {
        return pelangganRepository.findById(id);
    }

    public Pelanggan createOrUpdatePelanggan(Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    public void deletePelangganById(Long id) {
        pelangganRepository.deleteById(id);
    }
}
