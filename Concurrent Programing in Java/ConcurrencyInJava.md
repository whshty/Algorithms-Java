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
* Whhen a thread is created, it inherits its priority from the thread that created it 
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








