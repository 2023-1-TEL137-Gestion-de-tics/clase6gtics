package com.example.clase6gtics.entity;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int id;

    @Column(nullable = false)
    @Size(max = 40, message = "El tamaño máximo es de 40 caracteres")
    @NotBlank
    private String productname;

    @Positive
    @Digits(integer = 10,fraction = 4)
    private BigDecimal unitprice;

    @Digits(integer = 5,fraction = 0)
    @Min(value = 0)
    @Max(value = 32767)
    private Integer unitsinstock;

    @Digits(integer = 10, fraction = 0)
    @Max(value = 32767)
    @Min(value = 0)
    private int unitsonorder;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    private String quantityperunit;


    private int reorderlevel;
    @Column(nullable = false)
    private boolean discontinued;

}
