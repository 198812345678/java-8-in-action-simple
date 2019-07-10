### 7.1 并行流
* 类似mapreduce，先划分再聚合，划分后由多个线程处理子任务 @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_1
* 因为最后一个终端操作才回触发对数据的处理，而是否并行是由内部一个boolean标识控制的，所以最后一次parallel或sequential操作决定了是否并行 @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_2

#### 7.1.2 测试流性能
* @see com.will.simple.java.eight.in.action.ch7.ParallelSumTest#test_3


