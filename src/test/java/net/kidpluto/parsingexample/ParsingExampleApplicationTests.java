package net.kidpluto.parsingexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// I had to put this in manually
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsingExampleApplicationTests {

// ParsingExampleApplication is invoked by default, not sure how.

// Got this by default, wasn't sure what to do with it.
//	@Test
//	public void contextLoads() {
//	}

//    @Before
//    ParsingExample pe = new ParsingExample();

    @Test
	public void HelloWorldTest() throws Exception {
		HelloWorld hw = new HelloWorld();
		assertNotNull(hw);

	}
	@Test
    public void TestRemoveSpaces() {
        String NoSpace = new String("ABC");

        ParsingExample pe = new ParsingExample();
        pe.setOriginalString("ABC");
//        pe.RemoveSpaces()

    }

	@Test
	protected void TestForMatchingParens(String str) {}

	@Test
	protected void TestForDoubleOpenParens(String str) {}

    @Test
    protected void TestForDoubleCloseParens(String str) {}

	@Test
	protected void TestForEmptyParens(String str) {}

	@Test
    protected void TestForCommaMissingAfterCloseParen(String str) {}



}
