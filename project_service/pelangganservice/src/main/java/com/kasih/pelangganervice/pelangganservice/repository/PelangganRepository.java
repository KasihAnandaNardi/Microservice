package com.kasih.pelangganervice.pelangganservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kasih.pelangganervice.pelangganservice.model.Pelanggan;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
    // JpaRepository sudah menyediakan method seperti findAll(), findById(), save(),
    // deleteById()
    // Anda bisa menambahkan query kustom di sini jika diperlukan
}
