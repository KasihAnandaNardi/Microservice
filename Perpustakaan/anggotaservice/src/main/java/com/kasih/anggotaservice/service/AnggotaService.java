package com.kasih.anggotaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasih.anggotaservice.model.Anggota;
import com.kasih.anggotaservice.repository.AnggotaRepository;

@Service
public class AnggotaService {

    @Autowired
    private AnggotaRepository repo;

    public List<Anggota> getAll() {
        return repo.findAll();
    }

    public Anggota save(Anggota anggota) {
        return repo.save(anggota);
    }

    public Optional<Anggota> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
