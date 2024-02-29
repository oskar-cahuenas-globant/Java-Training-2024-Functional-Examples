package com.globant.training.functional.domain;
public class Product {
  private final String name;
  private final String description;
  private final Color color;
  private final Double price;

  public Product(String name, String description, Color color, Double price) {
    this.name = name;
    this.description = description;
    this.color = color;
    this.price = price;
  }

  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public Color getColor() {
    return color;
  }
  public Double getPrice() {
    return price;
  }
}
