package com.kasih.bukuservice.controller;

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

import com.kasih.bukuservice.model.Buku;
import com.kasih.bukuservice.service.BukuService;

@RestController
@RequestMapping("api/buku")
public class BukuController {

    @Autowired
    private BukuService service;

    @GetMapping
    public List<Buku> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Buku save(@RequestBody Buku buku) {
        return service.save(buku);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Buku> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
