package Module2.Lab1;

import java.util.Scanner;
import java.util.Stack;

public class Simple_Text_Editor {
    private static StringBuilder text;
    private static Stack<String> operations;

    public Simple_Text_Editor() {
        text = new StringBuilder();
        operations = new Stack<>();
    }

    public static void insert(String value) {
        text.insert(operations.size(), value);
        operations.push("1 " + value);
    }

    public static void delete(int value) {
        int start = Math.max(0, text.length() - value);
        int end = text.length();
        operations.push("2 " + text.substring(start, end));
        text.delete(start, end);
    }

    public static char get(int value) {
        char result = text.charAt(value - 1);
        operations.push("3 " + result);
        return result;
    }

    public static void undo() {
        if (!operations.isEmpty()) {
            String lastOperation = operations.pop();
            String[] parts = lastOperation.split(" ");
            int command = Integer.parseInt(parts[0]);

            switch (command) {
                case 1:
                    int length = parts[1].length();
                    text.delete(text.length() - length, text.length());
                    break;
                case 2:
                    text.append(parts[1]);
                    break;
                case 3:
                
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Simple_Text_Editor(); 
        String input = scanner.nextLine();
        String[] commands = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    insert(parts[1]);
                    break;
                case 2:
                    delete(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    System.out.println(get(Integer.parseInt(parts[1])));
                    break;
                case 4:
                    undo();
                    break;
            }
        }
        scanner.close();
    }
}
                                                                                                                            