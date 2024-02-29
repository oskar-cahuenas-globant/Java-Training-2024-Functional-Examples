/**
 * Examples for {@link java.util.function.Supplier} interface
 */
package com.globant.training.functional.interfaces.builtin;
import com.globant.training.functional.domain.PersonBasic;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
  // names of people
  private static final List<String> HUMAN_NAMES = List.of(
      "Pedro",
      "Juan",
      "Camilo",
      "Mario",
      "Ana",
      "Luisa",
      "Daniela",
      "Rubén",
      "Mariana",
      "Jose");

  // last names of people
  private static final List<String> HUMAN_LAST_NAMES = List.of(
      "Ariza",
      "Perez",
      "Jimenez",
      "Gonzalez",
      "Restrepo",
      "Escobar",
      "Dangond",
      "Hernandez",
      "Gaviria",
      "Valencia",
      "Ortiz",
      "Jaimes");

  // random number generator
  private static final Random RANDOM_GENERATOR = new Random();

  public static void exampleSupplyRandomPeopleData(int numberPeople) {
    System.out.println("end method exampleSupplyRandomPeopleData");
    // supplier for a random person name
    // consist of random name and random last name
    final Supplier<PersonBasic> personDataGenerator = () -> {
      // random name and last name from list
      final String name = HUMAN_NAMES.get(RANDOM_GENERATOR.nextInt(HUMAN_NAMES.size()));
      final String lastName = HUMAN_LAST_NAMES.get(RANDOM_GENERATOR.nextInt(HUMAN_LAST_NAMES.size()));
      // random addres between cra and calle
      final boolean randomStreet = RANDOM_GENERATOR.nextBoolean();
      final int random1 = RANDOM_GENERATOR.nextInt(200);
      final int random2 = RANDOM_GENERATOR.nextInt(200);
      final int random3 = RANDOM_GENERATOR.nextInt(100);
      final String randomAddress;
      if (randomStreet) {
        randomAddress = "Calle " +  random1 + " #" + random2 + "-" + random3;
      } else {
        randomAddress = "Cra. " +  random1 + " #" + random2 + "-" + random3;
      }
      final String randomDocument = "CC-" + RANDOM_GENERATOR.nextLong(200000,150000000);

      // supplier generate random person data
      // used for testing, for example
      return new PersonBasic(
          name + " " + lastName,
          randomDocument,
          randomAddress);
     };

    // use supplier for generating random people
    System.out.println("Generating " + numberPeople + " random people Data");
    for (int i = 0; i < numberPeople; ++i) {
      System.out.println("Person " + (i + 1) + ": " + personDataGenerator.get());
    }

    System.out.println("end method exampleSupplyRandomPeopleData");
  }

  public static void main(String[] args) {
    System.out.println("CONSUMER EXAMPLES");
    System.out.println();
    exampleSupplyRandomPeopleData(15);
  }
}
