package calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Calc {
    private static final Logger logger = LogManager.getLogger(Calc.class);

    public Calc() {
    }

    public static void main(String[] args) {
        Calc calculator = new Calc();
        Scanner scanner = new Scanner(System.in);
        double number1, number2 = 0;
        do {
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print("Press 1 to Add\nPress 2 to Subtract\nPress 3 to Multiply\nPress 4 to Divide\nPress 5 to Inverse\nPress 6 for Factorial\nPress 7 to Power\nPress 8 to find Square Root\nPress 9 to find Log\n Press any other key to exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            if((choice==5) || (choice==6) || (choice==8) || (choice==9)) {
                try{
                    System.out.print("Enter the number : ");
                    number1 = scanner.nextDouble();
                } catch (InputMismatchException error) {
                    return;
                }
            }
            else {
                try {
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid input, Entered input is not a number");
                    return;
                }
            }
            switch (choice) {
                case 1:
                    // do addition
                    System.out.println("Addition result is : " + calculator.add(number1, number2));
                    break;
                case 2:
                    // do subtraction
                    System.out.println("Subtraction result is : " + calculator.subtract(number1, number2));
                    break;
                case 3:
                    // do multiplication
                    System.out.println("Multiplication result is : " + calculator.multiply(number1, number2));
                    break;
                case 4:
                    // do division
                    System.out.println("Division result is : " + calculator.divide(number1, number2));
                    break;
                case 5:
                    // do inverse
                    System.out.println("Inverse result is : " + calculator.inverse(number1));
                    break;
                case 6:
                    // do factorial
                    System.out.println("Factorial result is : " + calculator.factorial(number1));
                    break;
                case 7:
                    // do x power y
                    System.out.println("X power Y is : " + calculator.powered(number1, number2));
                    break;
                case 8:
                    // do square root
                    System.out.println("Square root is : " + calculator.root(number1));
                    break;
                case 9:
                    // do log
                    System.out.println("Log is : " + calculator.log(number1));
                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double add(double number1, double number2) {
        logger.info("[ADDITION] - " + number1 + ", " + number2);
        double result = number1 + number2;
        logger.info("[RESULT - ADDITION] - " + result);
        return result;
    }

    public double subtract(double number1, double number2) {
        logger.info("[SUBTRACTION] - " + number1 + ", " + number2);
        double result = number1 - number2;
        logger.info("[RESULT - SUBTRACTION] - " + result);
        return result;
    }


    public double multiply(double number1, double number2) {
        logger.info("[MULTIPLICATION] - " + number1 + ", " + number2);
        double result = number1 * number2;
        logger.info("[RESULT - MULTIPLICATION] - " + result);
        return result;
    }

    public double divide(double number1, double number2) {
        double result = 0;
        try {
            logger.info("[DIVISION] - " + number1 + ", " + number2);
            if (number1 == 0 && number2 == 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            } else if (number1 > 0 && number2 == 0) {
                result = Double.POSITIVE_INFINITY;
                throw new ArithmeticException("Case of Positive Infinity 1.0/0.0");
            } else if (number1 <= -1 && number2 == 0) {
                result = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Case of Negative Infinity -1.0/0.0");
            } else {
                result = number1 / number2;
            }
        } catch (ArithmeticException error) {
            logger.error("[EXCEPTION - DIVISION] - Cannot be divided by ZERO " + error.getLocalizedMessage());
        } finally {
            logger.info("[RESULT - DIVISION] - " + result);
        }
        return result;
    }
    public double inverse(double number1) {
        double result;
        double number = 1;
        result = divide(number,number1);
        return result;
    }
    public double factorial(double number1) {
        double result = 1;
        int i;
        int x = (int) number1;
        try {
            logger.info("[FACTORIAL] - " + number1);
            if(number1!=x) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN");
            }
            else if(number1<0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN");
            } else if(number1>=0) {
                for(i=2;i<=number1;i++) {
                    result=result*i;
                }
            }
        } catch (ArithmeticException error) {
            logger.error("[EXCEPTION - FACTORIAL] - Cannot be found " + error.getLocalizedMessage());
        } finally {
            logger.info("[RESULT - FACTORIAL] - " + result);
        }
        return result;
    }
    public double powered(double number1, double number2) {
        double result;
        result = Math.pow(number1, number2);
        try {
            if(result == Double.NaN) {
                throw new ArithmeticException("Case of NaN");
            }
            else {
                result=result*1;
            }
        } catch (ArithmeticException error) {
            logger.error("[EXCEPTION - POWER] - Cannot be found " + error.getLocalizedMessage());
        } finally {
            logger.info("[RESULT - POWER] - " + result);
        }
        return result;
    }
    public double root(double number1) {
        double result;
        double number = 0.5;
        result = powered(number1,number);
        return result;
    }
    public double log(double number1) {
        double result;
        result = Math.log(number1);
        return result;
    }
}
