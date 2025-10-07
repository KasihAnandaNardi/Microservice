package com.kasih.orderservice.VO;

public class Produk {
    private long id;
    private String nama;
    private String satuan;
    private double harga;

    public Produk() {
    }

    public Produk(long id, String nama, String satuan, double harga) {
        this.id = id;
        this.nama = nama;
        this.satuan = satuan;
        this.harga = harga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
