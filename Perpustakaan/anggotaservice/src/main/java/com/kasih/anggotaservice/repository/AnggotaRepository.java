package com.kasih.anggotaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kasih.anggotaservice.model.Anggota;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Long> {
}
