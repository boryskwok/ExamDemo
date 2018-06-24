package example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PrintListTest {
    @Test
    public void testPrintList(){
        ListNode ln =new ListNode(1);
        ln.next=new ListNode(2);
        PrintList pl= new PrintList();
//        Assert.assertEquals(new ArrayList<Integer>(){{add(2);add(1);}},pl.printListFromTailToHead(ln));
//        Assert.assertEquals(new ArrayList<Integer>(){{add(2);add(1);}},pl.printListFromTailToHead2(ln));
        Assert.assertEquals(new ArrayList<Integer>(){{add(2);add(1);}},pl.printListFromTailToHead3(ln));
    }
}
