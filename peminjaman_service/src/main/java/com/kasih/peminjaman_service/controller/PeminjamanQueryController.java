package com.kasih.peminjaman_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kasih.peminjaman_service.model.PeminjamanQuery;
import com.kasih.peminjaman_service.service.PeminjamanQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/peminjaman")
@RequiredArgsConstructor
public class PeminjamanQueryController {

    private final PeminjamanQueryService peminajamQueryService;

    @GetMapping
    public ResponseEntity<List<PeminjamanQuery>> getAllPeminjaman() {
        return ResponseEntity.ok(peminajamQueryService.getAllPeminjaman());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeminjamanQuery> getPeminjamanById(@PathVariable String id) {
        PeminjamanQuery peminjaman = peminajamQueryService.getPeminjamanById(id);
        return peminjaman != null ? ResponseEntity.ok(peminjaman): ResponseEntity.notFound().build();
    }
}
