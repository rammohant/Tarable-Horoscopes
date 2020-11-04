/* ***************************************************************************
 * HorrorscopesCLI
 ****************************************************************************
 * Command Line Interface for HorrorscopeGetter
 *_____________________________________________________
 * William "Resident DumbDonkey" Coleman, Christine "City of Angles" Angeles, Tara "Ram" Mohan, Shan "Muffin Man" Amir
 * The version date
 * CMSC 255 Section 3
 ****************************************************************************/
package Horrorscope;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * A command line interface for testing and debugging HorrorscopeGetter
 */
public class HorrorscopesCLI {
    public static void main(String[] args){
        runCommandLineInterface();
    }

    /**
     * Starts a command line interface for generating a horoscope based on date of birth
     */
    public static void runCommandLineInterface()
    {
        Scanner input = new Scanner(System.in);
        String quit = "";

        do {

            /* ****************************************************************************
             * User input and variable declaration of birth month
             *****************************************************************************/
            System.out.print("Month: ");
            int month = input.nextInt();

            /* ****************************************************************************
             * User input and variable declaration of birth day
             *****************************************************************************/
            System.out.print("Day: ");
            int day = input.nextInt();
            /* ****************************************************************************
             * If inputs are valid, print horrorscope (to be added)
             *****************************************************************************/

            // If the user entered the correct number
            if (checkValidity(month, day)) {

                String birthSign = HorrorscopeGetter.getBirthSign(LocalDate.of(1992, month, day));
                HorrorscopeGetter horoscope = new HorrorscopeGetter();
                System.out.printf("Joke %s: %s\n",birthSign, horoscope.getJokeHoroscope());
                System.out.printf("Serious %s: %s\n",birthSign, horoscope.getRealHoroscope());


                /* *****************************************************************************
                 * If inputs are not valid, print "invalid input"
                 *****************************************************************************/

            } else {
                System.out.println(month + " " + day + " is not a valid birth date");
            }

            System.out.println("\nWould you like to get another HorrorScope? Enter quit to exit.");
            input.nextLine();
            quit = input.nextLine().trim();

        } while (!quit.toLowerCase().equals("quit"));
    }

    /**
     * Ensures that an integer a day is valid in a given month
     * @param month An integer representation of a month
     * @param day An integer representation of a day
     * @return True/False
     */
    public static boolean checkValidity (int month, int day) {

        switch (month) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12 :
                if (day <= 31) return true;

            case 2:
                if (day <= 28) return true;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day <= 30) return true;

            default:
                return false;
        }

    }

}
