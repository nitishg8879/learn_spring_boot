package com.microservice.order;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id) {
        HttpURLConnection httpURLConnection = null;
        try {
            // Simulate a call to the product service
            httpURLConnection = (HttpURLConnection) new URL("http://localhost:8082/products/" + id)
                    .openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setConnectTimeout(100);
            httpURLConnection.setReadTimeout(500);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(
                        new java.io.InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }
                bufferedReader.close();
                return ResponseEntity.ok().body("Order details for ID: " + id + " with " + response.toString());
            } else {
                return ResponseEntity.status(responseCode).body("Failed to retrieve product details");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred while retrieving product details");
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

}
