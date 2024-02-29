# Package `com.globant.training.functional.interfaces.basic`
In this package you will find three basic examples of Funcitonal Interface definition

## Int Adder
Interface `IntAdder` and class `MainAdder` a simple example of a functional interface without @FunctionalInterface
annotation, that defines the contract of adding two integers, annotation.

In Main program's class examples are provided for the following scenarios of interface use:
- Explicit class implementation.
- Anonymous class.
- Lambda literal notation.
 
## Int Subtractor
Interface `IntSubtractor` and class `MainSubtractor` provide example of a functional interface with `@FunctionalInterface`
annotation, that defines the contract of adding two integers, annotation.

In Main program's class examples are provided for the following scenarios of interface use:
- Explicit class implementation.
- Anonymous class.
- Lambda literal notation.

The idea of this example is to show that `@FunctionalInterface` doesn't change the behavior of the interface implementations.

## Generic Adder
Interface `GenericAdder` and class `MainGenericAdder` provide an example quite similar to `IntAdder` interface, but in this 
case, the interface defines an abstract contract to a `add` operation for any class. The idea of an add operation in general is 
that:

- Is closed: That is, if `a` and `b` are elements of class `X` then `a + b` must be an instance of `X`
- Is conmutative: `a + b == b + a`
- Is associative: `a + (b + c) = (a + b) + c`

The two last properties are not set by interface per-se, but implementations ideally should respect them.

In the main example we can find examples of sum for Integers and Vectors, for illustrating the concept of a funtional 
interface for generic types.
