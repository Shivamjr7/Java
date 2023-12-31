 # **Java Complete Guide** 


JDK: For development JRE:  For running java app JVM : Where byte code is run 

** ** 

## How JVM works : 

* JVM is a part of JRE 
* We write .java code - > compiler changes it to bytecode(.class) and jvm runs the byte code
* JVM has 3 parts : class loader, run time areas and execution engine 
* Classloader : 3 steps : loading , linking and initialization 
* Loading : class loader loads the .class and store binary data in method area (class name + parent info)
* Linking :  verification : .class is verified  , preparation : allocate memory for class variables , resolution : replacing    symbolic ref -> direct ref
* Initialization : all static variables are assigned with values 
* Classloaders :  Bootstrap , Extension , Application 
* Execution Engine : executes the byte code(interpreter , JIT , GC)
* The JIT compiler aids in improving the performance of Java programs by compiling bytecode into native machine code at run time.(to explore how it does that)
* Each JVM instance has one method area and one heap. These are shared by all threads inside JVM
* A class file keeps all its symbolic references in one place, the constant pool.
* For every thread JVM creates a stack at the time of thread creation . JVM only performs 2 operations on stack - push and pop 
* Each entry is stack is called stack frame 
* Stack frame has local variable array(each slot is of 4 bytes) , operand stack(rough work area for JVM) and frame data (symbolic ref)
* Frame data also contains ref to the Exception table which provides the catch block info
 
** ** 

## Object Oriented Programming in Java
* Java is not purely object oriented because it contains primitive data types as well
* Abstraction : Hiding implementation details (only essential details are displayed to the user)
* Encapsulation : wrapping data and code in a unit like a capsule (variables and data are hidden from other class and is accessible only through getters/setters)
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
        * Can box and then widen - int can call Object(int -> Integer -> Object)
    * Interface can extend other interface
    * Instance variables cannot be overridden 
    * Static and private methods cannot be overridden (static is for class and private is restricted to class)
    * No arg constructor of superclass is called by default 
    * super to call superclass constructor  
    * Covariant return type : child type can be returned for a method expecting parent return type(byte can be returned if int expected)
    * Interface vs Abstract class (java 8 )
        * Abstract class can have non final and non static variables as well
        * Interfaces don’t support final methods
        * Interfaces can’t have constructors
        * Interfaces don’t support private and protected members 
        * Nested interface is by default static . They are used only if you want to access it through top level class or interface 
* Polymorphism : Object can be represented in many forms 
    * Static and dynamic(run time)  
** ** 

## Basics : 
* Everything in java is treated as objects , Object is the super class of all classes except for interfaces
* Java is statically typed (type of variable is known at compile time)
* Conditional operator  (condition) ? true : false
* Access modifiers : 
    * Public : accessed from anywhere 
    * Default : can be accessed only within the package 
    * Private :  can be accessed only in the class
    * Protected : can be accessed in same package and in different package in subclass through subclass ref (not through superclass ref)
* A Constructor in java cannot be abstract , final , static and synchronized 
* The JVM ensures that only one thread can invoke a constructor call at a given point in time
* Ways of creating object in java
    * Using new keyword
    * Class.forName.newinstance()
    * Using clone method
    * Using deserialisation 
    * class.getDeclaredConstructor().newinstance()
* Cloning
    * Shallow copy : reference will be same for the copied object
    * Deep copy :  a complete copy of the object including copy of the variables contained 
    * You can make a deep copy using copy constructors 
    * Object.clone is broken - to check in detail 
    * Deep copy can be done using serialisation and deserialisation   
* final var value cannot be changed , final class cannot be subclassed or extended , final method cannot be overridden
* finally block executed after try/catch , from java 1.7 try with resources is used which doesn’t require finally block 
* finalize is called on an object before it is garbage collected (not necessary it will be called )
* System gives us access to standard IO streams (out , in , err)
* ClassCastException : If the real object doesn't match the type we downcast to, then ClassCastException will be thrown at runtime.
* A reference is like a remote control to an object. The remote control has more or fewer buttons depending on its type, and the object itself is stored in a heap. When we do casting, we change the type of the remote control but don’t change the object itself. Upcasting we have less buttons and down casting more.
* Path separator in classpath for windows is semicolon and in unix is colon

** ** 

## Wrapper Classes:

