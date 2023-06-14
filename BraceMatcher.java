import java.util.Scanner;

public class BraceMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (!isValidInput(input)) {
            System.out.println("INVALID INPUTS");
            return;
        }

        int openingParentheses = 0;
        int closingParentheses = 0;
        int openingSquareBrackets = 0;
        int closingSquareBrackets = 0;
        int openingCurlyBraces = 0;
        int closingCurlyBraces = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                openingParentheses++;
            } else if (ch == ')') {
                closingParentheses++;
            } else if (ch == '[') {
                openingSquareBrackets++;
            } else if (ch == ']') {
                closingSquareBrackets++;
            } else if (ch == '{') {
                openingCurlyBraces++;
            } else if (ch == '}') {
                closingCurlyBraces++;
            }
        }

        int parenthesesDiff = Math.abs(openingParentheses - closingParentheses);
        int squareBracketsDiff = Math.abs(openingSquareBrackets - closingSquareBrackets);
        int curlyBracesDiff = Math.abs(openingCurlyBraces - closingCurlyBraces);

        StringBuilder result = new StringBuilder(input);

        for (int i = 0; i < parenthesesDiff; i++) {
            result.append(')');
        }

        for (int i = 0; i < squareBracketsDiff; i++) {
            result.append(']');
        }

        for (int i = 0; i < curlyBracesDiff; i++) {
            result.append('}');
        }

        System.out.println("Output: " + result);
    }

    private static boolean isValidInput(String input) {
        for (char ch : input.toCharArray()) {
            if (ch != '(' && ch != ')' && ch != '[' && ch != ']' && ch != '{' && ch != '}') {
                return false;
            }
        }
        return true;
    }
}
