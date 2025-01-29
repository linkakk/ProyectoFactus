package com.codexrealis.factus_backend.service;

import com.codexrealis.factus_backend.model.AuthResponse;
import com.codexrealis.factus_backend.utils.HttpClientUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthResponse autenticar(String clientId, String clientSecret, String username, String password) throws Exception {
        String url = "https://api-sandbox.factus.com.co/oauth/token";

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("grant_type", "password");
        requestBody.addProperty("client_id", clientId);
        requestBody.addProperty("client_secret", clientSecret);
        requestBody.addProperty("username", username);
        requestBody.addProperty("password", password);

        String accessToken = null;
        String response = HttpClientUtil.post(url, requestBody.toString(), accessToken);

        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        accessToken = jsonResponse.get("access_token").getAsString();
        String refreshToken = jsonResponse.get("refresh_token").getAsString();

        return new AuthResponse(accessToken, refreshToken);
    }
}
