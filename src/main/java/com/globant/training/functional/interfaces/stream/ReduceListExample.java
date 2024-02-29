/**
 * Simple example of List reduce for a binary operator with
 * - Traditional iterative approach
 * - Functional approach with stream.map() function
 */
package com.globant.training.functional.interfaces.stream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReduceListExample {

  /**
   * Sum of Int list with iterative
   * @param values
   * @return
   */
  public static int sumIntegersIterative(List<Integer> values) {
    // accumulator variable
    // accumulator begins with identity element
    int sum = 0;
    for (Integer n : values) {
      // apply operator with accumulator and next element of list
      sum = sum + n;
    }
    return sum;
  }

  /**
   * Sum of Int list with functional
   * @param values
   * @return
   */
  static int sumIntegersFunctional(List<Integer> values) {
    return values
        .stream()
        .reduce(0, (x,y) -> x + y);
  }

  /**
   * Sum of BigIntegers with iterative
   * @param values
   * @return
   */
  public static BigInteger sumBigIntegersIterative(List<BigInteger> values) {
    // accumulator variable
    // accumulator begins with identity element
    BigInteger sum = BigInteger.ZERO;
    for (BigInteger n : values) {
      // apply operator with accumulator and next element of list
      sum = sum.add(n);
    }
    return sum;
  }

  /**
   * Sum of Int list with functional
   * @param values
   * @return
   */
  static BigInteger sumBigIntegersFunctional(List<BigInteger> values) {
    // In this case reduction could receive
    // function reference as BinaryOperator
    // method add of BigInteger class
    return values
        .stream()
        .reduce(BigInteger.ZERO, BigInteger::add);
  }

  public static void main(String[] args) {
    System.out.println("REDUCE EXAMPLE");
    System.out.println();

    List<Integer> ints = List.of(21, -30, 0, 12, 121, -47, 44);
    System.out.println("Reduce with primitive type: int/Integer");
    System.out.println("Ints list: " + ints);
    System.out.println(String.format("Sum iterative: "  + sumIntegersIterative(ints)));
    System.out.println(String.format("Sum with reduce Functional: "  + sumIntegersFunctional(ints)));
    System.out.println();

    List<BigInteger> bigInts = List.of(
        new BigInteger("84982409482634630295780760372965234729652347296523423472965234"),
        new BigInteger("849824094823005823405235233469068956923526934"),
        new BigInteger("-695890236452352380520358023580258203582340"),
        new BigInteger("9025672965234956293653495692352693456782567825678243"),
        new BigInteger("253523452345234523453453452345234523452345234534"),
        new BigInteger("878345835878572575647675612369401235647090752315123509750325703750"),
        new BigInteger("-095824358203580979027507407589475987278945794758794579245792857"));
    System.out.println("Reduce with class: BigInteger");
    System.out.println("Big Ints list: " + bigInts);
    System.out.println(String.format("Sum iterative: "  + sumBigIntegersIterative(bigInts)));
    System.out.println(String.format("Sum with reduce Functional: "  + sumBigIntegersFunctional(bigInts)));
    System.out.println();
  }
}
