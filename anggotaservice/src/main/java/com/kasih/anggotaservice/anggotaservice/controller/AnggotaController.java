package com.kasih.anggotaservice.anggotaservice.controller;

import com.kasih.anggotaservice.anggotaservice.model.Anggota;
import com.kasih.anggotaservice.anggotaservice.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/anggota") // URL Asas untuk semua endpoint dalam kelas ini
public class AnggotaController {
    
    @Autowired
    private AnggotaService anggotaService;

    // Menangani: POST /api/anggota
    @PostMapping
    public Anggota save(@RequestBody Anggota anggota) {
        return anggotaService.save(anggota);
    }

    // Menangani: GET /api/anggota/{id}
    // Contoh: /api/anggota/123
    @GetMapping("/{id}")
    public Anggota findById(@PathVariable Long id) {
        return anggotaService.findById(id);
    }

    // === PERBAIKAN DI SINI ===
    // Menangani: GET /api/anggota
    // Anotasi @GetMapping tanpa sebarang path tambahan.
    @GetMapping
    public List<Anggota> findAll() {
        return anggotaService.findAll();
    }

    // Menangani: PUT /api/anggota/{id}
    // Contoh: /api/anggota/123
    @PutMapping("/{id}")
    public Anggota update(@PathVariable Long id, @RequestBody Anggota anggota) {
        // Tetapkan ID daripada path URL untuk memastikan rekod yang betul dikemas kini
        anggota.setId(id);
        return anggotaService.save(anggota); // 'save' biasanya berfungsi untuk mencipta dan mengemas kini
    }
}