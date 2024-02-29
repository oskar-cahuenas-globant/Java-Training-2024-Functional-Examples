/**
 * Examples for {@link java.util.function.Predicate} interface
 */
package com.globant.training.functional.interfaces.builtin;
import java.util.function.Predicate;

public class PredicateExample {
  /**
   * Simple predicates examples
   */
  public static void simplePredicateExample() {
    System.out.println("begin method simplePredicateExample");
    // predicate to test if integer is even
    final Predicate<Integer> isEven = n -> n % 2 == 0;

    // predicate to test if integer is odd. Negation of is even
    final Predicate<Integer> isOdd = isEven.negate();

    // predicate to test if a String is not null nor empty
    final Predicate<String> notEmptyString = s -> s != null && !s.trim().isEmpty();

    // predicate to test if a String begins with a vowel
    final Predicate<String> beginsWithAVowel = s -> {
      char first = s.toUpperCase().charAt(0);
      return first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U';
    };

    // predicate that validate that string is not empty and begins with a vowel
    // by using and OR combination of former two predicates
    Predicate<String> validString = notEmptyString.and(beginsWithAVowel);

    // perform test predicates
    int value = 5;
    System.out.println(String.format("Value %d is even = %s", value, isEven.test(value)));
    System.out.println(String.format("Value %d is odd = %s", value, isOdd.test(value)));

    // string validation predicate
    String str = "None";
    System.out.println(String.format("String %s is valid = %s", str, validString.test(str)));

    str = null;
    System.out.println(String.format("String %s is valid = %s",  str, validString.test(str)));

    str = "All";
    System.out.println(String.format("String %s is valid = %s", str, validString.test(str)));

    System.out.println("end method simplePredicateExample");
  }

  public static void main(String[] args) {
    System.out.println("PREDICATE EXAMPLES");
    System.out.println();
    simplePredicateExample();
  }
}
