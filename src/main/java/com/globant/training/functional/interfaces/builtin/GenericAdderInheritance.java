/**
 * In this case we define a Generic Adder as the one in {@link com.globant.training.functional.interfaces.basic.GenericAdder}
 * but by reusing {@link java.util.function.BiFunction} interface, because and adder is an interface with
 * - An operation add with two parameters of the same type
 * - Returns a result of the same type
 * - We have operation like andThen (apply chained calls of the functions) and compose (create a function composition)
 *
 * The only difference is that method name will be `apply`
 *
 */
package com.globant.training.functional.interfaces.builtin;

import java.util.function.BiFunction;

@FunctionalInterface
public interface GenericAdderInheritance<X> extends BiFunction<X,X,X> {
  // there is not required to declare the method due to apply method is defined in BiFunctionInterface
}
