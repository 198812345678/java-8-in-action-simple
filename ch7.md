### 7.1 并行流
* 类似mapreduce，先划分再聚合，划分后由多个线程处理子任务 @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_1
* 因为最后一个终端操作才回触发对数据的处理，而是否并行是由内部一个boolean标识控制的，所以最后一次parallel或sequential操作决定了是否并行 @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_2

#### 7.1.2 测试流性能
* @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_3

#### 7.1.3 正确使用并行流
*  如果不同的分片会修改共享变量，就会有并发问题

#### 7.1.4 高效使用并行流
* 避免装箱、拆箱，使用原始类型流
* limit和findFirst等依赖元素顺序的操作，在并行流上执行的代价非常大
* 如果处理单个元素的成本对总的处理成本影响比较大，那并行是效果比较好的
* 小数据量不适合
* 有的数据结构适合分解，有的不适合，ArrayList比LinkedList适合分解，因为LinkedList必须遍历所有元素才能决定每个元素所在的分片
* 考虑合并代价，什么时候合并代价比较大？

### 7.2 分支／合并框架

#### 7.2.1 使用RecursiveTask
* 使用多个ForkJoinPool是没有意义的，为什么？

