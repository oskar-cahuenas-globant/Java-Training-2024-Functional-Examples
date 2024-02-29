package com.globant.training.functional.interfaces.basic;

/**
 * This interface has a single operation contract to substract a pair of integers.
 *
 * In this case @FunctionalInterface is used
 *
 * - informative annotation to show the intention of interface,
 * in order that code keeps self-documented
 *
 * - Raises a compilation error if somebody tries to modify the interface
 * by appending more methods.
 *
 * - Security, if an interface is annotated with @FunctionalInterface
 * developers are aware that the method should be used in lambda notation
 * in other classes that depend of interface, hence, avoid to change the code.
 *
 */
@FunctionalInterface
public interface IntSubtractor {
  int subtract(int value1, int value2);
}
