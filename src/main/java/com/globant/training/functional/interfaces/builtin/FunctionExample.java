/**
 * Examples for {@link java.util.function.Function} interface
 */
package com.globant.training.functional.interfaces.builtin;
import com.globant.training.functional.domain.Document;
import com.globant.training.functional.domain.DocumentType;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class FunctionExample {
  /**
   * Example of simple String --> String function
   * that converts string to Uppercase
   */
  public static void exampleSimpleFunctionString() {
    System.out.println("begin method exampleSimpleFunctionString");
    // function that transform to upper case a String
    // we use ternary operator ? : for the null case
    Function<String, String> toUpperCase = s -> s == null
        ? null
        : s.toUpperCase();
    String s = "hello World";
    String sUpper = toUpperCase.apply(s);
    System.out.println(String.format("String to Upper Case with function implementation: %s",  toUpperCase.apply(s)));
    System.out.println("end method exampleSimpleFunctionString");

  }

  /**
   * Example of Array of String --> String function that concatenates
   * all words of the array with a single space
   *
   * The idea is to show that parameter and result of a function could be different
   */
  public static void exampleFunctionArray() {
    System.out.println("begin method exampleFunctionArray");

    // in this case we define a function that receives an array of string
    // and return an array of strings with concatenacion of n Strings
    Function<String[], String> concatArrayWithSpaces = arr -> {
      final int n = arr.length;
      // Exercise What is a StringBuilder? Why is this class useful?
      StringBuilder result = new StringBuilder();

      // iterate for each element of array and concat it
      // Exercise: Implement this itearation with a functional stream operation
      for (int i = 0; i < n; i++) {
        result
            .append(arr[i])
            .append(' ');
      }
      return result.toString().trim();
    };

    final String[] words = new String[] {
        "hello",
        "my",
        "name",
        "is",
        "John",
        "Doe",
    };
    System.out.println("Elements of array: ");
    for (int i = 0; i < words.length; i++) {
      System.out.println(String.format("Element at position %d = %s", i, words[i]));
    }
    System.out.println("Concatenation of all words off array= " + concatArrayWithSpaces.apply(words));
    System.out.println("end method exampleFunctionArray");
  }

  /**
   * Example of a function with a custom user class
   *
   * In this case we take a {@link Document}
   * and return a string with the form TYPE-number issueDate=xxx, expDate=xxx
   *
   * Example (Cédula de ciudadanía does not have expiration date)
   * CC-11222333 issueDate=1990-01-01, expDate=null
   */
  public static void exampleFunctionCustomClass() {
    System.out.println("begin method exampleFunctionCustomClass");
    final Document cedulaCiudadania = new Document(DocumentType.CC,
        "122.333.444",
        LocalDate.of(2010, Month.MARCH, 30),
        null);
    final Document pasaporte = new Document(DocumentType.P,
        "Q99993344",
        LocalDate.of(2013, Month.MAY, 30),
        LocalDate.of(2023, Month.MAY, 29));

    Function<Document, String> documentFormatter = d -> {
      // if document is null an empty string is generated
      if (d == null) {
        return "";
      }
      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      // format the dates
      final String formatedIssueDate = d.getIssueDate() == null
          ? "null"
          : d.getIssueDate().format(formatter);
      final String formatedExpirationDate = d.getExpirationDate() == null
          ? "null"
          : d.getExpirationDate().format(formatter);

      return String.format("%s-%s issueDate=%s expirationDate=%s", d.getType(),  d.getNumber(), formatedIssueDate, formatedExpirationDate);
    };

    System.out.println("Converted Document Cedula ciudadania=" + documentFormatter.apply(cedulaCiudadania));
    System.out.println("Converted Document Pasaporte=" + documentFormatter.apply(pasaporte));
    System.out.println("end method exampleFunctionCustomClass");
  }

  /**
   * In this sample, some functions will be applied in a chain by using method andThen of
   * Function interface
   *
   * In this example we will concatenate function like
   * - Function<String, Integer> Coonvert string to integer
   * - Function<Integer, Integer>  Calculate 2 * X
   * - Function<Integer, Integer>  Calculate X + 5
   *
   *   To given a String with decimal digints
   *   convert string to integer X and then perform the calculation 2*X + 5
   */
  public static void exampleFunctionApplyConcatenation() {
    System.out.println("begin method sampleFunctionApplyConcatenation");
    // function to convert from stirng to integer as function reference
    final Function<String, Integer> stringToNumberConverter = Integer::valueOf;

    // function to given an integer return the double of the value
    final Function<Integer, Integer> duplicateValue = x -> 2 * x;

    // function to given an integer, return the integer plus 5
    final Function<Integer, Integer> valuePlusFive = x -> x + 5;

    // calculate 2 * x + 5 by concatenating function applications
    String numericValue = "125";
    Integer result =
        stringToNumberConverter     //first step convert to number
            .andThen(duplicateValue)  //multiply by two
            .andThen(valuePlusFive)  // add five
            .apply(numericValue);
    System.out.println(String.format("Calculation of 2 * %s + 5 using function concatenation is = %d",
        numericValue, result));
    System.out.println("end method sampleFunctionApplyConcatenation");
  }

  /**
   * In this sample, some functions will composited as mathematical definition of
   * Function composition
   *
   * In this example we will compose function
   * - Function<String, Integer> (convert string to integer)
   * - Function<Integer, Double> (convert integer to double)
   * - Function<Double, Double> (calculate logarithm of number)
   *- Function<Double, String> (format number to two digits)
   *
   */
  public static void exampleFunctionComposition() {
    System.out.println("begin method sampleFunctionComposition");
    // function to convert from stirng to integer as function reference
    final Function<String, Integer> stringToNumberConverter = Integer::valueOf;

    // function to convert Integer to Double
    final Function<Integer, Double> intToDoubleConverter = i -> i.doubleValue();

    // function to calculate neperian logarithm
    final Function<Double, Double> logarithm = Math::log;

    // function to format with 2 decimals
    final Function <Double, String> twoDecimalsFormatter = d -> String.format("%.2f", d);

    final String value = "150";

    // composition of function as java normal composition of methods
    final String resultPlainJava = String.format("%.2f", Math.log(Integer.valueOf(value).doubleValue()));

    // composition creating a composed Function vía functional interfaces
    // note that orden of application is inverse than the case of "function concatenation"
    Function<String, String> calculateLogarithmFromString =
        twoDecimalsFormatter // format to 2 decimals
            .compose(logarithm) // calculate logarithm
            .compose(intToDoubleConverter) // convert int to double
            .compose(stringToNumberConverter); // convert string to number

    System.out.println("Result of logarithm for plain Java expresion = " + resultPlainJava);
    System.out.println("Result of logarithm for function composition = "
        + calculateLogarithmFromString.apply(value));
    System.out.println("end method sampleFunctionComposition");
  }

  public static void main(String[] args) {
    System.out.println("FUNCTION EXAMPLES");
    System.out.println();
    exampleSimpleFunctionString();
    System.out.println();
    exampleFunctionArray();
    System.out.println();
    exampleFunctionCustomClass();
    System.out.println();
    exampleFunctionApplyConcatenation();
    System.out.println();
    exampleFunctionComposition();

  }


}
