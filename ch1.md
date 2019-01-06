#### 1.1. Why is Java still changing?
##### 1.1.1. Java’s place in the programming language ecosystem
* 在面临大数据问题时，java的并发处理并不友好，为了适应新问题，Java有必要改进

##### 1.1.2. Stream processing
* Java 8 里的stream好像Linux系统的命令，可以通过管道把操作串联起来，并且并行的执行
* 也像数据库查询的子查询
* 与多线程相比，代价小得多

##### 1.1.3. Passing code to methods with behavior parameterization
* TODO 没搞明白和传入一个匿名内部类有啥区别

##### 1.1.4. Parallelism and shared mutable data
* stream的并行处理不是并发安全的，所以传入stream的逻辑不能共享可变数据，不能使用同步机制控制并发