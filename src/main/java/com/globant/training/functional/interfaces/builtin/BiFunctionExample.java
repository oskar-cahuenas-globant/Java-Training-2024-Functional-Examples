/**
 * Examples for {@link java.util.function.BiFunction} interface
 */
package com.globant.training.functional.interfaces.builtin;
import com.globant.training.functional.domain.Color;
import com.globant.training.functional.domain.Document;
import com.globant.training.functional.domain.DocumentType;
import com.globant.training.functional.domain.Person;
import com.globant.training.functional.domain.Product;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.function.BiFunction;

public class BiFunctionExample {

  /**
   * Example simple bifunction of the sum of two values of several types.
   */
  public static void exampleSimpleBiFunctionString() {
    // Bi Function concatenate two Strings with a middle space
    BiFunction<String, String, String> concatenator = (x, y) -> {
      if (x == null && y == null) {
        return "";
      }
      if (x == null) {
        return y;
      }
      if (y == null) {
        return x;
      }
      return x + " " + y;
    };

    final String s1 = "HELLO";
    final String s2 = "MUNDO";
    System.out.println("String1 = " + s1);
    System.out.println("String1 = " + s2);
    System.out.println("Concatenation of s1 + s2=" + concatenator.apply(s1, s2));
  }


  /**
   * In this example we will apply the product of a vector by an scalar
   * a * (v1, v2, ..., vn) = (a * v1, a * v2, ..., a * vn)
   */
  public static void exampleProductVectorByScalar() {
    System.out.println("begin method exampleProductVectorByScalar");
    // optionally in lambda notation paramter types could be added in signature
    // for the sake of readability
    BiFunction<Double, Double[], Double[]> vectorScalarProduct = (Double a, Double[] v) -> {
      // result vector
      Double[] result = new Double[v.length];
      // excersice convert loop to functional
      int i = 0;
      for (Double d : v) {
        result[i++] = a * d;
      }
      return  result;
    };

    // Define vectors to sum
    final Double v[] = {1.2D, 3.5D, -20D, 3D};
    final Double a = 2.5D;
    final Double[] result = vectorScalarProduct.apply(a, v);
    System.out.println(String.format("Product of scalar %f and vector %s  = %s",
        a,
        Arrays.toString(v),
        Arrays.toString(result)));
    System.out.println("end method exampleProductVectorByScalar");
  }

  /**
   * Example of a BiFunction of two custom classes
   * A Person and a Product
   * and return an string with a price quotation (cotización) del producto
   */
  public static void examplePriceQuotation() {
    System.out.println("begin method examplePriceQuotation");
    final Product trousers = new Product(
        "Lee Lady Jean",
        "Women Blue Jean size M",
        Color.BLUE,
        123500.65);
    final Person client = new Person(
        "Maria Gonzalez",
        new Document(
            DocumentType.CC,
            "1.124.999.999",
            LocalDate.of(2010, Month.JANUARY, 20),
            null),
        "calle 100 #75a-30");

    // function to create a string with a report with quotation for one client and one product
    final BiFunction<Person, Product, String> cotizador = (person, product) -> {
      // create string of person
      final String personString = String.format("- Document: %s - %s\n- Name: %s\n- Address: %s",
          client.getDocument().getType(),
          client.getDocument().getNumber(),
          client.getName(),
          client.getAddress());

      // exercise: What a heck is a numberformat?
      final NumberFormat formatter = NumberFormat.getCurrencyInstance();

      final String productDetail = String.format(
          "- Product: %s\n- Description: %s\n- Color: %s\n- Unit price %s\n- Tax(19%%) %s\n- Total %s",
          trousers.getName(),
          trousers.getDescription(),
          trousers.getColor().getColorName(),
          formatter.format(trousers.getPrice()),
          formatter.format(trousers.getPrice() * 0.19D),
          formatter.format(trousers.getPrice() * 1.19D));

      final String quotationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      return "QUOTATION\n"
          + "------------------------------\n"
          + "Date: "
          + quotationDate
          + "\n"
          + "------------------------------\n"
          + "Client: \n"
          + personString
          + "\n\n"
          + "------------------------------\n"
          + "Product Detail:\n"
          + productDetail;
    };

    System.out.println("Quotation for client:");
    System.out.println(cotizador.apply(client, trousers));
    System.out.println("end method examplePriceQuotation");
  }

  public static void main(String[] args) {
    System.out.println("BIFUNCTION EXAMPLES");
    System.out.println();
    exampleSimpleBiFunctionString();
    System.out.println();
    exampleProductVectorByScalar();
    System.out.println();
    examplePriceQuotation();
  }




}
