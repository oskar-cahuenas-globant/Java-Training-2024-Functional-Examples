/**
 * class for samples of optional class
 */
package com.globant.training.functional.optional;
import com.globant.training.functional.domain.PersonBasic;
import java.util.Optional;

public class OptionalExample {

  public static void main(String[] args) {
    System.out.println("BIFUNCTION EXAMPLES");
    System.out.println();

    /*
     * Note that Optional are not instantiated explicitly via new
     * but they are created via static constructor function
     */
    System.out.println("Creating optionals...");
    // creating an optional with a value
    Optional<PersonBasic> optPerson = Optional.of(new PersonBasic("Pedro", "123", "calle 100"));
    // creating an optional without value
    Optional<PersonBasic> optPerson2 = Optional.empty();

    System.out.println("Verifying if data is present");
    // verifying is optional is not empty
    if (optPerson.isEmpty()) {
      System.out.println("optPerson is empty");
    } else {
      System.out.println("optPerson has a value");
    }

    if (optPerson2.isPresent()) {
      System.out.println("optPerson2 is empty");
    } else {
      System.out.println("optPerson2 is empty");
    }
    System.out.println();

    // find value or throwing exception for optional
    System.out.println("Finding value of optional, it will thrown an exception if not found");
    try {
      System.out.println("Trying to find value in optPerson");
      // or else throw receive an exception
      String personAsString = optPerson
          .orElseThrow(() -> new RuntimeException("Person has no value!"))
          .toString();
      System.out.println("Person string value=" + personAsString);

    } catch (RuntimeException e) {
      System.out.println("optPerson has no value, exception detail=" + e.getMessage());
    }

    try {
      System.out.println("Trying to find value in optPerson2");
      // or else throw receive an exception
      String personAsString = optPerson2
          .orElseThrow(() -> new RuntimeException("Person has no value!"))
          .toString();
      System.out.println("Person string value=" + personAsString);

    } catch (RuntimeException e) {
      System.out.println("optPerson has no value, exception detail=" + e.getMessage());
    }
    System.out.println();

    // find value or getting a default exception for optional
    System.out.println("Finding value of optional, it will return an empty default value if no present");
    System.out.println("Trying to find value in optPerson");
    // default value could be gotten from supplier
    String personAsString = optPerson
      .orElseGet(() -> new PersonBasic("", "", ""))
      .toString();
    System.out.println("Person string value=" + personAsString);

    final PersonBasic defaultPersonaValue = new PersonBasic("", "", "");
    System.out.println("Trying to find value in optPerson2, or return the default value " + defaultPersonaValue);
    // default value could be gotten from a variable instead of a supplier as well
    personAsString = optPerson2
        .orElse(defaultPersonaValue)
        .toString();
    System.out.println("Person string value=" + personAsString);

    System.out.println();

    // optional with and without nullable values
    // trying to find optional from null will throw exception
    System.out.println("Trying to find optional value from null with Optional.of");
    try {
      PersonBasic personaExample = null;
      PersonBasic optionalNullable = Optional.of(personaExample).orElse(defaultPersonaValue);
      System.out.println("Optional returned = " + optionalNullable);
    } catch (RuntimeException e) {
      System.out.println("Exception thrown " + e);
      System.out.println("Optional.of fails when value is null");
    }
    System.out.println();

    // when an optional value will posibly be null, then
    // we must use Optional.ofNullable
    System.out.println("Trying to find optional value from null with Optional.ofNullable");
    try {
      PersonBasic personaExample = null;
      PersonBasic optionalNullable = Optional.ofNullable(personaExample).orElse(defaultPersonaValue);
      System.out.println("Optional returned = " + optionalNullable);
    } catch (RuntimeException e) {
      System.out.println("This should never be reached.");
    }

  }
}
