package com.example.ecomProject.server;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecomProject.model.Product;
import com.example.ecomProject.repository.Productrepository;

@Service
public class Productservice {
    
    @Autowired
    private Productrepository repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product,MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
    public List<Product> searchProducts(String keyword){
        return repo.searchProduct(keyword);
    }


}
