package Module3.Lab1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Cookies {

    public static int cookies(int[] candies, int targetSweetness) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int candy : candies) {
            minHeap.offer(candy);
        }

        int steps = 0;

        while (!minHeap.isEmpty() && minHeap.peek() < targetSweetness) {

            int leastSweet = minHeap.poll();

            if (!minHeap.isEmpty()) {
                int secondLeastSweet = minHeap.poll();
                int combinedSweetness = leastSweet + 2 * secondLeastSweet;
                minHeap.offer(combinedSweetness);
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetSweetness = scanner.nextInt();
        scanner.nextLine();

        String[] inputLine = scanner.nextLine().split(" ");
        int n = inputLine.length;
        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = Integer.parseInt(inputLine[i]);
        }

        int result = cookies(candies, targetSweetness);
        System.out.println(result);
    }
}