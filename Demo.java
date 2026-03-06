import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        Stream<Integer> sortedValues = nums.parallelStream()
                .filter(n -> n % 2 == 0)
                .sorted();

        sortedValues.forEach(n -> System.out.println(n));

    };
};