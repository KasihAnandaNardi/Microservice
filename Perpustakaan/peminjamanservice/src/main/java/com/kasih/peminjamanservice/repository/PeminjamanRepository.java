package com.kasih.peminjamanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kasih.peminjamanservice.model.Peminjaman;

@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {

}