* To convert data types to object . Most collections work on objects so Wrapper class is required 
* Autoboxing : converting primitive type -> Object
* As of Java 9 constructor for many boxed primitives have been deprecated so static factory methods can be used 
* Each wrapper class stores a list of commonly used instances of its own type in form of cache . Caching is only available when we use valueOf or direct assignment and not in case of new keyword
* Wrapper class implement object pooling to cache values(Integer cache value from -128 to 127 , character from 0 to 127)

** ** 

## Garbage Collection 
* Objects are stored in heap memory of Java , static members are stored in method area 
* When a object becomes out of reach or doesn’t have a live ref , it is eligible for GC 
* Garbage collection is done by daemon thread. We cannot force gc by calling System.gc()
* Mark : Starts from root node of app , performs a DFS and marks the object reachable as live
* Delete/Sweep : All those objects which are unreachable are removed from heap 
* Compacting : It is a process of arranging everything in order. Arranges object in memory so that there are no holes left by removed objects.This is a time taking process
* Heap is divided into Young and Old (Tenured) generation. Young generation again is divided into 3: Eden , S1 and S2
* Eden is the space where new objects are placed. When Eden space is full a minor GC runs and moves all live objects to survivor space(S1)
* Once the objects which have survived the threshold no of GC cycles , they are moved to Old GC
* -XX:MaxTenuringThresold : specifies the threshold for objects which to survive to move to Old GC
* Once Old GC is about to get full , major GC is run is does GC (mark/sweep/compact) for the complete heap
* Types of garbage collectors : Serial , Concurrent , Parallel , G1GC
* Serial GC runs in a single thread and pauses the app in case of major GC
* Concurrent GC runs side by side with application and only pauses application for mark/remark steps. Sweep and compact doesn’t pause the application
* Parallel GC runs when  the memory is full and runs the steps in parallel threads so not taking much time
* Use Concurrent GC when there is more memory , high number of CPUs and application demands short pauses  ,less latency 
* Use Parallel GC when there is less memory , lesser number of CPUs and application demands high throughput(no of tasks done at a time) and can withstand pauses.
* G1 divides the heap into small memory regions and if it sees a particular region going full it performs GC on that small region in parallel thread. It combines both concurrent and parallel GC and is called as garbage first
* -XX:+UseSerialGC: Single threaded GC on young and old gen
* -XX:+UseParallelGC: Parallel threads on young gen . Old gen uses Serial GC
* -XX:+UseParallelOldGC : Both young and old gen uses parallel threads 
* -XX:+UseParNewGC: Multi threaded young gen GC
* -XX:+UseConcMarkSweepGC: enables concurrent collector. This is only for old gc 
* -XX:+UseG1GC: Use G1

** ** 

## Memory Management:
* Memory leak : In general, a Java memory leak happens when an application unintentionally (due to logical errors in code) holds on to object references that are no longer required
* Excessive usage of static fields can potentially lead to a memory leak. In Java, static fields usually remain in memory as long as the application is running
* Also, when using singletons, the lazy loading design pattern can be used so that resources are only initialized when they are needed.
* Resources such as connections and streams utilize memory. If they are not closed, memory allocated to these resources is blocked and the GC is unable to free up this space.
* Correctly override equals and hashcode . Duplicate entries take up space and gc cannot collect them.
*  Another example is of using an ORM tool like Hibernate, which uses equals() and hashCode() methods to analyze the objects and saves them in the cache
* Non static inner class prevents outer class instance from being garbage collected (use static inner class)
* For Java 1.6 and below : If we read a huge massive String object, and call intern() on that object, then it goes to the string pool, which is located in PermGen (permanent memory) and will stay there as long as our application runs.
* Use Threadlocal.remove() else thread local will stay in thread pool 

** ** 

## Network Programming in Java

* Java Networking is a notion of connecting two or more computing devices together to share the resources
* Why do we need sockets ? We can connect two machines with the help of sockets 
* For every client Server creates a socket(ServerSocket) so client can connect to server
* A socket is bound to a port number so that the TCP layer can identify the application that data is destined to be sent to.
* Even though the Java Networking APIs enable you to open and close network connections via sockets, all communication happens via the Java IO classes InputStream and OutputStream.
* So using networking we can connect client and server and can use IO/NIO for communicating 
* Only one incoming connection is opened for each call to the  ServerSocket accept() method.
* The InetAddress is Java's representation of an IP address

** ** 

## Java IO 

