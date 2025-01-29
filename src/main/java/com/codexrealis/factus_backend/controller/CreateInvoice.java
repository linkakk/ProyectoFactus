package com.codexrealis.factus_backend.controller;

import com.codexrealis.factus_backend.exception.ApiRequestException;
import com.codexrealis.factus_backend.model.InvoiceRequest;
import com.codexrealis.factus_backend.utils.HttpClientUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class CreateInvoice {


    @PostMapping("/create")
    public String createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        try {
            String url = "https://api-sandbox.factus.com.co/v1/bills/validate";

            // Convierte el objeto a JSON
            String invoiceJson = new Gson().toJson(invoiceRequest);

            String response = HttpClientUtil.post(url, invoiceJson, null);
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();

            return jsonResponse.toString();
        } catch (Exception ex) {
            throw new ApiRequestException("Error al crear la factura: " + ex.getMessage());
        }
    }

}
