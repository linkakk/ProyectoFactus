package com.codexrealis.factus_backend.utils;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;

public class HttpClientUtil {

    public static String post(String url, String body, String token) throws Exception {
        return Request.post(url)
                .addHeader("Authorization", "Bearer " + token) // Agregar token al header
                .bodyString(body, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();
    }

}
