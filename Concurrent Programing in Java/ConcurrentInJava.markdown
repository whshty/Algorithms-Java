# 1.Thread(线程) & Process(进程)
## 1.1 Process* Process has a self-contained execution environment. Each process has its own memory space (not share with other processes)* Processes are often as synchronized with program and application* For example, the Java virtual machine run as a single process## 1.2 Thread* Threads are sometimes called lightweight processes. Both processes and threads provides an execution environment, but create creating a new thread requires fewer recourses then creating a new process* **Threads exist within a process** - Every process has at least one. Threads share process's resources, including memory and open files## 1.3 Thread vs Process
* Process contains threads. Thread is lightweight
* Processes are independent of each other. Threads share common resources
* JVM stack are sharing coomon heap and method area
* For example, JVM is a process and main method is a thread

# 2. Concurrency(并发) & Parallelism(并行)
## 2.1 Concurrency & Parallelism
* Concurrency: A condition that exists when at least two threads are marking progress(doesn't necessarily mean they'will ever both be running at the same time instance). A more generalized form of parallelism that can include time-slicing as a form fo virtual parallelism
* Parallelism: A conditon that arises when at least two threads are executing simultaneously




