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
Based on my current understanding, memory consistency errors are similar to
thread interference. The difference is that, instead of thread A and thread B
executed at the same time, one, let's say A, executed first, updated the memory.
But B didn't read the latest value. Instead, it keeps an old value.

## Synchronized Methods

## Intrinsic Locks and Synchronization
Every **Object** has a lock within it. The mechanism of lock system is that,
the lock is unique, so that only one thread can acquire it at one time. It's
like a key to a door, and only one person can hold it.

In addition to declare synchronized methods, we can also declare synchronized
code blocks. The code block is like a method without declaration line. When we
invoke an object's method, it's clearly we are asking the thread to take the
object's intrinsic lock. With the synchronized code block, it's similar that we
should give the block a lock. Usually, we can use `this` pointer to assign the
current object's lock.
```
synchronized(this) {
        // blahblah
    }
```
However, in addition, sometimes we want to execute two blocks which are
independent from each other. In that case, even the execution steps interleave,
the blocks won't mess up each other. Using the current object's lock can only
enable one block to execute since only one thread can hold the lock, but we are
trying to make two blocks execute in concurrency. To solve this, we can give
other object's lock to the code block. The other objects act as a flag variable.
```
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            // operations 
        }
    }

    public void inc2() {
        synchronized(lock2) {
            // operations 
        }
    }
```

Another point is about _Reentrant Synchronization_. This basically means one
thread can hold the object's lock for multiple times. It's like a person take
the key for multiple times during his usage. This happens when a synchronized 
method invokes another synchronized method. This makes sense since it's the same
thread holding the same lock.

## Atomic Access

# Liveness
A concurrent application's ability to execute in a timely manner is known as its
liveness.
## Deadlock
Deadlock happens when two threads each hold the lock of one object. While the
two threads are executing on a _synchronized_ methods, both of them want to call
a _synchronized_ method in the other object. Rember that, when thread invokes a
synchronized method, it has to acquire the object's lock. So, in this situation,
thread A holds lock A, thread B holds lock B. Now, tA is waiting tB to release
lock B, while possessing lock A. tB is waiting tA to release lock A while
holding lock B. A deadlock happens.

## Startvation and Livelock
Starvation happens when one thread takes too much resource for a long period so
that other threads don't have enough access to that resource.

Livelock happens when two threads respond to each other heavily so that the
system is busy switching between these two threads.

# Guarded Block


# Summary from exercise
What will happen depends on happens-before relationship. It the relationship is
not built, then the result is not guaranteed. The essence of happens-before
relationship is about visibility, instead of sequence.
