package carchallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenges {

    public static void main(String[] args) {


        String challenge = "I want a new bike";

        String solution = "I want a new bike";

        System.out.println("solution 1 " + challenge.matches(solution));

        String challenge2 = "I want a new bike";
        String challenge3 = "I want a new  ball";
        String regexTwo = "I want a new \\w+.";
        System.out.println(challenge2.matches(regexTwo));
        System.out.println(challenge3.matches(regexTwo));

        Pattern pattern = Pattern.compile(regexTwo);
        Matcher matcher = pattern.matcher(regexTwo);
        System.out.println(matcher.matches());

        System.out.println(challenge2.replaceAll("\\W","_"));
        System.out.println(challenge2.replaceAll("\\s","_"));

        //match the string with regular expressions
        String challenge5 = "aaabccccccccdddefffg";
        String regex5 = "a{3}bc{8}d{3}ef{3}g";
        String regex6 = "[a-g]+";
        System.out.println(challenge5.matches(regex5));
        System.out.println(challenge5.matches(regex6));

        String challenge6 = "abcd.135";
        String regex7 = "^[a-zA-Z]+\\.\\d+$";
        System.out.println(challenge6.matches(regex7));

        String challenge7 = "abcd.135uvqz.7tzik.999";
        String regex_7 ="(\\D+[.]\\d+)";
        Pattern pattern7 = Pattern.compile(regex_7);
        Matcher matcher7 = pattern7.matcher(regex_7);
        //System.out.println(matcher7.matches());

        int count = 0;
        while (matcher7.find())
        {
            count++;
            System.out.println("Occurrence : "+ count + " : " + matcher7.group(1));
        }
        String challenge8 = "abcd.135\tuvqz.7\tttzik.999\n";
        String regex8 ="([A-Za-z]+\\.(\\d+))";
        Pattern pattern8 = Pattern.compile(regex_7);
        Matcher matcher8 = pattern8.matcher(regex_7);
        //System.out.println(matcher7.matches());

        int count2 = 0;
        while (matcher8.find())
        {
            count2++;
            System.out.println("Occurrence : "+ count2 + " : " + matcher8.group(1));
        }
    }
}