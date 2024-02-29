package com.globant.training.functional.interfaces.builtin;
import java.util.UUID;

public class MainUUID {
  public static void main(String[] args) {
    String uuid = UUID.randomUUID().toString();
    System.out.println("UUID=" + uuid + ", length=" + uuid.length());
  }
}
