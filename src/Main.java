/**
 * java doc comment to describe how to use code
 * use one * for normal comments
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static int calculatePrincipal(int principal){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("principal (£1k - £1m): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                return principal;
            System.out.println("Enter a value between £1000 and £1,000,000. ");
        }
    }

    static float calculateInterestRate(float interestRate){
        Scanner scanner = new Scanner(System.in);
        final byte PERCENTAGE_TO_DECIMAL = 100;
        final byte MONTHS_IN_YEAR = 12;

        while(true){
            System.out.print("interest rate: ");
            interestRate = scanner.nextFloat();
            if (interestRate > 0 && interestRate <= 30) {
                interestRate = interestRate / (PERCENTAGE_TO_DECIMAL * MONTHS_IN_YEAR);
                return interestRate;
            }
            System.out.println("Enter a value more than 0 and less than 30. ");
        }
    }
    static double calculateTimePeriod(double timePeriod){
        Scanner scanner = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;

        while(true){
            System.out.print("time period (years): ");
            timePeriod = scanner.nextDouble();
            if (timePeriod > 0 && timePeriod <= 30){
                timePeriod = timePeriod * MONTHS_IN_YEAR;
                return timePeriod;
            }
            System.out.println("Enter a value between 1 and 30. ");
        }
    }

    /**
     * mortgage calculator
     * principal = total house value
     * interest rate input as yearly percentage
     * time period input as number of years
     */
    static void calculateMortgage(){
        // inputs 100,000 3.92 30 should output £472.81

        int principal = calculatePrincipal(0);
        float interestRate = calculateInterestRate(0);
        double timePeriod = calculateTimePeriod(0);

        double payment =
                principal *
                        (interestRate * Math.pow((1 + interestRate),(timePeriod)))/
                        (Math.pow((1 + interestRate),(timePeriod))-1);

        String paymentFormatted = NumberFormat.getCurrencyInstance().format(payment);

        System.out.println("payment: " + paymentFormatted);

    }

    static void buzzFizz(){
        // div by 5 = fizz, div by 3 = buzz, dive by both = fizzbuzz, else = print num
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");

        byte number = scanner.nextByte();

        if (number % 15 == 0){
            System.out.print("fizzbuzz");
        }
        else if (number % 5 == 0){
            System.out.print("fizz");
        }
        else if (number % 3 == 0){
            System.out.print("buzz");
        }
        else System.out.print(number);
    }
    static void practiceModule(){
        String[] fruits = {"apple", "pear", "orange"};
        // use when you know how many times you will execute a statement
        for (int i = 5 ; i > 0 ; i--){
            System.out.println("for hello world " + i);
        }

        // for each loop cannot access individual items
        for (String fruit : fruits)
            System.out.println(fruit);

        String input = "quit";
        Scanner scanner = new Scanner(System.in);

        // use when unsure how many times we will repeat the code
        while(true){
            System.out.print("while Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println(input);
        }

        // use when code should execute at least once
        do {
            System.out.println(input);
            System.out.print("do while Input: ");
            input = scanner.next().toLowerCase();
        } while(!input.equals("quit"));

        int income = 120_000;
        String role = "admin";

        // selects one of many cases to execute
        // more efficient than 'if, else if'
        switch (role) {
            case "admin":
                break;
            case "moderator":
                System.out.println("do this");
                break;
            default: // do this when other cases not met
        }

        // using ternary operator
        String className = income > 100_000 ? "first" : "economy";

    }

    static void printMultiples(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        for (int i = 1 ; i <= 10 ; i ++){
            System.out.println(number + " x "
                    + i + " = " + number * i);
        }
    }
    static void bubbleSort(){
        byte array[] = {9,8,7,6,5,4,3,2,1,0};
        int size = array.length;
        byte temp = 0;
        boolean swapped = false;

        for (int i = 0 ; i<(size-1) ; i++){
            swapped = false;
            for(int j = 0 ; j<(size-1-i) ; j++){
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false){
                break;
            }
        }

        for (int i = 0 ; i <= (size - 1) ; i++){
            System.out.print(array[i] + " ");
        }

    }

    static void printArray(byte array[], int size){


    }

    public static void main(String[] args) {

        bubbleSort();
    }

}