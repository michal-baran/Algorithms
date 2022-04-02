import java.util.Arrays;

public class Util {
    public static void printArray(int[] array) {
        System.out.print("[");
        Arrays.stream(array).forEach((number) -> System.out.print(number + " "));
        System.out.println("]");
    }

}
