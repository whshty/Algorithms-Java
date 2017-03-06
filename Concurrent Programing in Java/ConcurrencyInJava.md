# Concurrent Programming in Java
## 1.Thread(线程) & Process(进程)
### 1.1 Process* Process has a self-contained execution environment. Each process has its own memory space (not share with other processes)* Processes are often as synchronized with program and application* For example, the Java virtual machine run as a single process### 1.2 Thread* Threads are sometimes called lightweight processes. Both processes and threads provides an execution environment, but create creating a new thread requires fewer recourses then creating a new process* **Threads exist within a process** - Every process has at least one. Threads share process's resources, including memory and open files### 1.3 Thread vs Process
* Process contains threads. Thread is lightweight
* Processes are independent of each other. Threads share common resources
* JVM stack are sharing coomon heap and method area
* For example, JVM is a process and main method is a thread

## 2. Concurrency(并发) & Parallelism(并行)
### 2.1 Concurrency & Parallelism
* Concurrency: A condition that exists when at least two threads are marking progress(doesn't necessarily mean they'will ever both be running at the same time instance). A more generalized form of parallelism that can include time-slicing as a form fo virtual parallelism
* Parallelism: A conditon that arises when at least two threads are executing simultaneously

## 3. How to Create a thread in Java 
* Instantiate a subclass wich extends the Thread class
* new the Thread constructor using subclass which implements the runnable interface

## 3.1 Create thread in two ways
### 3.1.1 run() vs start()Always override run() and call start()* public void run(): no new thread will be created* public void start(): a new thread will be created### 3.1.2 Runnable vs Thread#### 3.1.2.1 Runnable - more flexible* java.lang.Runnable - interface* run()* The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. The class must (override) define a method of no arguments called run.#### 3.1.2.2 Thread - class* Methods: run(), start(), sleep()......#### 3.1.2.3 Similarities* The subclass should override the run() method* The functionality that expected be executed concurrently should be implemented in the run() method#### 3.1.2.4 Difference* Extend the Thread class will make your class unable to extend other classes* Implemented the Runnable interface provides better object-oriented design and consistency and also avoid the single inheritance problems* In most cases, the Runnable interface should be used if you are only planning to override the run() method and no other Thread methods

#### 3.1.2.5 Code Example
```
class Solution {
    public static void main (String[] args) {
        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){

    }
}

class MyRunnable implements Runnable{
    @Override
    public void run(){

    }
}
```
### 3.1.3 Thread priority* Thread priorities are the integer which decide how one thread should be treated with respect to other threads
* Thread priority decides when to switch from one running thread to anothe, this process is call context switching
* When a thread is created, it inherits its priority from the thread that created it 
* yield() : used to give other threads, which has the same priority as the invoked thread, a chanece to execute, and the current running thread changes to runnable state

### 3.1.4 Thread Life Cycle
```
  Newborn
   |
   | start()
   |         yield()           stop()
  Runnable --------- Running  ------- Dead
   |                    |
   | notify()           |
   | notifyAll()        |
   ----------------------
      Blocked          
```



### 3.1.5 join() & sleep()
* The join() method is used when we want the parent thread waiting until the children threads which invoke join() end 
* The sleep() method causes the currently executing thread to sleep

### 3.1.5.1 Code example 
```
class Solution {
    public static void main (String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        
        try {
            thread1.join();
        } catch ( InterruptedException e){
            // TODO
            e.printStackTrace();
        }
        
        thread2.start();

    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for( int i = 0 ; i < 10 ; i++ ){
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch ( InterruptedException e ){
                // TODO
                e.printStackTrace();
            }
        }

    }
}

```

### 3.1.5.1 Code result
* join() : 0 1 2 3 4 5 6 7 8 9  0 1 2 3 4 5 6 7 8 9 
* no join method : 00 11 22 33 44 55 66 77 88 99 


### 3.1.5 wait(), notify() and notifyAll()
Normally need a gobal boolean flag to avoid pre-notify

* public final void notify() wakes up the first thread that invokes wait() on the same object and changes the thread to the ready state
* public final voide notifyAll() wakes up all the threads. The higher priority thread will run first
* public final void wait() cause the current thread to wait until another thread invokdes the notify() method or the notifyAll() method for this object.

## 4.Synchronization(同步)
### 4.1 Introduction
* When two or more threads need access to the same resource at same time, there should be some way that the resource is ony avaible for one thread at one time. Synchronization helps to achieve this goal
* Used for method and block 
* 每个类的实例都有自己对象的锁， 当一个线程访问实例对象中的synchronized 同步代码块或者同步方法时，该线程便获取了该实例对象级别的锁。其他线程这时如果要访问synchronized同步代码块或者同步方法，便需要阻塞等待，知道前面线程从同步代码块或者方法中退出，释放了该对象级别的锁
* 锁提供了两种主要特性: 互斥(mutual exclusion)／原子性（atomic）和可见性（visibility）
* 互斥即一次只允许一个线程持有某个特定的锁，一次只有一个线程能够使用该共享数据。可见性确保释放锁之前对共享数据做出的的更改对于随后获得该锁的另一线程时可见的
* volatile修饰variable。数据址保存在main memory中，只保证可见性（visibility),不保证原子性。是轻量级的Synchronization。

#### 4.1.1 Code example 
* static synchronized method(类锁)
* synchronized method(对象锁)
* 只能有一个thread拥有setNewValue()和getNewValue()对应的object lock
* 锁可重入: setNewValue() 和 getNewValue()可以互相调用

```
class demo {
    public static synchronized void getClassValue(){
        // Class locked
    }
    public  synchronized void setNewValue(){
        // Object lock
    }
    public synchronized void getNewValue(){
        // Object lock
    }
    public void getNormalValue(){
        // No-lock
    }
}

```

### 4.2 Deadlock 
* Whenever there are multithreads content for exclusive access to multiple locks, there is a possibility of deadlock.
* A set of threads is said to be deadlocked when EACH thread is waiting for an action that can ONLY performed by other threads
* It describes a situation where two or more threads are blocked forever, and waiting for each other.
* Deadlock occurs when multiple threads need the same locks but obtain them in different order.

### 4.2.1 How to avoid deadlock
* Keep synchronized blocks short. As short as possible while still protecting the integrity of shared data operations.
* Don’t invoke methods of other objects while holding a lock.(no nested lock)

### 4.2.2 Code example
Result : no output, because of deadlock

```
package Deadlock;

public class demo {
    static Object Lock1 = new Object();
    static Object Lock2 = new Object();

    public static void main(String[] args) {
        TreadDemo1 T1 = new TreadDemo1();
        TreadDemo2 T2 = new TreadDemo2();
        T1.start();
        T2.start();
    }

    static class TreadDemo1 extends Thread {
        public void  run(){
            // A synchronized block
            synchronized (Lock1) {
                try {
                    TreadDemo1.sleep(1);
                } catch ( InterruptedException e ){

                }
                synchronized (Lock2){}
            }
        }
    }

    static class TreadDemo2 extends Thread {
        public void  run(){
            synchronized ( Lock2 ){
                try {
                    Thread.sleep(1);
                } catch ( InterruptedException e ){

                }
                synchronized ( Lock1 ){

                }
            }
        }
    }
}

```

## 4.Producer and consumer
1:26








