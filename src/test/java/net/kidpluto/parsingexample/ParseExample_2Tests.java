package net.kidpluto.parsingexample;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Chris on 6/2/2017.
 */
public class ParseExample_2Tests {

    @Test
    public void TopLevelTest () throws Exception {
        ParseExample_2 pe2 = new ParseExample_2();
        pe2.setOriginalString("(one,two,three,four,five)");
        pe2.DoIt();
    }
    @Test
    public void TwoLevelTest () throws Exception {
        ParseExample_2 pe2 = new ParseExample_2();
        pe2.setOriginalString("(one,two(three),four,five)");
        pe2.DoIt();
    }
}
