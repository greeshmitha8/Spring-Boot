package com.example.ecomProject.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal Price;
    private String category;
    //JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yy")
    private LocalDate releaseDate;
    private Boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob // large object 
    private byte[] imageData;
}
