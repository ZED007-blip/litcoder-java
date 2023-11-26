package Module1.Lab2;

import java.util.Scanner;
import java.util.Stack;

public class Queue_using_Two_Stacks {

    static void processQueries(String input) {
        String[] queries = input.split(",");
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    int element = Integer.parseInt(parts[1]);
                    enqueue(stack1, element);
                    break;
                case 2:
                    dequeue(stack1, stack2);
                    break;
                case 3:
                    printFront(stack1, stack2);
                    break;
            }
        }
    }

    static void enqueue(Stack<Integer> stack1, int element) {
        stack1.push(element);
    }

    static void dequeue(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    static void printFront(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        processQueries(input);
    }
}
                                                                                                                            