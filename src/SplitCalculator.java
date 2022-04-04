import java.util.Scanner;

public class SplitCalculator {
    public static int minuteMaker(int mile) {
        for (int i = 0; true; i++) {
            mile -= 60;
            if (mile <= 60) {
                i++;
                i *= 100;
                mile += i;
                break;
            }
        }
        return mile;
    }
    public static void main(String[] args) {
        int seconds, minutes, evenSplits, remainder, mile1, mile2, mile3, differential;
        Scanner sc = new Scanner(System.in);

        //FINDING THE AMOUNT OF TOTAL SECONDS IN THE TIME
        System.out.println("Hi! Enter the amount of minutes in the 5k time you will achieve: ");
        minutes = sc.nextInt();

        System.out.println("Enter the amount of seconds in your time: ");
        seconds = sc.nextInt();
        seconds += minutes * 60;

        System.out.println("Enter the differential for your negative splits (if you want steady splits, enter 0):");
        differential = sc.nextInt();

        //NOW WE ARE FIGURING OUT THE SPLITS,
        remainder = ((seconds / 3) + 1) / 10;
        evenSplits = (seconds - remainder) / 3;

        mile1 = minuteMaker(evenSplits + differential);
        mile2 = minuteMaker(evenSplits);
        mile3 = minuteMaker(evenSplits - differential);

        //NOW WE SPLIT THE MINUTES AND SECONDS INTO DIFFERENT VARIABLES TO PREPARE FOR RE-SPLICING
        int splitMinutes1 = mile1 / 100;
        int splitSeconds1 = mile1 % 100;

        int splitMinutes2 = mile2 / 100;
        int splitSeconds2 = mile2 % 100;

        int splitMinutes3 = mile3 / 100;
        int splitSeconds3 = mile3 % 100;

        //FINALLY, WE SPLICE TOGETHER THE MINUTES AND SECONDS
        //THE IF STATEMENTS ARE ONLY NECESSARY TO ADD A ZERO BEFORE THE SECONDS COLUMN IF NEEDED
        if (splitSeconds1 < 10) {
            System.out.println("Mile 1:   " + splitMinutes1 + ":0" + splitSeconds1);
        } else {
            System.out.println("Mile 1:   " + splitMinutes1 + ":" + splitSeconds1);
        }
        if (splitSeconds2 < 10) {
            System.out.println("Mile 2:   " + splitMinutes2 + ":0" + splitSeconds2);
        } else {
            System.out.println("Mile 2:   " + splitMinutes2 + ":" + splitSeconds2);
        }
        if (splitSeconds3 < 10) {
            System.out.println("Mile 3:   " + splitMinutes3 + ":0" + splitSeconds3);
        } else {
            System.out.println("Mile 3:   " + splitMinutes3 + ":" + splitSeconds3);
        }
        System.out.println("Mile .10: 0:" + (remainder - 1));
        sc.close();
    }
}
