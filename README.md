 # **Java Complete Guide** 


JDK: For development
JRE:  For running java app
JVM : Where byte code is run 

## How JVM works : 

* JVM is a part of JRE 
* We write .java code - > compiler changes it to bytecode(.class) and jvm runs the byte code
* JVM has 3 parts : class loader, run time areas and execution engine 
* Classloader : 3 steps : loading , linking and initialization 
* Loading : class loader loads the .class and store binary data in method area (class name + parent info)
* Linking :  verification : .class is verified  , preparation : allocate memory for class variables , resolution : replacing symbolic ref -> direct ref
* Initialization : all static variables are assigned with values 
* Classloaders :  Bootstrap , Extension , Application 
* Execution Engine : executes the byte code(interpreter , JIT , GC)
* The JIT compiler aids in improving the performance of Java programs by compiling bytecode into native machine code at run time.


## Object Oriented Programming in Java
* Java is not purely object oriented because it contains primitive data types as well
* Abstraction : Hiding implementation details 
* Encapsulation : wrapping data and code in a unit like a capsule
* Inheritance
    * Rules for method overriding 
        * Arg list should be same
        * Return type should be same or covariant
        * Access level should not be more restricted
        * final and static cannot be overridden 
        * Cannot throw broader checked exception
        * Constructors cannot be overridden 
    * Rules for method overloading 
        * Method name should be same
        * Arg list should be different 
        * Can have different return type 
        * Can have different access modifier
        * Can throw checked or unchecked exception
        * If arg list is same , method is considered duplicate by compiler 
    * Ambiguity in method overloading 
        * Widening over boxing : if int is passed and methods have long and Integer(long is called)
        * Widening over var args : passed (byte , byte) and methods (byte … a) and (int , int) : called (int , int)
        * Boxing beats var args
        * Cannot widen and then box - int cannot call Long 
        * Can box and then widen - int can call Object(int -> Integer -> Object
    * Interface can extend other interface
    * Instance variables cannot be overridden 
    * Covariant return type : child type can be returned for a method expecting parent return type(byte can be returned if int expected)
* Polymorphism : Object can be represented in many forms 
    * Static and dynamic(run time)  

## Basics : 
* Everything in java is treated as objects , Object is the super class of all classes except for interfaces
* Java is statically typed 
* Conditional operator  (condition) ? true : false
* Access modifiers : 
    * Public : accessed from anywhere 
    * Default : can be accessed only within the package 
    * Private :  can be accessed only in the class
    * Protected : can be accessed in same package and in different package in subclass through subclass ref 
