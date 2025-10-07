package com.kasih.peminjamanservice.peminjamanservice.controller;

import com.kasih.peminjamanservice.peminjamanservice.model.Peminjaman;
import com.kasih.peminjamanservice.peminjamanservice.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kasih.peminjamanservice.peminjamanservice.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/api/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;

    @PostMapping
    public Peminjaman save(@RequestBody Peminjaman peminjaman) {
        return peminjamanService.save(peminjaman);
    }
}