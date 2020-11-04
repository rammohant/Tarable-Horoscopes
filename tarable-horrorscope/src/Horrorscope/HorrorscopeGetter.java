/* ***************************************************************************
 * HorrorscopeGetter
 ****************************************************************************
 * Class for a horoscope object to retrieve a horoscope from a server
 *_____________________________________________________
 * William Coleman, Christine Angeles, Tara "Ram" Mohan, Shan "Muffin Man" Amir
 * The version date
 * CMSC 255 Section 3
 ****************************************************************************/
package Horrorscope;
import java.io.*;
import java.time.LocalDate;
import java.net.URL;


/**
 * Generates a object to return horoscopes
 */
public class HorrorscopeGetter
{
    private static final String JOKE_URL = "http://williamc.pythonanywhere.com/horoscopeJokeAPI";
    private static final String SERIOUS_URL = "http://williamc.pythonanywhere.com/horoscopeAPI";
    private static final String ERR_MSG = "The position of the sun indicates you will have connectivity issues... " +
            "Please connect to the internet.";

    /**
     * Default Constructor
     */
    public HorrorscopeGetter()
    {
    }

    /**
     * Wrapper for getRandomHoroscopeOnline
     * @return Returns a joke horoscope
     */
    public String getJokeHoroscope()
    {
        return getRandomHoroscopeOnline(JOKE_URL);
    }

    /**
     * Wrapper for getRandomHoroscopeOnline
     * @return Returns a serious horoscope
     */
    public String getRealHoroscope()
    {
        return getRandomHoroscopeOnline(SERIOUS_URL);
    }

    /**
     * Queries a server to request a horoscope. Returns the horoscope to the caller. If we cannot open a URL,
     * return an error string.
     * @param horoscopeAPIAddress The URL address to query
     * @return Returns a string from the server
     */
    private String getRandomHoroscopeOnline(String horoscopeAPIAddress)
    {
        URL horoscopeAPI;
        BufferedReader input;
        StringBuilder outputStringReader;

        try {
            horoscopeAPI = new URL(horoscopeAPIAddress);
            input = new BufferedReader(new InputStreamReader(horoscopeAPI.openStream()));
            outputStringReader = new StringBuilder();
            String line;
            while((line = input.readLine()) != null){
                outputStringReader.append(line);
            }
        }
        catch(java.io.IOException e){
            return HorrorscopeGetter.ERR_MSG;
        }


        return outputStringReader.toString();
    }

    /**
     * Returns the day of the year for a given day and month
     * @param day day of the month
     * @param month month of the year.
     * @return integer representing day of the year
     ****************************************************************************/
    public static int dayOfYear (String month, int day) {

        int birthDayOfYear;

        /******************************************************************************
         * Calculate dayOfYear by adding number of days in given month to birth day
         *****************************************************************************/
        switch (month) {
            case "january":
                birthDayOfYear = day;
                return birthDayOfYear;
            case "february":
                birthDayOfYear = 31 + day;
                return birthDayOfYear;
            /******************************************************************************
             * If birthday is February 29 or March 1, dayOfYear = 60
             *****************************************************************************/
            case "march":
                birthDayOfYear = 31 + 28 + day;
                return birthDayOfYear;
            case "april":
                birthDayOfYear = 31 + 28 + 31 + day;
                return birthDayOfYear;
            case "may":
                birthDayOfYear = 31 + 28 + 31 + 30 + day;
                return birthDayOfYear;
            case "june":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + day;
                return birthDayOfYear;
            case "july":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + day;
                return birthDayOfYear;
            case "august":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + day;
                return birthDayOfYear;
            case "september":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day;
                return birthDayOfYear;
            case "october":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
                return birthDayOfYear;
            case "november":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
                return birthDayOfYear;
            case "december":
                birthDayOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
                return birthDayOfYear;
            default:
                birthDayOfYear = 0;
                return birthDayOfYear;
        }
    }


