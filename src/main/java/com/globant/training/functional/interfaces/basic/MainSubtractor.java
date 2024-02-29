/**
 * Class for example of creation of instance of Functional interface
 * with FunctionalInterface annotation
 *
 * The code is almost the same than the class MainAdder.
 * The idea of this class is to show that functional interfaces work equally
 * regardless them have or not @FunctionalInterfaces annotation.
 */
package com.globant.training.functional.interfaces.basic;
public class MainSubtractor {

  /**
   * First form of implementing a functional interface
   * by creating an explicit class that implements it.
   * <p>
   * The class will be used as any other class.
   */
  static class ConcreteSubtractor implements IntSubtractor {
    @Override
    public int subtract(int value1, int value2) {
      return value1 - value2;
    }
  }

  /**
   * Second form of implementing a functional interface
   * by creating an anonymous class within a method.
   */
  static int subtractWithAnonymousClass(int x, int y) {
    System.out.println("begin method subtractWithAnonymousClass");
    // anonymous class defined inside the method
    // it is called "anonymous" because it has not declared
    // with a name it will be visible only in the scope of method.
    IntSubtractor subtractor = new IntSubtractor() {
      @Override
      public int subtract(int value1, int value2) {
        return value1 - value2;
      }
    };

    System.out.println("end method subtractWithAnonymousClass");
    return subtractor.subtract(x, y);
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
  public static void lambdaSubtractExample() {
    System.out.println("begin method lambdaSubtractExample");
    // values to be subtracted
    int v1 = 2500;
    int v2 = 1827;

    // way 1 use multiline notation
    IntSubtractor subtracterMultiline = (x, y) -> {
      int result = x - y;
      return result;
    };

    // Way 2 use single line notation
    // when method could be written as a
    // one-liner expression
    // you can see that "return" statement is omitted.
    IntSubtractor subtracterSingleLine = (x, y) -> x - y;

    // Way 3 use function reference
    // we know that Math class has a substractExact method
    // that performs subtraction of two integers
    // that add two Integer values
    // and by autoboxing feature, compiler converts
    // primitive datatypes to wrapper types and viceversa
    IntSubtractor subtracterFunctionReference = Math::subtractExact;

    // test adders
    // you could call method add, the only one defined in interface
    int result1 = subtracterMultiline.subtract(v1, v2);
    System.out.println(String.format("Subtract result of multiline adder %d - %d = %d",
        v1, v2, result1));

    int result2 = subtracterSingleLine.subtract(v1, v2);
    System.out.println(String.format("Subtract result of single line adder %d - %d =  %d",
        v1, v2, result2));

    int result3 = subtracterFunctionReference.subtract(v1, v2);
    System.out.println(String.format("Subtract result of function reference Math::subtractExact %d - %d =  %d",
        v1, v2, result3));


    System.out.println("end method lambdaSubstractExample");
  }

  public static void main(String[] args) {
    System.out.println("EXAMPLE OF FUNCTIONAL INTERFACE WITH @FUNCTIONALINTERFACE ANNOTATION");
    System.out.println("IntSubtracter is annotated with FunctionalInterface");

    int v1, v2;
    int result;
    System.out.println("Test Using explicit defined class");
    ConcreteSubtractor adderExplicit = new ConcreteSubtractor();
    v1 = 100;
    v2 = 47;
    result = adderExplicit.subtract(v1, v2);
    System.out.println(String.format("Subtract result with explicit class ConcreteSubtractor %d - %d = %d",
        v1, v2, result));

    System.out.println();
    System.out.println("Test using anonymous class inside method");
    v1 = 15;
    v2 = 33;
    result = subtractWithAnonymousClass(v1, v2);
    System.out.println(String.format("Subtract result with anonymous class %d - %d = %d",
        v1, v2, result));

    System.out.println();
    System.out.println("Test lambda notation");
    lambdaSubtractExample();
  }
}
