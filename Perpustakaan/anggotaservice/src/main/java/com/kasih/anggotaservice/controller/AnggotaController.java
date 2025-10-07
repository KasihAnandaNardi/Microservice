package com.kasih.anggotaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasih.anggotaservice.model.Anggota;
import com.kasih.anggotaservice.service.AnggotaService;

@RestController
@RequestMapping("api/anggota")
public class AnggotaController {

    @Autowired
    private AnggotaService service;

    @GetMapping
    public List<Anggota> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Anggota save(@RequestBody Anggota anggota) {
        return service.save(anggota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anggota> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
