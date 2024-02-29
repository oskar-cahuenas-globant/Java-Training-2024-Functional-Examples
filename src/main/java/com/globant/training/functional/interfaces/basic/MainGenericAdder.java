package com.globant.training.functional.interfaces.basic;
import java.util.Arrays;

public class MainGenericAdder {
  public static Integer[] addTwoVectors(Integer[] v1, Integer[] v2) {
    // We define an adder to add two vectors represented as one-dimensional array
    // as the sum of each component of the vector
    // or a + b = (a1 + b1, a2 + b2, ..., an + bn)
    // Note that in this case is not the same int[] and Integer[]
    // because autoboxing is made only for primitive types
    // and array ([]) is not a primitive type
    GenericAdder<Integer[]> vectorAdder = (x, y) -> {
      // we create result vector
      Integer[] result = new Integer[x.length];
      // iterate for each element of v1 and v2 for sum each pair of elements
      for (int i = 0; i < x.length; i++) {
        result[i] = x[i] + y[i];
      }
      return result;
    };
    return vectorAdder.add(v1, v2);
  }

  public static double addTwoDoubles(double v1, double v2) {
    // We define adder of two doubles
    GenericAdder<Double> adder = (x,y) -> x + y;
    return adder.add(v1,v2);
  }

  public static Integer adderWithNoType(Integer v1, Integer v2) {
    // we define adder with no type
    // this could issue a typecheck warning
    // note that given adder has no a concrete type
    // explicit cast must be performed in lambada function definition
    // as well as in return value
    GenericAdder noTypeAdder = (x,y)  -> (Integer)x + (Integer)y;
    return (int)noTypeAdder.add(v1, v2);
  }

  public static void main(String[] args) {
    System.out.println("EXAMPLE OF FUNCTIONAL INTERFACE TO GENERIC ADDER");
    final Integer[] vector1 = {5, 7, -20, 33, -5};
    final Integer vector2[] = {-13, 7, 0, 0, 17};
    final Integer vectorSum[] = addTwoVectors(vector1, vector2);
    System.out.println("Sample of sum of two vectors implemented with an Adder");
    System.out.println(String.format("Sum of %s + %s = %s",
        Arrays.toString(vector1),
        Arrays.toString(vector2),
        Arrays.toString(vectorSum)));

    System.out.println();
    final double d1 = 5.33233;
    final double d2 = -3.789;
    final double doubleSum = addTwoDoubles(d1, d2);
    System.out.println("Sample sum of two doubles implemented with an adder ");
    System.out.println(String.format("%f + %f = %f", d1, d2, doubleSum));

    System.out.println();
    final int i1 = 75;
    final int i2 = 47;
    final int intSum = adderWithNoType(i1, i2);
    System.out.println("Sample sum of two doubles implemented with an no type adder ");
    System.out.println(String.format("%d + %d = %d", i1, i2, intSum));
  }
}
