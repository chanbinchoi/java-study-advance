import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SteamEx {
    public static void main(String[] args) {

        int size = 10_000;
        List<Integer> nums = new ArrayList<>(size);

        Random ran = new Random();

        for (int i = 1; i <= size; i++) {
            nums.add(ran.nextInt(100)); // 0~99 리스트 추가
        }

        long startSeg = System.currentTimeMillis();
        int sum2 = nums.stream()
                .map(i -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    return i * 2;
                })
                .mapToInt(i -> i) // IntStream으로 변환
                .sum(); // 합계 (IntStream에서 사용 가능)
        long endSeg = System.currentTimeMillis();

        long startPara = System.currentTimeMillis();
        int sum3 = nums.parallelStream()
                .map(i -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    return i * 2;
                })
                .mapToInt(i -> i)
                .sum();
        long endPara = System.currentTimeMillis();

        System.out.println(sum2 + " " + sum3);
        System.out.println("Seq : " + (endSeg - startSeg));
        System.out.println("Para : " + (endPara - startPara));
    }

}
