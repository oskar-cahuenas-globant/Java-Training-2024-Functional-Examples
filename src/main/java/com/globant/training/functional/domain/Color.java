package com.globant.training.functional.domain;
public enum Color {
  BLACK("black"),
  WHITE("white"),
  RED("red"),
  BLUE("blue"),
  GREEN("green"),
  PURPLE("purple"),
  ;

  private final String colorName;

  Color(String colorName) {
    this.colorName = colorName;
  }

  public String getColorName() {
    return colorName;
  }
}
