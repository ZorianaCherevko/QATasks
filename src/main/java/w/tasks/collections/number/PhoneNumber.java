package w.tasks.collections.number;

import java.util.Scanner;

public class PhoneNumber {

    static int sum(int phoneNumber) {
        int sum = 0;
        while (phoneNumber > 0) {
            int digit = phoneNumber % 10;
            sum += digit;
            phoneNumber = phoneNumber / 10;
        }
        return sum;
    }

    static void writeResultWord(int sumUntilOneDigit) {
        switch (sumUntilOneDigit) {
            case 1 -> System.out.println("One");
            case 2 -> System.out.println("Two");
            case 3 -> System.out.println("Three");
            case 4 -> System.out.println("Four");
            default -> System.out.println(sumUntilOneDigit);
        }

    }

    public static boolean isValid(String input) {
        do {

            if (input.startsWith("+380") || input.startsWith("00380")
                    || input.startsWith("093") || input.startsWith("067")) {
                return true;
            } else {
                return false;
            }
        } while (input.length()>=10 && input.length()<=13 );
    }


    public static void main(String[] args) {
        System.out.println("Please enter the phone number:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!isValid(input)) {
            System.out.print("Phone number is incorrect. Please enter the phone number: ");
            input = scanner.nextLine();
        }

        int phoneNumber = Integer.parseInt(input);
        int sumOfAllDigits = sum(phoneNumber);
        int sumOfTwoDigits = sum(sumOfAllDigits);

        System.out.println("1st round of calculation: " + sumOfAllDigits);
        System.out.println("2st round of calculation: " + sumOfTwoDigits);

        int sumUntilOneDigit;
        if (sumOfTwoDigits > 10) {
            sumUntilOneDigit = sum(sumOfTwoDigits);
            System.out.println("3rd round of calculation: " + sumUntilOneDigit);
        } else {
            sumUntilOneDigit = sumOfTwoDigits;
        }
        System.out.print("Final result is: ");
        writeResultWord(sumUntilOneDigit);


    }
}
