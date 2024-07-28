package com.brite.product.controller;

import com.brite.product.domain.Product;
import com.brite.product.repository.ProductCrudRepository;
import com.brite.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService productService;


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/addproducts")
    public @ResponseBody Product addproduct(@RequestBody Product product) {
        System.out.println("Hello");
        return productService.addproduct(product);
    }

    @GetMapping(path = "findId/{productId}")
    public Optional<Product> findById(@PathVariable Integer productId) throws SQLException {
        return productService.findById(productId);
    }

    @GetMapping(path = "/allprods")
    public @ResponseBody Iterable<Product> getproducts() {
        return productService.getproducts();
    }

    @DeleteMapping(path = "/deleteprod")
    public @ResponseBody Optional<String> deleteprod(@RequestBody Product product) throws SQLException {
        return Optional.ofNullable(productService.deleteproduct(product));
    }

    @PostMapping(path ="/updateprod")
    public @ResponseBody Optional<Product> updateproduct(@RequestBody Product product) throws SQLException {
        return productService.updateproduct(product);
    }
    @GetMapping(path = "/productmessage")
    public @ResponseBody  String getMessage() {
        return "Product Message";
    }
}
