#### 3.1. Lambdas in a nutshell
* lambda表达式是匿名的
* lambda表达式与method类似，有参数、返回、异常，但不需要像method依赖于某一个class，因此被成为function
* lambda表达式可以像变量一样传递 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test
* body中如果要用{}，包在里面的要是完整的语句，表达式不能用{} @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test
* body中要么是完整的一块方法块{xxx;xxx;}, 要么只是return后面的内容（不带return）

#### 3.2. Where and how to use lambdas

##### 3.2.1. Functional interface
* 只有一个抽象方法的接口是Functional interface，如果有其他default method也不影响

##### 3.2.2. Function descriptor
* 能用functional interface实现类的地方就能用lambda表达式，要求签名与functional interface的那个抽象方法匹配 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test1
* functional interface中的那个抽象方法的描述叫做function descriptor(方法签名)
* function descriptor应该不是一种语法，他只是描述那个抽象方法的一种方式，就是那个抽象方法签名, 入参类型...-> 返回类型，包括异常声明
* lambda不仅可以用在参数，也可以用在返回值 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.buildFounctionalInterface
* @FunctionalInterface注解在functional interface上, 如果不是functional interface会报错 @see com.will.simple.java.eight.in.action.NotFounctionalInterface

#### 3.3. Putting lambdas into practice: the execute around pattern
* execute around pattern：有准备工作，有收尾工作，中间做不同的逻辑。比如打开一个资源，读取或者update资源的内容，然后close资源。
* 在execute around pattern使用lambda的步骤是：@see com.will.simple.java.eight.in.action.ch3.LambdaTest.test2
* * 将三部分解耦
* * 定义FunctionalInterface
* * FunctionalInterface作为入参实现方法
* * 使用的时候以lambda形式传入参

#### 3.4. Using functional interfaces
* java.util.function.Predicate 判断一个对象是否符合某一条件时使用
* java.util.function.Consumer 要对某个对象本身做某些操作，没有返回值时使用
* java.util.function.Function 把某个对象转化成另一个对象时使用
* 这些基本也是在execute around pattern中使用 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test3

#### 3.5. Type checking, type inference, and restrictions
##### 3.5.1. Type checking
* lambda表达式的类型是根据上下文推断出来的
* target type：在此处实际需要的类型
* lambda表达式当作方法入参时的类型检查过程：
* * 根据被调用方法的入参找到target type
* * 是否是functional interface，并找到那个抽象方法
* * 检查lambda表达式（的签名）和抽象方法的签名是否匹配，包括异常

##### 3.5.2. Same lambda, different functional interfaces
* 因为泛型和void，所以同一个lambda表达式可以和多个functional interfaced 的function descriptor匹配，也就可以用在多个场景

##### 3.5.3. Type inference
* 因为有target type，编译器知道什么类型是正确的，所以lambda表达式的入参类型可以忽略（要和target type匹配）@see com.will.simple.java.eight.in.action.ch3.LambdaTest.test4
* 并不是所有场景都合适使用这个机制

##### 3.5.4. Using local variables
* capturing lambdas: 使用lambda表达式定义参数之外的变量
* lambda表达式如果要使用表达式外的局部变量，这个局部变量必须是final或者只赋值一次，实例变量和static变量则没有这个限制, 匿名内部类也有这个限制
@see com.will.simple.java.eight.in.action.ch3.LambdaTest.test5
@see com.will.simple.java.eight.in.action.ch3.LambdaTest.test6
* 这个限制的原因是，局部变量属于线程，在线程的栈中，lambda和匿名内部类有机会将变量带到另一个线程，如果通过lambda表达式或者匿名内部类在其他线程中使用了这个局部变量，其实是使用的一个拷贝，
当拥有这个变量的线程将这个变量销毁后，拷贝依然存在，这使得对这个变量的修改是无意义的


#### 3.6 方法引用
##### 3.6.1 管中窥豹 
* 如果一个lambda表达式的body只是调用某个类的一个方法，这时可以使用方法引用
* 静态方法的方法引用：body中调用的方法是某个类的静态方法 
* lambda参数实例的方法引用：body中调用的方法是某个参数的方法，并且其他参数是这个方法的入参(就是说lambda的所有入参都要在方法引用中用到？) @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test11
* 外部对象的方法引用：body中调用的方法是表达式外部对象的某个方法，并且表达式的入参是这个方法的入参
* @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test11

##### 3.6.2 构造函数引用 
* 当一个lambda表达式的body只是要new一个对象的时候，就可以使用构造函数引用 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test13

#### 3.8 复合Lambda表达式的有用方法 
* 复合就是叠加行为，因为函数式接口可以有默认方法，所以可以有多种行为可以叠加
* 比较器复合：实现多维度比较
* 谓词复合：组合与或非操作，运算优先级从左到右，不同于||、&&等操作符
* 函数复合：类似数学里的f(g(x)) g(f(x))
* @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test14