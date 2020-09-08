package com.geekbrains.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 6, message = "Title length must be greater than 5 symbols")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Cost cannot be null")
    @Min(value = 1, message = "Min cost error")
    @Column(name = "cost")
    private double cost;
}