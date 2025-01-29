package com.codexrealis.factus_backend.controller;

import com.codexrealis.factus_backend.utils.HttpClientUtil;
import com.google.gson.JsonObject;

public class FacturaController {
    private String accessToken;

    public FacturaController(String accessToken) {
        this.accessToken = accessToken;
    }

    public String crearFactura(JsonObject facturaData) throws Exception {
        if (facturaData == null) {
            throw new IllegalArgumentException("Los datos de la factura no pueden ser nulos.");
        }

        String url = "https://api-sandbox.factus.com.co/facturas"; // Endpoint correcto
        return HttpClientUtil.post(url, facturaData.toString(), accessToken);
    }


    public String validarFactura(String facturaId) throws Exception {
        if (facturaId == null || facturaId.isEmpty()) {
            throw new IllegalArgumentException("El ID de la factura no puede ser nulo o vacío.");
        }

        String url = "https://api-sandbox.factus.com.co/facturas/" + facturaId + "/validar";
        return HttpClientUtil.post(url, "", accessToken); // Enviar un body vacío si es necesario
    }

}

