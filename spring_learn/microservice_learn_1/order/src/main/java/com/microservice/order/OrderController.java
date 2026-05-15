package com.microservice.order;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestClient restClient;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/legacyWay/{id}")
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

    @GetMapping("/usingRestTemplate/{id}")
    public String usingRestTemplate(@PathVariable String id) {
        // restTemplate.getForEntity(id, null, null)// gives full req,res data
        return restTemplate.getForObject("http://localhost:8082/products/" + id, String.class);// return only body data
    }

    @GetMapping("/usingRestClient/{id}")
    public String usingRestClient(@PathVariable String id) {
        return restClient.get()
                .uri("http://localhost:8082/products/" + id)
                .retrieve()
                .onStatus(t -> {
                    System.out.println("Error status code: ");
                    return true;
                })
                .body(String.class);
    }

    @GetMapping("/usingFeignClient/{id}")
    public String getMethodName(@PathVariable String id) {
        return productClient.getProductByID(id);
    }

}
