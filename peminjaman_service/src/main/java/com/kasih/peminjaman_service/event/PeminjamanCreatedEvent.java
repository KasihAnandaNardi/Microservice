package com.kasih.peminjaman_service.event;

import com.kasih.peminjaman_service.model.PeminjamanCommand;

public class PeminjamanCreatedEvent {

    private final PeminjamanCommand peminjaman;

    public PeminjamanCreatedEvent(PeminjamanCommand peminjaman) {
        this.peminjaman = peminjaman;
    }

    public PeminjamanCommand getPeminjaman() {
        return peminjaman;
    }
}
