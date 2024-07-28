package com.brite.product.service;

import com.brite.product.domain.Product;
import com.brite.product.repository.ProductCrudRepository;
import com.brite.product.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class ProductService {

    private ProductCrudRepository productCrudRepository;
    private ProductJpaRepository productJpaRepository;

    @Autowired
    public void setProductCrudRepository(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Autowired
    public void setProductJpaRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public Product addproduct(Product product) {
        return (productCrudRepository.save(product));
    }

    public Iterable<Product> getproducts() {
        return productCrudRepository.findAll();
    }

    public Optional<Product> findById(Integer id) throws SQLException {
        Optional<Product> prod = productCrudRepository.findById(id);
        if (prod.isPresent()){
            return prod;
        }else{
            throw new SQLException();
        }
    }

    public String deleteproduct(Product product) throws SQLException {
        Optional<Product> prod = productCrudRepository.findById(product.getProductId());

        if (prod.isPresent() && product.getProductName().equals(prod.get().getProductName())) {
            productCrudRepository.delete(product);

        } else {
            throw new SQLException();
        }
        return "Deleted";
    }

    public Optional<Product> updateproduct(Product product) throws SQLException {
        Optional<Product> prod = productCrudRepository.findById(product.getProductId());
        if (prod.isPresent()){
            Product newProduct =
                    new Product(product.getProductId(),product.getProductName(),product.getQuantity(),product.getPrice());
            productCrudRepository.save(newProduct);
        }else{
            throw new SQLException();
        }
        return productCrudRepository.findById(product.getProductId());
    }


}
