package com.codexrealis.factus_backend.model;

import com.google.gson.JsonObject;

public class Factura {
    private String cliente;
    private String producto;
    private double total;

    public Factura(String cliente, String producto, double total) {
        this.cliente = cliente;
        this.producto = producto;
        this.total = total;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("cliente", cliente);
        json.addProperty("producto", producto);
        json.addProperty("total", total);
        return json;
    }
}