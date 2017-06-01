package net.kidpluto.parsingexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chris on 5/31/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldTest {

    @Test
    public void HelloWorldTestOne() throws Exception {
        HelloWorld hw = new HelloWorld();
        assertNotNull(hw);

    }
}