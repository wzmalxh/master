package javatest.lambda;

import com.sun.javafx.geom.transform.Identity;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int numSqrtSum = numbers.stream().reduce(0, (ele, n) -> ele + n * n);

        System.out.println(numSqrtSum);

        int numSqrtSumParallel = numbers.parallelStream().reduce(0, (ele, n) -> ele + n * n, Integer::sum);

        System.out.println("Parallel is: "+ numSqrtSumParallel);
        // 使用reduce方法计算所有数字的平方和
        // identity: 初始值0
        // accumulator: 累加器，计算当前元素平方后与累加值的和
        // combiner: 组合器，用于并行流中合并不同线程的结果
        int sumOfSquares = numbers.parallelStream()
                .reduce(0, // identity
                        (sum, n) -> sum + n * n, // accumulator
                        Integer::sum); // combiner，这里直接使用Integer的sum方法作为组合器

        System.out.println("Sum of squares: " + sumOfSquares);

        // 注意：对于简单的累加操作，如上面的平方和计算，
        // 通常不需要显式提供combiner，因为Stream API可以自动推断出合适的combiner。
        // 下面的代码与上面的效果相同，但更简洁：
        int sumOfSquaresSimplified = numbers.parallelStream()
                .map(n -> n * n) // 先将每个元素映射为其平方
                .reduce(0, Integer::sum); // 然后累加这些平方值

        System.out.println("Sum of squares (simplified): " + sumOfSquaresSimplified);
    }
}
