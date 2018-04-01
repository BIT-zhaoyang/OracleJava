First, remember, concurrency is not parallelism. Concurrency means processes are
executed alternatively through an OS feature called time slicing.

# Thread Objects
In Java, each thread is associated with an instance of the class `Thread`. So,
to create concurrent program, we actually has to manage `Thread` instances. Two
strategies are available:

* Directly control threads, namely instantiate `Thread` objects manually
* Delegate the management to `executor`

## Defining and Starting a Thread
To create a `Thread` instance, we have to specify what code will run in that
thread. The `Thread` class has a `run()` method, we fill the code in that
method. Two ways are provided to achieve that goal,

* Implement a Runnable object. The Runnable interface contains one single method
  `run()`. We implement the interface, implement that method and then pass the
  Runnable object to Thread to create a Thread instance.
* Subclass Thread. In fact, Thread itself implements Runnable.

The first approach is considered to be better practice. We should always prefer
polymorphism than inheritance. Also, the first approach fits usage of `executor`.

# Synchronization
Threads communicate by sharing access to fields. This leads to two kinds of
errors: _thread interference_ and _memory consistency errors_. To prevent these
errors, a tool called _synchronization_ becomes available. 

However, _synchronization_ brings _thread contention_, which means two or more
threads are trying to get the same resource simultaneously. Two forms of thread
contention are _starvation_ and _livelock_.

## Thread Interference
Interference happens when two operations work on the same data and their steps
interleave. Even there is a single statement in an operation, the statement may
generate several steps in JVM, which can cause thread interference.

## Memory Consistency Errors

## Synchronized Methods

## Implicit Locks and Synchronization

## Atomic Access

