package com.kasih.bukuservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        private String judul;
        private String pengarang;
        private String penerbit;
        private Integer tahunTerbit;

    // Getter & Setter
}
