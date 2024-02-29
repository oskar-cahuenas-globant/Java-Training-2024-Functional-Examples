/**
 * Simple example of List filter, by filtering a list for a given predicate
 * - Traditional iterative approach
 * - Functional approach with stream.map() function
 */
package com.globant.training.functional.interfaces.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterListExample {
  // Constant with a predicate that validate if
  // a string has only letters from A-Z or _ and first char is upper
  // and lenght is between 6 and 24
  private static final Predicate<String> VALIDATE_STRING_PREDICATE = s -> {
    // validate null string and trim
    if (s == null) {
      return false;
    }
    // validate length
    if (!(s.length() >= 6 && s.length() <= 24)) {
      return false;
    }
    // validate chars
    if (!Character.isAlphabetic(s.charAt(0)) || !Character.isUpperCase(s.charAt(0))) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isAlphabetic(c) && c  != '_') {
        return false;
      }
    }

    return true;
  };

  /**
   * Filter all elements of a list iterative
   * @param input
   * @return
   */
  static List<String> filterListIterative(List<String> input) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < input.size(); i++) {
      // verify predicate
      if (VALIDATE_STRING_PREDICATE.test(input.get(i))) {
        result.add(input.get(i));
      }
    }
    return result;
  }

  /**
   * Filter all elements of a list functional approach
   * @param input
   * @return
   */
  static List<String> allToUpperFunctional(List<String> input) {
    return input.stream()
        .filter(VALIDATE_STRING_PREDICATE)
        .toList() ;
  }

  public static void main(String[] args) {
    System.out.println("FILTER EXAMPLE");
    System.out.println();

    List<String> variables = List.of(
        "Var", "_Variabgle", "", "Var_name", "variable_name",
        "valid_variable_n*ame", "login_and_password", "CalculateDistance");
    System.out.println("Variables list: " + variables );
    System.out.println(String.format("Filtered List Case iterative: "  + filterListIterative(variables)));
    System.out.println(String.format("Filtered List Case Functional: "  + allToUpperFunctional(variables)));

  }
}
