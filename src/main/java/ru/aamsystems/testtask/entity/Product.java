package ru.aamsystems.testtask.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    BigInteger id;

    @Column
    String description;

}
