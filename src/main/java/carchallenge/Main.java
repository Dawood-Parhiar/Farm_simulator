package carchallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String myString = "I am a String";
        System.out.println(myString);
        String yourString = myString.replace("I","You");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12Ghiiiiijkl99z";
        System.out.println(alphaNumeric.replace(".","Y"));

        System.out.println(alphaNumeric.replace("^abcdeee","yyy"));
        System.out.println(alphaNumeric.replace("^abcdeee","yyy"));

        System.out.println(alphaNumeric.matches("^Hello"));
        System.out.println(alphaNumeric.matches("^abcDeee"));
        System.out.println(alphaNumeric.matches("^abcDeeeF12Ghiiiiijkl99z"));

        System.out.println(alphaNumeric.replaceAll("ijkl99z$","The end"));
        System.out.println(alphaNumeric.replaceAll("[aei]","game over"));
        System.out.println(alphaNumeric.replaceAll("ijkl99z$","The end"));

        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        System.out.println(alphaNumeric);
        System.out.println(alphaNumeric.replaceAll("[^ej]","x"));

        System.out.println(alphaNumeric.replaceAll("[a-fA-F3-8]","x"));
        System.out.println(alphaNumeric.replaceAll("(?i)[a-f,3-8]","z"));
        System.out.println(alphaNumeric.replaceAll("[0-9]","r"));
        
        System.out.println(alphaNumeric.replaceAll("\\d","d"));
        System.out.println(alphaNumeric.replaceAll("\\D","T"));

        String hasWhiteSpace = "i have blanks and \ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));
        System.out.println(hasWhiteSpace.replaceAll("\t",""));
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\W","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));

        String test = "abcDeeeeeeF12Ghiiiiijkl99z";
        System.out.println(test);
        System.out.println(test.replaceAll("^abcDe{3}","HHH"));
        System.out.println(test.replaceAll("^abcDe+","HHH"));
        System.out.println(test.replaceAll("^abcDe*","HHH"));
        System.out.println(test.replaceAll("^abcDe{2,5}","HHH"));
        System.out.println(test.replaceAll("h+i*j","L"));

        StringBuilder htmlText = new StringBuilder("<h1>Big Heading </h>");
        htmlText.append("<h2> Sub-heading </h2>");
        htmlText.append("<p>Paragraph about something</p>");
        htmlText.append("<p> Another paragraph</p>");
        htmlText.append("<h2> Summary </h2>");
        htmlText.append("<p>New paragraph</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());


        matcher.reset();
        int count = 0;
        while (matcher.find())
        {
            count++;

            System.out.println("Occurrence "+ count + " : "+ matcher.start()  + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find())
        {
            System.out.println("Occurrence: "+ groupMatcher.group(1));
        }
        String h2TextGroup  = "(<h2>)(.*?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find())
        {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find())
        {
            count++;
            System.out.println("Occurrence : "+ count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890"; //should not match
        String phone2 = "(123) 456-7890";// should not match
        String phone3 = "(123) 456-7890";// should not match
        String phone4 = "(123) 456-7890";// should not match

        //System.out.println("Phone 1" = phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3[\\-]{1}[0-9]{4})$"));


        String visa1 = "4444444444444"; //should not match
        String visa2 = "5444444444444"; //should not match
        String visa3 = "4444444444444444"; //should not match
        String visa4 = "4444"; //should not match

        String visaRegex = "^4[0-9]{12}$|^4[0-9]{15}$";
        String visaRegex2 = "^4[0-9]{12}([]0-9{3})?$";
        System.out.println("visa 1 "+ visa1.matches((visaRegex)));
        System.out.println("visa 2 "+ visa1.matches((visaRegex)));
        System.out.println("visa 3 "+ visa1.matches((visaRegex)));
        System.out.println("visa 4 "+ visa1.matches((visaRegex)));

        System.out.println("visa 1 "+ visa1.matches((visaRegex2)));
        System.out.println("visa 2 "+ visa1.matches((visaRegex2)));
        System.out.println("visa 3 "+ visa1.matches((visaRegex2)));
        System.out.println("visa 4 "+ visa1.matches((visaRegex2)));
    }
}
