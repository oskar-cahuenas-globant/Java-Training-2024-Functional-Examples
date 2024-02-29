package com.globant.training.functional.interfaces.stream;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple example of List map, convert to uppercase a list of strings
 * - Traditional iterative approach
 * - Functional approach with stream.map() function
 */
public class MapListExample {

  /**
   * Convert all elements to upper case iterative
   * @param input
   * @return
   */
  static List<String> allToUpperIterative(List<String> input) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < input.size(); i++) {
      // tansform i-th element of list
      String elem = input.get(i);
      String upper = elem.toUpperCase();

      // append transformed element to result
      result.add(upper);
    }
    return result;
  }

  /**
   * Convert all elements to upper case functional approach
   * @param input
   * @return
   */
  static List<String> allToUpperFunctional(List<String> input) {
    return input.stream()
        .map(s -> s.toUpperCase())
        .toList() ;
  }

  public static void main(String[] args) {
    System.out.println("MAP EXAMPLE");
    System.out.println();

    List<String> animals = List.of("cat", "dog", "deer", "pigeon");
    System.out.println("Animals list: " + animals );
    System.out.println(String.format("Elements to Upper Case iterative: "  + allToUpperIterative(animals)));
    System.out.println(String.format("Elements to Upper Case Functional: "  + allToUpperIterative(animals)));

  }
}
