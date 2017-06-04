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
//    private static final Character closeParen = new Character(')');
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
            System.out.print(token + " ");
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

    // Using the for each looping, I don't know where in the list I am, to be able to create the new list
    // Let try changeing to a for loop
//
//    private void findMatchingParenOriginalCode(List<String> tokens, Integer indentLevel) {
//
//        int forLoopCount = 0;
//
//        for(String token: tokens) {
//            forLoopCount++;  // HACK!
//            System.out.println("debug =========================");
////            System.out.println("debug Token being processed: " + token);
//
//            //=========================================================================================
//            // token starts with open parenthesis; drop paren; print/store token; make recursive call;
//            if( token.startsWith(openParenStr)) {
//                System.out.println("debug Token starts with open paren: [ " + token + " ], at indent level: " + indentLevel);
//
//                String tokenWithoutOpenParen = new String(token.substring(1));
//
////                System.out.println("Print/store this: [ " + token.substring(1) + " ], at indent level: " + indentLevel);
//                System.out.println("Print/store this: [ " + tokenWithoutOpenParen + " ], at indent level: " + indentLevel);
//                List<String> newListOfTokens = new ArrayList<String>();
////                newListOfTokens.add(token.substring(1));
//                newListOfTokens.add(tokenWithoutOpenParen);
//                // Copy over all other items to new list of tokens
////                for (int i = 1; i < tokens.size(); i++) {
//                  for (int i = forLoopCount-1; i < tokens.size(); i++) {
//                    newListOfTokens.add(tokens.get(i));
//                }
//                System.out.println("debug newListOfTokens: " + newListOfTokens);
//                // Recursive call, with new list of tokens, and indent level incremented
//                findMatchingParenOriginalCode(newListOfTokens, indentLevel++);
//            }
//            //=========================================================================================
//            // token contains open parenthesis; ...
//            // employee(id
//            // Extract "employee" print/store it
//            // Create new list of tokens, "(id ..."
//            // Make recusive call
//            //
//            else if (token.contains(openParenStr)) {
//                System.out.println("debug Token contains open paren: [ " + token + " ], at indent level: " + indentLevel);
//
//                String tokenBeforeOpenParen = new String(token.substring(0, token.indexOf(openParen)));
//                String tokenStartingWithOpenParen = new String(token.substring(token.indexOf(openParen), (token.length())));
//
//                System.out.println("Print/store this: [ " + tokenBeforeOpenParen + " ], at indent level: " + indentLevel);
//
//                List<String> newListOfTokens = new ArrayList<String>();
//                newListOfTokens.add(tokenStartingWithOpenParen);
//                // Copy over all other items to new list of tokens
////                for (int i = 1; i < tokens.size(); i++) {
//                  for (int i = forLoopCount-1; i < tokens.size(); i++) {
//                    newListOfTokens.add(tokens.get(i));
//                }
//                System.out.println("debug newListOfTokens: " + newListOfTokens);
//                // Recursive call, with new list of tokens, and indent level incremented
//                findMatchingParenOriginalCode(newListOfTokens, indentLevel++);
//            }
//            //=========================================================================================
//            // token ends with close parenthesis; drop paren; print/store the token; continue
//            else if (token.endsWith(closeParenStr)) {
//                System.out.println("debug Token ends with close paren: [ " + token + " ], at indent level: " + indentLevel);
//                // something here
//                System.out.println("Print/store this: [ " + token + " ], at indent level: " + indentLevel);
//            }
//            //=========================================================================================
//            // token has no parentheses; print/store the token; continue
//            else {
//                System.out.println("debug Token has no parens: [ " + token + " ], at indent level: " + indentLevel);
//                System.out.println("Print/store this: [ " + token + " ], at indent level: " + indentLevel);
//            }
//            System.out.println("debug === end for loop ===");
//            System.out.println("debug");
//        } // end for loop
//    }
    //============================================================
    // Second attempt
    //
    // Using the for each looping, I don't know where in the list I am, to be able to create the new list
    // Let try changing to a for loop
    //
    // for loop
    // tokens.get(i) will return the string token
    //

    private void findMatchingParen(List<String> tokens, Integer indentLevel) {

       System.out.println("debug =========== start of method");

        for(int i=0; i<tokens.size(); i++) {

            String currentToken = tokens.get(i);

//            System.out.println("debug =========================");

            //=========================================================================================
            // token starts with open parenthesis; drop paren; print/store token; make recursive call;
            //
            if( tokens.get(i).startsWith(openParenStr)) {
               String tokenWithoutOpenParen = new String(currentToken.substring(1));
                List<String> newListOfTokens = new ArrayList<String>();
                newListOfTokens.add(tokenWithoutOpenParen);
                // Copy over all other items to new list of tokens
                for (int j = i+1; j < tokens.size(); j++) {
                    newListOfTokens.add(tokens.get(j));
                }
                // Recursive call, with new list of tokens, and indent level incremented
                findMatchingParen(newListOfTokens, ++indentLevel);
                indentLevel--;
                break;
            }
            //=========================================================================================
            // token contains open parenthesis; ... employee(id Extract "employee" print/store it
            // Create new list of tokens, "(id ..."  Make recusive call
            //
            else if (currentToken.contains(openParenStr)) {
                String tokenBeforeOpenParen = new String(currentToken.substring(0, currentToken.indexOf(openParen)));
                String tokenStartingWithOpenParen = new String(currentToken.substring(currentToken.indexOf(openParen), (currentToken.length())));
                System.out.println(indentLevel + " " + tokenBeforeOpenParen);
                List<String> newListOfTokens = new ArrayList<String>();
                newListOfTokens.add(tokenStartingWithOpenParen);
                // Copy over all other items to new list of tokens
                for (int j=i+1; j < tokens.size(); j++) {
                    newListOfTokens.add(tokens.get(j));
                }
                // Recursive call, with new list of tokens, and indent level incremented
                findMatchingParen(newListOfTokens, ++indentLevel);
                indentLevel--;
                break;
            }
            //=========================================================================================
            // token ends with close parenthesis; drop paren; print/store the token; continue
            //
            else if (currentToken.endsWith(closeParenStr)) {
                String tokenWithoutClosingParen = new String (currentToken.substring(0, currentToken.length()-1));
                System.out.println(indentLevel + " " + tokenWithoutClosingParen);
                break;
            }
            //=========================================================================================
            // token has no parentheses; print/store the token; continue
            //
            else {
                System.out.println(indentLevel + " " + currentToken);
            }
        } // end for loop
    }

}