* A stream is a endless flow of data (byte based or character based)
* To read data from source you need InputStream and to write data to destination you need OutpustStream
* To read from file we can use FileInputStream(bytes) / FileReader(chars)
* To write to a  file we can use FileOutputStream(bytes) / FileWriter(chars)
* JAVA IO streams are flow of data you can read to or write into
* To read faster or write blocks we use BufferedStream 
* Pipes in Java IO provides the ability for two threads running in the same JVM to communicate. The data written to the PipedOutputStream by one thread can be read from the connected PipedInputStream by another thread.
* Java Networking API is being used to establish a network connection between processes, Java IO is being used to exchange data between the processes once the connection is established.
* Arrays are common source or destination of data (file data , network data …) . You can read/write array data with input/output streams
* You can change the streams of System streams (for ex changing system.out to write to file instead of console)
* Always close the stream , if close()  can throw exception , wrap it in try/catch , use exception handling template  or use try with resources
* Reading an array of bytes at a time is faster than reading a single byte at a time from a Java InputStream.
* Scanner class can read formatted input from console(System.in) (can read int , char 

** ** 

## Java NIO (New Java IO) 
### (to read and write in non blocking way)


* NIOs main components : Channels , Buffers and Selectors 
* Channel is like a stream. Data from channel can be read from and written to a buffer.
* Buffers are containers for data 
* A selector allows a single thread to handle multiple channels. You can register multiple channels with a selector (basically a selector can monitor multiple channel for events or data coming in the channel)
* Buffers are memory blocks where we can read/write data 
* Buffer.flip() is used to switch between read and write modes in buffer. You can mark a given postn using mark method and also reset it 
* A scattering read from a channel is a read operation that reads data into more than one buffer. Thus, the channel "scatters" the data from the channel into multiple buffers.
* A gathering write to a channel is a write operation that writes data from more than one buffer into a single channel.
* In other words, if you have a header and a body, and the header is fixed size (e.g. 128 bytes), then a scattering read works fine.
* In Java NIO you can transfer data directly from one channel to another, if one of the channels is a FileChannel
* The Java NIO Selector is a component which can examine one or more Java NIO Channel instances, and determine which channels are ready for e.g. reading or writing. This way a single thread can manage multiple channels, and thus multiple network connections.
* In case of large bytebuf we can allocate direct memory and use using allocateDirect() method. This will store byte buf in direct memory instead of heap
* For scattering read and write use ScatteringByteChannel . Scattering read and write is only used to handle fixed size messages
* MappedByteBuffer : maps a file to memory . Creates a buffer in main memory of JVM
* To convert ByteBuffer to CharBuffer we need to use char set. This uses decoder and encoder. To decode bytes to char we need charsets

** ** 

## Java NIO2

* Provides access to the file system directly
* Why do we need Java Nio2 : it increases performance when dealing with file systems
* Can handle very large directories
* A file system in NIO is abstraction of real file system and bound to schema (file://)
* FileSystemProvider acts as factory for file systems
* A directory stream is a way of analysing the content of a directory .It can get all the content and filter the content 
* JDK follows DFS to look for dir and sub dirs. Files.walk to do dfs in a directory path. Can also give max depth to be traversed

** ** 

## Exceptions 

* A unwanted or unexpected event is called an exception 
* Error indicates some problem which your application don’t have control over 
* Exception and Error are subclasses of Throwable class . During exception an object of throwable or subclass is created and handed to runtime system(JVM) . Exception object contains name and description of the exception and current state of program 
* JVM looks for the exception handler through call stack and gives exception object to appropriate handler . If it cannot find a handler it gives it to default handler.
* We can either handle the exception or throw the exception 
* throws keyword specifies what all exception a method can throw 
* There are 2 types of exception : Checked and unchecked 
* Checked exceptions are those which must be handled in the code (using try/catch or throws keyword). Compiler knows sometime that the code can throw exception and forces us to handle them example : FileNotFoundException(file may not be present) , IOException 
* Unchecked exceptions are those which are not checked at compile time. Also called as Runtime Exception
* Put every code that can throw exception in its own try/catch block
* try-with-resources(from java 1.7) : introduced so resources declared will be closed after execution of try block . No need to close resources in finally but finally can be used for other purpose. Resources declared has to implement AutoClosable interface
* Resources that were defined first will be closed last 
* From Java 9 final or effectively final variables inside try with resources 
* Java 7 introduced ability to catch multiple exception separated by a pipe. If a catch block handles more than one exception type , the catch parameter is implicitly final. Do not declare same hierarchy exception in the same multi catch block
* Don’t try to swallow an exception - bad practice
* Best Practices 
    * Exception Translation : It is appropriate to translate an exception in cases when lower layer can be changed and we don’t want to reflect it in higher layers example : How data is stored can be changed from text file to RBDMS causing exception to change from IOException to SQLException . To avoid changein upper layers above data layer we can wrap it in a generic DataAccessException
    * Pass all relevant data to exceptions .Uninformative stack traces are very frustrating for the maintainer, and have been known to inspire unpleasant cursing.
    * Use template for repeated try/catch
    * Avoid empty catch blocks 

** ** 

## Multithreading  and Async Programming
* Parallelism is doing multiple things at the same time. Dividing a single task to multiple subtasks and then doing each task sequentially in a cpu core. Fork and Join. Needs multiple cores to do parallelism
* Concurrency is dealing with lot of things at once. Thread1 runs than for some time then thread2 runs and goes on as done by scheduler. In concurrency resources are shared and multiple threads needs to coordinate with help of locks , synchronization. 
* Green threads are scheduled by VM and Native threads are scheduled by OS.Java works with native threads
* To make a thread in Java : extend Thread class or implement Runnable interface : later is a good option 
* Lifecycle of thread : New(created but not started) , Runnable (may run depends on scheduler), Blocked/Waiting , Timed Waiting , terminated
* ThreadLocal is the concept of having variables specific to a thread
* Race condition : When 2 or more threads access a shared variable and read/write the shared variables concurrently. In this case we can have unexpected results because multiple threads are trying to change the same variable
* Callable is task which returns a value and can throw exception unlike Runnable where we cannot get the result
* Future is the placeholder and is returned when we submit a callable task. To get the result once task complete we can say future.get() which is a blocking call
* Join method : Once join is called on a thread , then that thread will run before main thread can resume   
* Wait - notify : for inter thread communications , threads communicating have to be synchronized on the same object. It makes sense to have a shared object to communicate as both can call wait and notify on the same shared object.
* For communication between threads , there should proper communication so wait and notify have to be called from synchronized block
* When wait is called on a thread , it releases the lock so other thread can run and call notify.
* Volatile: Use volatile when you want to solve visibility problem between threads. Generally used when threads share some flag
* Use Atomic when doing compound operation like incrementing a counter.
* Java memory model is a specification which guarantees visibility of fields (happens before) amidst reordering of instructions.
* Happens before : Whatever has happened before writing to volatile variable in one thread should be visible in another thread after reading of the volatile variable. This is also applicable to synchronised , locks , concurrent collections , Thread operations(join , start)
* A Process is a single unit of execution whereas threads run within a process and shares memory.
* Process uses IPC and thread uses wait , notify for communication
* For CPU Intensive tasks : No of threads in thread pool  should be equal to the number of cores
* For IO tasks :Thread pool size > No of cores
* Fork/Join framework is designed for data parallelism . Parallel streams in java 8 are designed to solve data parallelism
* Executor service is designed for task parallelism
* Recursive Task : Fork join tasks that return a value
* In Parallel streams , when you run task , the no of task running in parallel is equal to the number of cpu cores in your machine
* Parallel Streams : How it works ?
    * Splits the data into chunks : Data source is split into small data chunks for example : List is split to size 1 by Spliterator 
    * Execute the data chunks : Data chunks are applied to stream pipeline : intermediate operations are executed in Common Forkjoin pool
    * Combine the result
* Each and every collection has a Spliterator implementation 
* Certain operators take more time when ran in parallel streams . Also if your computation involves boxing and unboxing then it will take more time in parallel streams
* Common fork join pool is used by parallel streams and completable future
* CompletableFuture
    * CompletableFuture is an Asynchronous Reactive Functional Programming API . It allows us to write async code in functional style
    * Solves the limitation of future api 
    * Factory methods : Initiate async computation
    * Completion stage methods : chain async computation
    * Exception methods : handle exceptions in an async computation
    * Functions :
        * supplyAsync: Factory method , initiate async operation , I/p is supplier function , returns CompletableFuture<T>() , use if you want something which returns a result
        * thenAccept: completion method , chain async operation , I/p is consumer function , return CompletableFuture<Void>() , to perform any operation on the result 
        * thenApply : completion method , can access the result of previous async computation and then act on it . Used to transform data from one form to another . Input is a Function function  , returns CompletableFuture<T>()
        * thenCombine : completion stage method , used to combine multiple independent completable futures 
        * thenCompose : completion stage , used to transform data from one form to another  , input is Function interface , depends on previous output 
    * Completable future has 3 options available for exception handling 
        * handle() - provides way to recover , gets executed even if no exception
        * exceptionally() - provides way to recover , gets executed only if an exception occurs in the pipeline
        * whenComplete  - no way to recover , gets executed for both success and failure path , exception is propagated to other when combine or is thrown back to the caller
    * Parallel streams and Completable future shares Common ForkJoin Pool , so if your code has parallel streams , you can have a different thread pool for completable future
    * Async overloaded methods : normal , one that runs in separated thread , one that takes a executor 
    * allOf is to be used when there are multiple services and we want response from all services
    * anyOf is to be used when there are multiple sources of same data and we want to get response from any of the service(faster one)
* ExecutorService  : contains threads available to run the tasks submitted
    * Fixed thread Pool : contains fixed no of threads as specified , backed by linked blocking queue where tasks can bestow submitted
    * Cached thread Pool : in case of all threads busy will create a new thread , if a thread is free for more than 60 sec it will kill that thread , backed by synchronous queue , where only one task can be submitted
    * Scheduled thread pool : If we want to run some task every x or y seconds . Backed by delay queue
    * Single threaded : single thread , blocking queue 
* Java Fibres(coroutines) : with fibres IO intensive or any task run by a thread can be unmounted and task status will be saved and thread can take another task and run . This is not finalised yet but this can help in many concurrent connections in java like reactive programming 
* Fairness : In reentrant lock while initialising when can set the fairness as true and it will pick up the task which was waiting in the wait queue. It will be slower but will guarantee fairness 
* ReadWriteLock : read lock can be acquired by many threads but write lock only by 1 thread. At  a time there will be either multiple reads or a single write.
* If a thread calls interrupt method on another thread then thread2 may choose to stop. Interrupt method to interrupt the thread , isInterrupted to check if thread was interrupted and interrupted to reset the interrupt flag
* Semaphore : If you want to have a limit on the number of threads which can access the code at a particular time , then make use of semaphores. Semaphore holds the number of permits as defined and would give the permits to the no of threads equal to the no of permits.
* Cyclic Barrier : a cyclic barrier waits for the no of threads to come to a certain point , when all the threads reaches a barrier then they are allowed to continue
* CountDownLatch : the code after latch.await will only be resumed once all the threads of the latch has called countdown on the latch
* Phaser : combination of cyclic barrier and countdown latch. Can be used as both cyclic barrier and countdown latch
* Striped locks : striped locks is a concept where you want to have a lock for a group of items

** ** 

## RxJava (for Reactive specification : https://github.com/ReactiveX/RxJava/wiki)
    * Reactive programming follows a push approach rather than a pull approach : We don’t need to retrieve data , observable takes care of that
    * Reactive approach is event driven 
    * Observable : source which emits data or items to the observers
    * Observer : which receives the event once it subscribes to the observable
    * Hot Vs cold observable : Cold observable emits all data for 1st observer and then for 2nd observer , Hot observable emits data simultaneously for all observers. Just and from iterable creates a cold observable
    * Defer Factory : Observables are created every time an observer subscribes
    * RxJava Operators allows you manipulate the data emitted by Observables
    * Schedulers : schedulers are used to create new thread in which each observer works on
    * observeOn : this method changes the thread of all operators further downstream
    * subscribeOn : This only influences the thread that is used when the Observable is subscribed to and it will stay on it downstream.


** ** 

## Functional Programming :

* Embraces creating immutable objects . More concise and readable code 
* Functions can be used as method and variables. Declarative style of programming 
* Imperative programming : How to do things ,  step by steps instructions , object mutability
* Declarative programming : What result you want (what things are ) , object immutability
* Lambda : function(method) without a name . Can be assigned to variable and passed as arguments as well. Not tied to any class. Mainly used to implement functional interfaces(SAM)
* In case of single argument () is not required and even return statement can be ignored
* Type inference : based on the functional interface arg , it is not necessary to specify the type of argument
* Consumer takes a input and returns void
* BiConsumer takes 2 inputs and returns void . Foreach takes a consumer and a biconsumer as well
* Predicate takes an input and return boolean. removeIf in collection takes a predicate . Filter also takes. Predicate 
* Method reference : shortcut for writing lambda expression , ClassName :: method name/ instance::method name 
* Constructor ref : ClassaMame::new
* Not allowed to use the same local var name as lambda parameter or inside lambda body
* Local variables cannot be rasssigned inside lambda , instance var can be reassigned
* Local var used can be final or effectively final 
* Optional : represent a non null value 



