# Streams Operators

## Reduce
More specifically, reduction stream operations allow us to produce one single result from a sequence of elements, 
by repeatedly applying a combining operation to the elements in the sequence.

## Stream
One of the major new features in Java 8 is the introduction of the stream functionality – java.util.stream – which contains classes for processing sequences of elements.

## Interface Default and Static Methods
Before Java 8, interfaces could have only public abstract methods. It was not possible to add new functionality to the 
existing interface without forcing all implementing classes to create an implementation of the new methods, nor was it possible 
to create interface methods with an implementation.

Starting with Java 8, interfaces can have static and default methods that, despite being declared in an interface, have a defined behavior.

## Method references
Method reference can be used as a shorter and more readable alternative for a lambda expression that only calls an existing method. 
There are four variants of method references.

## Optional <T>
Java 8 Optional<T> class can help to handle situations where there is a possibility of getting the NPE. It works as a container for the object of type T. 
It can return a value of this object if this value is not a null. When the value inside this container is null, it allows 
doing some predefined actions instead of throwing NPE.

## Conclusion
The Stream API is a powerful, but simple to understand set of tools for processing the sequence of elements. When used properly, 
it allows us to reduce a huge amount of boilerplate code, create more readable programs, and improve an app’s productivity.

In most of the code samples shown in this article, we left the streams unconsumed (we didn’t apply the close() method or a 
terminal operation). In a real app, don’t leave an instantiated stream unconsumed, as that will lead to memory leaks.