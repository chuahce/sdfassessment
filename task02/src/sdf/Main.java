package sdf;

import java.io.Console;

public class Main {
  public static void main(String[] args) {
    Console cons = System.console();
    System.out.println("Welcome.");
    String equation = "";
    float result = 0.0f;

    while (!equation.equals("exit")) {
      equation = cons.readLine("> ");
      if (equation.equals("exit")) {
        System.out.println("Bye bye");
        break;
      }

      if (equation.contains("$last")) {
        equation = equation.replace("$last", String.format("%f", result));
      }

      String[] parts = equation.split(" ");
      if (parts.length != 3) {
        System.out.println("Invalid equation format. Enter in the following format: number space operator space number");
        continue;
      }
      try {
        float num1 = Float.parseFloat(parts[0]);
        float num2 = Float.parseFloat(parts[2]);
        char operator = parts[1].charAt(0);
        switch (operator) {
          case '+':
            result = num1 + num2;
            break;
          case '-':
            result = num1 - num2;
            break;
          case '*':
            result = num1 * num2;
            break;
          case '/':
            result = num1 / num2;
            break;
          default:
            System.out.println("Invalid operator");
            continue;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
      } catch (NumberFormatException e) {
        System.out.println("Enter in the following format: number space operator space number");
      }
    }
  }
}
