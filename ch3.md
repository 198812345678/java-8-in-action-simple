#### 3.1. Lambdas in a nutshell
* lambda表达式是匿名的
* lambda表达式与method类似，有参数、返回、异常，但不需要像method依赖于某一个class，因此被成为function
* lambda表达式可以像变量一样传递 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test
* body中如果要用{}，包在里面的要是完整的语句，表达式不能用{} @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test

#### 3.2. Where and how to use lambdas

##### 3.2.1. Functional interface
* 只有一个抽象方法的接口是Functional interface，如果有其他default method也不影响

##### 3.2.2. Function descriptor
* 能用functional interface实现类的地方就能用lambda表达式，要求签名与functional interface的那个抽象方法匹配 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.test1
* functional interface中的那个抽象方法叫做function descriptor
* function descriptor应该不是一种语法，他只是描述那个抽象方法的一种方式，就像方法签名
* lambda不仅可以用在参数，也可以用在返回值 @see com.will.simple.java.eight.in.action.ch3.LambdaTest.buildFounctionalInterface
* @FunctionalInterface注解在functional interface上, 如果不是functional interface会报错 @see com.will.simple.java.eight.in.action.NotFounctionalInterface