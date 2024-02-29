package com.globant.training.functional.interfaces.builtin;

/**
 * Example for use of {@link GenericAdderInheritance}  as interface inheriting of BiFunction
 * for implementing and adder.
 *
 * Look for similarities and differences with {@link com.globant.training.functional.interfaces.basic.IntAdder}
 */
public class GenericAdderInterfaceMain {

  public static void main(String[] args) {
    System.out.println("GenericAdder example");

    // Adder of two doubles
    GenericAdderInheritance<Double> doubleAdder = (x, y) -> x + y;

    // add two double values
    double x = 23.4;
    double y = 12.44;
    // for the case of adder, we use apply method inherited from BiFunction
    double sum = doubleAdder.apply(x,y);
    System.out.println(String.format("Sum of two doubles %.2f + %.2f = %.2f", x, y, sum));


    // add two String, string "adition" could be concatenation
    String s1 = "hello";
    String s2 = " world";
    GenericAdderInheritance<String> concatenator = (s,t) -> {
      if (s == null && t == null) {
        return null;
      }
      if (s == null) {
        return t;
      }
      if (t == null) {
        return s;
      }

      // the two strings are not null
      return s + t;
    };

    System.out.println("String concatenation =" + concatenator.apply(s1, s2));

  }
}
