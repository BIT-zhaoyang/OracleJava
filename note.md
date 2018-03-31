> Ref: https://docs.oracle.com/javase/tutorial/

Java technology consists of two parts:
Java programming language
Java platform

Platform is usually a combination of both hardware and software. Java platform is pure software. It isolates the source code from the underlying hardware. Java platform consists of two parts, the JVM and the provided API.

# Object-Oriented Programming Concepts
## What is an Object?
* Real-world objects share two characteristics: They all have _state_ and _behavior_.
* In programming, _states_ is stored in _fields_, _behavior_ is exposed through _methods_. Methods operate on an object's internal state and serve as the primary mechanism for object-to-object communication. Hiding internal state and requiring all interaction to be performed through an object's methods is known as _data encapsulation_.

## Inheritance VS Interface
Inheritance focus on expressing the common part, including both fields and methods. These part is exactly the same to all subclasses. Interface focus more on the behavior. It defines what should be done. It expresses a certain convention of interaction.

## What is a Package?
Package is a collection of **related**(in terms of functionality) classes and interfaces, placed together. 

#Language Basics
## Variables
Variables can be divided into following categories:

* Instance Variable(Non-Static Fields)
* Class Variable(Static Fields)
* Local Variables
* Parameters Variable

If we say variables, we are talking about all above four cases. If we say fields, we are talking about the first two cases. A type's fields, methods, and nested types are collectively called its members.

### Primitive Data Types
Java has eight primitive data types in total: 

* byte
* short
* int
* long
* float
* double 
* boolean 
* char

Primitive types are built into the language. They are not objects created from a class. **String** is not primitive data type. Enclosing character string within double quotes automatically create a new `String` object. `String` objects are immutable. (**Question: How is number represented in computer?**)

**Default Values**  
Java will assign default values to fields, but it will **NOT** assign default value to local variables. In fact, accessing uninitialized local variable will result in compile-time error. All fields will be given default value, if not initialized, no matter whether the field is a primitive type or not.

## Arrays
An array is a container **object**. Thus, we need to use the `new` operator to create an array, or use the shortcut syntax to provide arrays element directly.
(**Question: What is the relationship between `Array` and `System` class? Look up the diagram**)


