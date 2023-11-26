package Module2.Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Lego_Blocks {


    private static final int MOD = 1000000007;
    private static final int MAX_SIZE = 1000 + 1;
    private static final int UNKNOWN = -1;

    static int[][] allSolutions = new int[MAX_SIZE][MAX_SIZE];
    static int[][] solidSolutions = new int[MAX_SIZE][MAX_SIZE];

    static {
        for (int i = 1; i < MAX_SIZE; i++) {
            Arrays.fill(allSolutions[i], UNKNOWN);
            Arrays.fill(solidSolutions[i], UNKNOWN);
        }
    }

    static int getAllSolutions(final int height, final int width) {
        if (allSolutions[height][width] != UNKNOWN) {
            return allSolutions[height][width];
        }

        long count;
        if (width == 1) {
            count = 1;
        } else if (height == 1) {
            if (width <= 4) {
                count = 2L * getAllSolutions(1, width - 1);
            } else { // width > 4
                count = 0;
                for (int i = 1; i <= 4; i++) {
                    count += getAllSolutions(1, width - i);
                    count %= MOD;
                }
            }
        } else { // width > 1 && height > 1
            int oneRowSolutions = getAllSolutions(1, width);

            count = 1;
            for (int h = 0; h < height; h++) {
                count *= oneRowSolutions;
                count %= MOD;
            }
        }

        allSolutions[height][width] = (int) count;
        return allSolutions[height][width];
    }

    static int getSolidSolutions(final int height, final int width) {
        if (solidSolutions[height][width] != UNKNOWN) {
            return solidSolutions[height][width];
        }

        long count;
        if (width == 1) {
            count = 1;
        } else {
            count = getAllSolutions(height, width);
            for (int i = 1; i < width; i++) {
                long a = getAllSolutions(height, i);
                long b = getSolidSolutions(height, width - i);
                count -= (a * b) % MOD;
                if (count < 0) {
                    count += MOD;
                }
            }
        }
        solidSolutions[height][width] = (int) count;
        return solidSolutions[height][width];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int height = scanner.nextInt();
        final int width = scanner.nextInt();

        System.out.println(getSolidSolutions(height, width));
    }
}
                                                                                                                            