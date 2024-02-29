/**
 * Examples for {@link java.util.function.Consumer} interface
 */
package com.globant.training.functional.interfaces.builtin;
import com.globant.training.functional.domain.Color;
import com.globant.training.functional.domain.Product;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
  /**
   * Example of a simple consumer that prints out a product
   */
  public static void exampleConsumerPrettyPrintList() {
    List<Product> productCatalog = List.of(
        new Product(
            "Lee Lady Jean",
            "Women Blue Jean size M",
            Color.BLUE,
            123500.65),
        new Product(
            "Fantasy Blouse",
            "Women short sleeve blouse size M",
            Color.GREEN,
            95900.),
        new Product(
            "Black Deni,",
            "Men Black Jean size 38",
            Color.BLACK,
            133500.99),
        new Product(
            "Comic T-Shirt",
            "Unisex Tee Shirt comic XL",
            Color.RED,
            65000.25));

    Consumer<Product> productPrettyPrinter = p -> {
      final String productStr = String.format("Name: %s, Description %s, Color %s, Price %,.2f",
          p.getName(),
          p.getDescription(),
          p.getColor().getColorName(),
          p.getPrice());
    };

    // iterate each element of list
    // and "consume" the value
    System.out.println("Consuming all elements of the catalog");
    for (Product p : productCatalog) {
      productPrettyPrinter.accept(p);
    }
  }

  public static void main(String[] args) {
    System.out.println("CONSUMER EXAMPLES");
    System.out.println();
    exampleConsumerPrettyPrintList();
  }
}
