#### 2.1. Coping with changing requirements
* 挑选绿苹果的需求变成挑选红苹果，方法一是重新实现一个方法，方法二是把要挑选的颜色作为参数
* 如果增加了按重量挑选的条件，一种糟糕的方式是再方法中把所有条件的逻辑都实现，通过参数控制判断哪个条件

#### 2.2. Behavior parameterization
* 另一种方式是，挑选逻辑接收一个实现判断功能的接口，不同的挑选条件做不同的实现，但这每种条件的组合都要实现该接口，我们真正的需求就是要传入判断的表达式

#### 2.3. Tackling verbosity
* 2.2的方式扩展的话需要很多的不同的接口实现，匿名内部类在定义局部变量时会与上下文相互影响 @see com.will.simple.java.eight.in.action.ch2.IdefTest.test
