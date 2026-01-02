package com.kasih.pengembalianservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kasih.pengembalianservice.model.Pengembalian;

@Repository
public interface PengembalianRepository extends JpaRepository<Pengembalian, Long> {

}
