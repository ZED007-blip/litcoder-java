package Module1.Lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contiguous_Array {

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //** Converting all 0 to -1 ->
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        int sum = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max, i - last);
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputArr = input.split(" ");
        int[] numbers = new int[inputArr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        System.out.println(findMaxLength(numbers));
    }
}
                                                                                                                            