    /**
     * Returns a horoscope sign based upon a given day of the year in the range [0, 365]
     * @param date A LocalDate object representing selected day of the year
     * @return String: A horoscope sign
     */
    public static String getBirthSign(LocalDate date) {

        String birthSign;
        String[] monthArray = {"january", "february", "march", "april", "may","june","july","august","september",
                "october", "november","december"};

        int month = date.getMonthValue(); // month from 1 - 12
        int day = date.getDayOfMonth(); // day of month from 1 - 30/31
        int birthDayOfYear = dayOfYear(monthArray[month-1], day);

        /* *********************************************************
         * if birth day out of year is between 20 and 47 (inclusive)
         * then the sign is Capricorn
         **********************************************************/
        if (birthDayOfYear > 20 && birthDayOfYear <= 47) {
            birthSign = "Capricorn";
        }
        /* *********************************************************
         * if birth day out of year is between 47 and 70 (inclusive)
         * then the sign is Aquarius
         **********************************************************/
        else if (birthDayOfYear > 47 && birthDayOfYear <= 70) {
            birthSign = "Aquarius";
        }
        /* *********************************************************
         * if birth day out of year is between 70 and 108 (inclusive)
         * then the sign is Pisces
         **********************************************************/
        else if (birthDayOfYear > 70 && birthDayOfYear <= 108) {
            birthSign = "Pisces";
        }
        /* *********************************************************
         * if birth day out of year is between 108 and 133 (inclusive)
         * then the sign is Aries
         **********************************************************/
        else if (birthDayOfYear > 108 && birthDayOfYear <= 133) {
            birthSign = "Aries";
        }
        /* *********************************************************
         * if birth day out of year is between 133 and 172 (inclusive)
         * then the sign is Taurus
         **********************************************************/
        else if (birthDayOfYear > 133 && birthDayOfYear <= 172) {
            birthSign = "Taurus";
        }
        /* *********************************************************
         * if birth day out of year is between 172 and 201 (inclusive)
         * then the sign is Gemini
         **********************************************************/
        else if (birthDayOfYear > 172 && birthDayOfYear <= 201) {
            birthSign = "Gemini";
        }
        /* *********************************************************
         * if birth day out of year is between 201 and 222 (inclusive)
         * then the sign is Cancer
         **********************************************************/
        else if (birthDayOfYear > 201 && birthDayOfYear <= 222) {
            birthSign = "Cancer";
        }
        /* *********************************************************
         * if birth day out of year is between 222 and 259 (inclusive)
         * then the sign is Leo
         **********************************************************/
        else if (birthDayOfYear > 222 && birthDayOfYear <= 259) {
            birthSign = "Leo";
        }
        /* *********************************************************
         * if birth day out of year is between 259 and 303 (inclusive)
         * then the sign is Virgo
         **********************************************************/
        else if (birthDayOfYear > 259 && birthDayOfYear <= 303) {
            birthSign = "Virgo";
        }
        /* *********************************************************
         * if birth day out of year is between 303 and 327 (inclusive)
         * then the sign is Libra
         **********************************************************/
        else if (birthDayOfYear > 303 && birthDayOfYear <= 327) {
            birthSign = "Libra";
        }
        /* *********************************************************
         * if birth day out of year is between 327 and 333 (inclusive)
         * then the sign is Scorpio
         **********************************************************/
        else if (birthDayOfYear > 327 && birthDayOfYear <= 333) {
            birthSign = "Scorpio";
        }
        /* *********************************************************
         * if birth day out of year is between 333 and 351 (inclusive)
         * then the sign is Ophiuchus
         **********************************************************/
        else if (birthDayOfYear > 333 && birthDayOfYear <= 351) {
            birthSign = "Ophiuchus";
        } else {
            /* *********************************************************
             * if birth day out of year is greater than 351
             * and less than 20 (inclusive)
             * then the sign is Sagittarius
             **********************************************************/
            birthSign = "Sagittarius"; }

        return birthSign; // will return the birthSign back to the previous method
    }

}