import java.util.Arrays;
import java.util.List;

public class OptionalEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Navin", "Lakshmi", "John", "Kishor");

        String name = names.stream()
                .filter(str -> str.contains("x"))
                .findFirst()
                .orElse("Not found");

        System.out.println(name);
    }

}
