package Module4.Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Query_Kth_Smallest_Trimmed_Number {

    public static List<Integer> kthSmallestTrimmedNumber(List<String> nums, List<int[]> queries) {
        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {
            int position = query[0];
            int trimLength = query[1];
            List<Integer> trimmedNums = new ArrayList<>();

            for (String num : nums) {
                int trimmed = Integer.parseInt(num.substring(num.length() - Math.min(num.length(), trimLength)));
                trimmedNums.add(trimmed);
            }

            List<Integer> sortedNums = new ArrayList<>(trimmedNums);
            Collections.sort(sortedNums);

            int kthSmallest = (position <= sortedNums.size()) ? sortedNums.get(position - 1) : -1;
            int kthSmallestIndex = (kthSmallest != -1) ? trimmedNums.indexOf(kthSmallest) : -1;
            answer.add(kthSmallestIndex);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numsArray = scanner.nextLine().trim().split(" ");
        List<String> nums = new ArrayList<>();
        Collections.addAll(nums, numsArray);

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < queriesCount; i++) {
            int[] query = new int[2];
            String[] queryArray = scanner.nextLine().trim().split(" ");
            for (int j = 0; j < 2; j++) {
                query[j] = Integer.parseInt(queryArray[j]);
            }
            queries.add(query);
        }

        List<Integer> result = kthSmallestTrimmedNumber(nums, queries);
        System.out.println(String.join(" ", result.stream().map(Object::toString).toArray(String[]::new)));
    }
}