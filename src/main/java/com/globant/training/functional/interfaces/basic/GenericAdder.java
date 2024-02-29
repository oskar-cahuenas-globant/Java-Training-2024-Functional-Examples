/**
 * Example of functional interface with generic data type
 *
 * In {@link com.globant.training.functional.interfaces.basic.IntAdder} interface
 * we defined a contract for adding two integers.
 *
 * By using generics we are able to create a more general contract for the abstraction of
 * "add" any pair of values of any datatype given that
 * - Add is a "closed" operation, that is, adding two elements of a type must return a result of same type
 */
package com.globant.training.functional.interfaces.basic;

@FunctionalInterface
public interface GenericAdder <T>{
  T add(T value1, T value2);
}
