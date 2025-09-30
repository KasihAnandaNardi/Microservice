package com.kasih.pengembalian_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kasih.pengembalian_service.model.Pengembalian;

@Repository
public interface PengembalianRepository extends JpaRepository<Pengembalian,Long> {

}
