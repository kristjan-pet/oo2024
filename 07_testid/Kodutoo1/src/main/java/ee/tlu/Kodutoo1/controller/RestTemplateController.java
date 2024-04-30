package ee.tlu.Kodutoo1.controller;

import ee.tlu.Kodutoo1.model.Products;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    @GetMapping("saa-produktid")
    public List<Products> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<Products[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Products[].class);
        return List.of(response.getBody());
    }

    @GetMapping("saa-produktid/{id}")
    public List<Products> getProductsId(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<Products[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Products[].class);

        List<Products> products = new ArrayList<>();
        for (Products p : response.getBody()) {
           if (p.getId() == id) {
               products.add(p);
           }
        }

        return products;
    }
}
