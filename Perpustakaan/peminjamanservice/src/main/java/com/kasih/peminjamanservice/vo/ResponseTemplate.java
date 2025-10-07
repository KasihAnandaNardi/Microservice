package com.kasih.peminjamanservice.vo;

import com.kasih.peminjamanservice.model.Peminjaman;

public class ResponseTemplate {
    private Peminjaman peminjaman;
    private Anggota anggota;
    private Buku buku;

    public ResponseTemplate() {}

    public ResponseTemplate(Peminjaman peminjaman, Anggota anggota, Buku buku) {
        this.peminjaman = peminjaman;
        this.anggota = anggota;
        this.buku = buku;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
}
