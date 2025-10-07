package com.kasih.orderservice.VO;
import com.kasih.orderservice.model.Order;

public class ResponseTemplate {
    private Order order;
    private Produk produk;
    private Pelanggan pelanggan;

    public ResponseTemplate() {
    }

    public ResponseTemplate(Order order, Produk produk, Pelanggan pelanggan) {
        this.order = order;
        this.produk = produk;
        this.pelanggan = pelanggan;
    }

    
    // Getter & Setter
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
