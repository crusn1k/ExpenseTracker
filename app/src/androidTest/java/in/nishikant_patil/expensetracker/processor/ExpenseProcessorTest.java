package in.nishikant_patil.expensetracker.processor;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import in.nishikant_patil.expensetracker.model.Message;

/**
 * Created by Nishikant on 7/13/2015.
 */
public class ExpenseProcessorTest {
    Message testMessage;

    @Before
    public void init(){
        testMessage = new Message();
        testMessage.setId("1337");
        testMessage.setAddress("fooville");
    }

    @Test
    public void testPass(){
        testMessage.setContent("blah blah debited blah blah INR 0.");
        Assert.assertTrue(ExpenseProcessor.process(testMessage));
        testMessage.setContent("blah blah purchase blah blah INR 0.");
        Assert.assertTrue(ExpenseProcessor.process(testMessage));
    }

    @Test
    public void testFail(){
        testMessage.setContent("blah blah credited blah blah INR 0.");
        Assert.assertFalse(ExpenseProcessor.process(testMessage));
    }
}
