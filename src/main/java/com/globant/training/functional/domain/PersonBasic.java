package com.globant.training.functional.domain;

public class PersonBasic {
  private final String name;
  private final String document;
  private final String address;

  public PersonBasic(String name, String document, String address) {
    this.name = name;
    this.document = document;
    this.address = address;
  }

  public String getName() {
    return name;
  }
  public String getDocument() {
    return document;
  }
  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "PersonBasic{" +
        "name='" + name + '\'' +
        ", document='" + document + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
