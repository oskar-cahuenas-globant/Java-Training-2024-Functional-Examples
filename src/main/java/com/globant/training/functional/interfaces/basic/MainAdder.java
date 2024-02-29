/**
 * Class for example of creation of instance of Functional interface
 */
package com.globant.training.functional.interfaces.basic;
public class MainAdder {
  /**
   * First form of implementing a functional interface
   * by creating an explicit class that implements it.
   * <p>
   * The class will be used as any other class.
   */
  static class ConcreteAdder implements IntAdder {
    @Override
    public int add(int value1, int value2) {
      return value1 + value2;
    }
  }

  /**
   * Second form of implementing a functional interface
   * by creating an anonymous class within a method.
   */
  static int addWithAnonymousClass(int x, int y) {
    System.out.println("begin method addWithAnonymousClass");
    // anonymous class defined inside the method
    // it is called "anonymous" because it has not declared
    // with a name and it will be visible only in the scope of method.
    IntAdder adder = new IntAdder() {
      @Override
      public int add(int value1, int value2) {
        return value1 + value2;
      }
    };

    System.out.println("end method addWithAnonymousClass");
    return adder.add(x, y);
  }

  /**
   * Third form of implementing a functional interface
   * by using lambda literal notation
   * <p>
   * Lambda notation is of the way
   * <p>
   * 1) (p1, p2, ..., pn) -> {
   * //normal body of a method
   * // optional if function is not void
   * // it must return a result
   * return result;
   * }
   * <p>
   * 2) (p1, p2, ... ,pn) -> result of procesing
   * This brief notation is used when the function body
   * is a one-liner expression
   * <p>
   * 3) ClassName::methodName when the method is a visible in-scope function
   * and has exactly the same signature of functional method, this is known as
   * "function reference"
   * <p>
   * In this case a lambda is a "syntax sugar
   */
  public static void lambdaAddExample() {
    System.out.println("begin method lambdaAddExample");
    // values to be summed
    int v1 = 25;
    int v2 = 30;

    // way 1 use multiline notation
    IntAdder adderMultiline = (x, y) -> {
      int result = x + y;
      return result;
    };

    // Way 2 use single line notation
    // when method could be written as a
    // one-liner expression
    // you can see that "return" statement is omitted.
    IntAdder adderSingleLine = (x, y) -> x + y;

    // Way 3 use function reference
    // we know that Integer class has a sum method
    // that add two Integer values
    // and by autoboxing feature, compiler converts
    // primitive datatypes to wrapper types and viceversa
    IntAdder adderFunctionReference = Integer::sum;

    // test adders
    // you could call method add, the only one defined in interface
    int result1 = adderMultiline.add(v1, v2);
    System.out.println(String.format("Add result of multiline adder %d + %d = %d",
        v1, v2, result1));

    int result2 = adderSingleLine.add(v1, v2);
    System.out.println(String.format("Add result of single line adder %d + %d =  %d",
        v1, v2, result2));

    int result3 = adderFunctionReference.add(v1, v2);
    System.out.println(String.format("Add result of function reference Integer::sum %d + %d =  %d",
        v1, v2, result3));


    System.out.println("end method lambdaAddExample");
  }

  public static void main(String[] args) {
    System.out.println("EXAMPLE OF FUNCTIONAL INTERFACE");
    System.out.println("IntAdder not annotated with FunctionalInterface");

    int v1, v2;
    int result;
    System.out.println("Test Using explicit defined class");
    ConcreteAdder adderExplicit = new ConcreteAdder();
    v1 = 100;
    v2 = 47;
    result = adderExplicit.add(v1, v2);
    System.out.println(String.format("Add result with explicit class ConcreteAdder %d + %d = %d",
        v1, v2, result));

    System.out.println();
    System.out.println("Test using anonymous class inside method");
    v1 = 15;
    v2 = 33;
    result = addWithAnonymousClass(v1, v2);
    System.out.println(String.format("Add result with anonymous class %d + %d = %d",
        v1, v2, result));

    System.out.println();
    System.out.println("Test lambda notation");
    lambdaAddExample();
  }
}
