package com.globant.training.functional.interfaces.basic;

/**
 * This interface has a single operation contract to add a pair of integers.
 *
 * An interface with only ONE not implemented method is a functional interface
 *
 * Annotation @FunctionalInterface is optional
 */
public interface IntAdder {
  int add(int value1, int value2);
}
