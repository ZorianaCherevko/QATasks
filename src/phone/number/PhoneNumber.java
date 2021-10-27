package phone.number;

import java.util.Scanner;

public class PhoneNumber {

    static int sumOfAllDigits(int phoneNumber) {
        int sum = 0;
        while (phoneNumber > 0) {
            int digit = phoneNumber % 10;
            sum = sum + digit;
            phoneNumber = phoneNumber / 10;
        }
        return sum;
    }

    static int sumOfTwoDigits(int sumOfAllDigits) {
        int sum = 0;
        while (sumOfAllDigits > 0) {
            int digit = sumOfAllDigits % 10;
            sum = sum + digit;
            sumOfAllDigits = sumOfAllDigits / 10;
        }
        return sum;
    }

    static int sumUntilOneDigit(int sumOfTwoDigits) {
        int sum = 0;
        while (sumOfTwoDigits > 0) {
            int digit = sumOfTwoDigits % 10;
            sum = sum + digit;
            sumOfTwoDigits = sumOfTwoDigits / 10;
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

    public static boolean isValid(String userInput)
    {
        if (userInput.length() >= 11 && userInput.length() <= 13)
        {
            if(userInput.startsWith("+380") || userInput.startsWith("00380")
                    || userInput.startsWith("093") || userInput.startsWith("067"))
            {
                return  true;
            }
            else{
                return  false;
            }
        }
        try
        {
            int i = Integer.parseInt(userInput);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("Please enter the phone number:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        while (!isValid(userInput)) {
            System.out.print("Phone number is incorrect. Please enter the phone number: ");
            userInput = scanner.next();
        }

        int phoneNumber = Integer.parseInt(userInput);
        int sumOfAllDigits = sumOfAllDigits(phoneNumber);
        int sumOfTwoDigits = sumOfTwoDigits(sumOfAllDigits);

        System.out.println("1st round of calculation: " + sumOfAllDigits);
        System.out.println("2st round of calculation: " + sumOfTwoDigits);

        int sumUntilOneDigit;
        if (sumOfTwoDigits > 10) {
            sumUntilOneDigit = sumUntilOneDigit(sumOfTwoDigits);
            System.out.println("3rd round of calculation: " + sumUntilOneDigit);
        } else {
            sumUntilOneDigit = sumOfTwoDigits;
        }
        System.out.print("Final result is: ");
        writeResultWord(sumUntilOneDigit);


    }
}
