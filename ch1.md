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

##### 1.1.5. Java needs to evolve
* 与传统面向对象相比，java 8的主要变化是，传统面向对象总是专注与修改已有对象的数据，而java 8则更像是函数式编程
* java8的风格是要做什么是主要内容，和怎么实现是分离的（TODO ?）
* java8增加的新特性有利于拓展Java解决问题的领域

#### 1.2. Functions in Java
* java语言中，对象是一等公民，Method和Class都是二等公民
* Method往往在定义Class的时候定义，但是定义出来的Class往往要实例化成对象，这导致Method定义的内容通过对象发挥作用
* java8在运行中直接使用Method，而不用过对象使用Method，让Method成为一等公民

##### 1.2.1. Methods and lambdas as first-class citizens
* java8中让方法像对象一样使用，是其他特性的基础
* 在过滤目录下隐藏文件的case中，java8之前，判断是否隐藏文件要传入FileFilter对象，会回调isHidden方法判断是否隐藏文件
* java8中，直接传入isHidden方法，而不用包装在FileFilter对象中
* 所以在java8中有了方法引用的概念，就是可以通过引用直接访问方法

##### 1.2.2. Passing code: an example
* 定义一个方法，直接传入方法

##### 1.2.3. From passing methods to lambdas
* 把lambda表达式当作参数传入，连方法定义都省掉了
* 只用到一次的逻辑就不用定义方法了，但是复杂逻辑不适合用lambda表达式

#### 1.3. Streams
* java8之前，处理集合要考虑怎么循环之类的控制语句
* java8 Stream中，不用再考虑如何控制（循环之类）
* 需要处理巨大数据集的场景，Stream能方便的并行利用计算机的多核

##### 1.3.1. Multithreading is difficult
* 编写正确的多线程代码比较困难
* Collection重点在于存储和访问数据，Stream重点在于处理数据（聚合、过滤），而且Stream提倡并行处理
* java8的并行处理基本没有成本，前提是个元素之间无关联的，不能有共享可变对象

#### 1.4. Default methods
* default方法主要是解决java8中在老接口中新增方法带来的问题
* 老接口新增方法，避免所有实现类都要实现对应新增方法

#### 1.5. Other good ideas from functional programming
* Optional<T>用来处理没有值的场景，避免用null造成空指针
* patter match （switch 语句中使用复杂对象？ TODO）