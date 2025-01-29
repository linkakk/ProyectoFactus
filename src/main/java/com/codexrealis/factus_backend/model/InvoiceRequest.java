package com.codexrealis.factus_backend.model;

import com.google.gson.Gson;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
    private int numberingRangeId;
    private String referenceCode;
    private String observation;
    private String paymentForm;
    private String paymentDueDate;
    private String paymentMethodCode;
    private BillingPeriod billingPeriod;
    private Customer customer;
    private List<Item> items;

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillingPeriod {
        private String startDate;
        private String startTime;
        private String endDate;
        private String endTime;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Customer {
        private String identification;
        private String dv;
        private String company;
        private String tradeName;
        private String names;
        private String address;
        private String email;
        private String phone;
        private String legalOrganizationId;
        private String tributeId;
        private String identificationDocumentId;
        private String municipalityId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String codeReference;
        private String name;
        private int quantity;
        private double discountRate;
        private double price;
        private double taxRate;
        private int unitMeasureId;
        private int standardCodeId;
        private int isExcluded;
        private int tributeId;
        private List<WithholdingTax> withholdingTaxes;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WithholdingTax {
        private String code;
        private double withholdingTaxRate;
    }
}
