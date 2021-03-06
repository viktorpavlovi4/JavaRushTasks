package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6

        String s;
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);
        s = "(-2)^(-2)";
        System.out.print(s + " expected output 0.25 3 actually ");
        solution.recursion(s, 0);
        s = "-2^(-2)";
        System.out.print(s + " expected output -0.25 3 actually ");
        solution.recursion(s, 0);
        s = "89-cos(180)^2";
        System.out.print(s + " expected output 88 3 actually ");
        solution.recursion(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recursion(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);
        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);
        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);
        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);
        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
        s = "-(-22+22*2)";
        System.out.print(s + " expected output -22 4 actually ");
        solution.recursion(s, 0);
        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recursion(s, 0);
        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recursion(s, 0);
        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);
        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recursion(s, 0);
    }

    public void recursion(final String expression, int countOperation) {
        Locale.setDefault(Locale.ENGLISH);
        final DecimalFormat fourDigitFormat = new DecimalFormat("#.####");
        final DecimalFormat twoDigitFormat = new DecimalFormat("#.##");
        fourDigitFormat.setRoundingMode(RoundingMode.HALF_UP);
        twoDigitFormat.setRoundingMode(RoundingMode.HALF_UP);
        final String cleanExpression = expression
                .replace(" ", "")
                .replace("+-", "-")
                .replace("--", "+");
        if (countOperation == 0) {
            countOperation = countNegativeNumbers(cleanExpression);
        }
        final Stack<Integer> brackets = new Stack<>();

        if (cleanExpression.contains("(")) {
            for (int i = 0; i < cleanExpression.length(); i++) {
                if (cleanExpression.charAt(i) == '(') brackets.push(i);
                if (cleanExpression.charAt(i) == ')') {
                    final int indOpenBracket = brackets.pop();
                    String newExpression = cleanExpression.substring(indOpenBracket + 1, i);
                    if (newExpression.matches(".*[+^/*].*") || (newExpression.contains("-") && newExpression.lastIndexOf('-') != 0)) {
                        final String res = calculateSimpleMathOperation(newExpression);
                        newExpression = cleanExpression.substring(0, indOpenBracket + 1) + res + cleanExpression.substring(i);
                        recursion(newExpression, countOperation + 1);
                        return;
                    }
                    final double numberInBrackets = Double.parseDouble(newExpression);
                    if (indOpenBracket > 2) {
                        if (cleanExpression.contains("sin") && cleanExpression.indexOf("sin") == indOpenBracket - 3) {
                            final String sin = fourDigitFormat.format(StrictMath.sin(Math.toRadians(numberInBrackets)));
                            newExpression = cleanExpression.substring(0, indOpenBracket - 3) + sin + cleanExpression.substring(i + 1);
                            recursion(newExpression, countOperation + 1);
                            return;
                        }
                        if (cleanExpression.contains("cos") && cleanExpression.indexOf("cos") == indOpenBracket - 3) {
                            final String cos = fourDigitFormat.format(StrictMath.cos(Math.toRadians(numberInBrackets)));
                            newExpression = cleanExpression.substring(0, indOpenBracket - 3) + cos + cleanExpression.substring(i + 1);
                            recursion(newExpression, countOperation + 1);
                            return;
                        }
                        if (cleanExpression.contains("tan") && cleanExpression.indexOf("tan") == indOpenBracket - 3) {
                            final String tan = fourDigitFormat.format(StrictMath.tan(Math.toRadians(numberInBrackets)));
                            newExpression = cleanExpression.substring(0, indOpenBracket - 3) + tan + cleanExpression.substring(i + 1);
                            recursion(newExpression, countOperation + 1);
                            return;
                        }
                    }
                    newExpression = cleanExpression.substring(0, indOpenBracket) + newExpression + cleanExpression.substring(i + 1);
                    recursion(newExpression, countOperation);
                    return;
                }
            }
        }

        if (cleanExpression.matches(".*[+^/*].*") || (cleanExpression.contains("-") && cleanExpression.lastIndexOf('-') != 0)) {
            final String newExpression = calculateSimpleMathOperation(cleanExpression);
            recursion(newExpression, countOperation + 1);
            return;
        }

        final double result = Double.parseDouble(cleanExpression);
        System.out.println(twoDigitFormat.format(result) + ' ' + countOperation);
    }

    String calculateSimpleMathOperation(final String expression) {
        final Pattern COMPILE = Pattern.compile("[-+^/*]");
        final DecimalFormat fourDigitFormat = new DecimalFormat("#.####");
        fourDigitFormat.setRoundingMode(RoundingMode.HALF_UP);

        final String operation;
        final int operationPos;
        if (expression.contains("^")) {
            operation = "^";
            operationPos = expression.lastIndexOf(operation);
        } else if (expression.matches(".*[*/].*")) {
            final int indMultiplication = expression.indexOf('*');
            final int indDivision = expression.indexOf('/');

            if (indDivision > 0 && indMultiplication > 0) operation = indDivision < indMultiplication ? "/" : "*";
            else if (indDivision > 0) operation = "/";
            else operation = "*";

            operationPos = expression.indexOf(operation);
        } else {
            final int indAddition = expression.indexOf('+');
            final int indSubtraction = expression.indexOf('-', 1);

            if (indAddition > 0 && indSubtraction > 0) operation = indAddition < indSubtraction ? "+" : "-";
            else if (indAddition > 0) operation = "+";
            else operation = "-";

            operationPos = expression.indexOf(operation, 1);
        }

        final String leftSide = expression.substring(0, operationPos);
        final String[] leftSideNumbers = COMPILE.split(leftSide);
        String sLeftNumber = leftSideNumbers[leftSideNumbers.length - 1];
        final int indOfLeftNumber = expression.indexOf(sLeftNumber);
        if (indOfLeftNumber > 0 && expression.charAt(indOfLeftNumber - 1) == '-') {
            sLeftNumber = '-' + sLeftNumber;
        }
        final double leftNumber = Double.parseDouble(sLeftNumber);

        final String rightSide = expression.substring(operationPos + 1);
        final String[] rightSideNumbers = COMPILE.split(rightSide);
        final String sRightNumber = rightSideNumbers[0].isEmpty() ? '-' + rightSideNumbers[1] : rightSideNumbers[0];
        final double rightNumber = Double.parseDouble(sRightNumber);

        String result = "";
        switch (operation) {
            case "^":
                result = fourDigitFormat.format(StrictMath.pow(leftNumber, rightNumber));
                break;
            case "*":
                result = fourDigitFormat.format(leftNumber * rightNumber);
                break;
            case "/":
                result = fourDigitFormat.format(leftNumber / rightNumber);
                break;
            case "+":
                result = fourDigitFormat.format(leftNumber + rightNumber);
                break;
            case "-":
                result = fourDigitFormat.format(leftNumber - rightNumber);
                break;
        }
        if (leftNumber < 0 && expression.indexOf(sLeftNumber) > 0 && result.charAt(0) != '-') {
            result = '+' + result;
        }
        return expression.substring(0, operationPos - sLeftNumber.length()) + result + expression.substring(operationPos + sRightNumber.length() + 1);
    }

    int countNegativeNumbers(final String expression) {
        int counter = 0;
        if (expression.indexOf('-') == 0)
            counter++;
        counter += expression.split("\\(-").length - 1;
        return counter;
    }

    public Solution() {
        //don't delete
    }
}
