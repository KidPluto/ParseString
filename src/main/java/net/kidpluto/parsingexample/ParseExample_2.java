package net.kidpluto.parsingexample;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 6/1/2017.
 */
public class ParseExample_2 {

    private String originalString;
    private static final Character openParen = new Character('(');
    private static final Character closeParen = new Character(')');
    private static final String openParenStr = new String("(");
    private static final String closeParenStr = new String(")");

    public ParseExample_2 () {};

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public String DoIt() {

        Splitter splitOnCommas = Splitter.on(',').trimResults();
        List<String> tokens = splitOnCommas.splitToList(originalString);
        // Do I want this instead?  ArrayList<String> myTokens = (ArrayList) tokens;
        System.out.print("The tokens are: ");
        for(String token: tokens) {
            System.out.print(token + "; ");
        }
        System.out.println();

        findMatchingParen(tokens, 0);


        return "Yes";
    }
// Sudo code I started with
//
//    call find-matching-paren (full-list-of-tokens, false, 0)
//
//    find-matching-paren (tokens, found-left-paren, indent-level)
//    loop on tokens
//        if token starts with left paren
//              remaining-tokens = drop left paren
//              find-matching-paren (remaining-tokens, true, indent-level ++)
//        else if token contains left paren
//              print/store chars before left paren, and indent-level
//              remaining-tokens = drop left paren, chars before it
//              find-matching-paren (remaining-tokens, true, indent-level )
//        else if token ends with right paren
//              print/store chars before right paren, and indent-level
//              exit
//    end loop

    private void findMatchingParen( List<String> tokens, Integer indentLevel) {

        for(String token: tokens) {
            System.out.println("=========================");
//            System.out.println("Token being processed: " + token);

            // token starts with open parenthesis
//            if( token.indexOf(openParen)==0) {
            if( token.startsWith(openParenStr)) {
                System.out.println("Token starts with open paren: [ " + token + " ], at indent level: " + indentLevel);

                // For the current token, drop open paren, and print/store it

                // New list of tokens, with current token removed
                tokens.remove(token);
                List<String> newTokens = new ArrayList<String>(tokens.);

                findMatchingParen(newTokens, indentLevel++);
            }
            // token contains open parenthesis
//            else if (token.indexOf(openParen)>0) {
            else if (token.contains(openParenStr)) {
                System.out.println("Token contains open paren: [ " + token + " ], at indent level: " + indentLevel);
                // New list of tokens,
            }
            // token ends with close parenthesis
//            else if (token.indexOf(closeParen) == token.length()-1) {
            else if (token.endsWith(closeParenStr)) {
                System.out.println("Token ends with close paren: [ " + token + " ], at indent level: " + indentLevel);
            }
            // token has no parentheses ...
            else {
                System.out.println("Token has no parens: [ " + token + " ], at indent level: " + indentLevel);
            }
            System.out.println();
        } // end for loop
    }
}
