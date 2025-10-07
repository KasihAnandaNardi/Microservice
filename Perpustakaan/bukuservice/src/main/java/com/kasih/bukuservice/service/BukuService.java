package com.kasih.bukuservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasih.bukuservice.model.Buku;
import com.kasih.bukuservice.repository.BukuRepository;

@Service
public class BukuService {

    @Autowired
    private BukuRepository repo;

    public List<Buku> getAll() {
        return repo.findAll();
    }

    public Buku save(Buku buku) {
        return repo.save(buku);
    }

    public Optional<Buku> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
