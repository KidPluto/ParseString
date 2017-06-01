package net.kidpluto.parsingexample;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 6/1/2017.
 */
public class ParsingExample {

    String originalString;
    String strToParse;

    public ParsingExample () {};

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public String DoIt() {

        System.out.println("Input is: [" + originalString  + "] ");
        // don't do this here - strToParse = RemoveSpaces(originalString);
        if (!DoAllErrorProcessing(originalString)) {
            // return error
        }
        // start the parsing
        strToParse = originalString;

//        Splitter niceCommaSplitter = Splitter.on(',').omitEmptyStrings().trimResults();
//        Iterable<String> tokens2 = niceCommaSplitter.split("I,am ,Legend, , oh ,you ?");
//        for(String token: tokens2){
//            System.out.println(token);

        // Can I use splitter, with the parens, to figure out if match up?

        Splitter splitOnCommas = Splitter.on(',').trimResults();
        List<String> tokens = splitOnCommas.splitToList(strToParse);
        // Do I want this instead?  ArrayList<String> myTokens = (ArrayList) tokens;
//        System.out.println("The tokens: ");
//        for(String token: tokens) {
//            System.out.println(token);
//        }
        Character openParen = new Character('(');
        Character closeParen = new Character(')');
        Integer level = 0;

        for(String token: tokens) {
            System.out.println("----------------------------------------------------");
            System.out.println("Processing token: " + token.toString());
            // if this "(token.indexOf(openParen) == -1)" is true paren not found
            int returnVal = token.indexOf(openParen);
            if ((token.indexOf(openParen) == -1) && (token.indexOf(closeParen) == -1)) {
                System.out.println("Token has no paren: " + token.toString() + ", at level " + level);
                // something here
            }
            else { // openParen and/or closeParen found in token
                if (token.indexOf(openParen) != -1) {
                    level++;
                    System.out.println("Token has left paren: " + token.toString() + ", at level " + level);
                    // Open parenthesis found
                }
                else {
                    // Logic tells us we must have close parenthesis
                    level--;
                    System.out.println("Token has right paren: " + token.toString() + ", at level " + level);
                }
            }
        }

        return "Yes";
    };
    public String RemoveSpaces(String originalString) {
        String strWithNoSpaces = new String();
        // code here
        return strWithNoSpaces;
    };

    public Boolean DoAllErrorProcessing(String str) {

        if( TestForMatchingParens(strToParse) &&
                TestForDoubleOpenParens(strToParse) &&
                TestForDoubleCloseParens(strToParse) &&
                TestForEmptyParens(strToParse) &&
                TestForCommaMissingAfterCloseParen(strToParse)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean TestForMatchingParens(String str) {return true;}

    public Boolean TestForDoubleOpenParens(String str) {return true;}

    public Boolean TestForDoubleCloseParens(String str) {return true;}

    public Boolean TestForEmptyParens(String str) {return true;}

    public Boolean TestForCommaMissingAfterCloseParen(String str) {return true;}
}
