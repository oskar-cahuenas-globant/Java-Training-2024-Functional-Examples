package com.globant.training.functional.domain;

public class Person {
  private final String name;
  private final Document document;
  private final String address;

  public Person(String name, Document document, String address) {
    this.name = name;
    this.document = document;
    this.address = address;
  }

  public String getName() {
    return name;
  }
  public Document getDocument() {
    return document;
  }
  public String getAddress() {
    return address;
  }
}
