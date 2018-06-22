package com.migu.sort;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by BorysKwok on 2018/6/21.
 */
public class SortTest {
    @Test
    public void TestSort() throws Exception{
        Sort sort=new Sort();

        int[] arr={5,66,3,1};
        sort.sortList(arr);
        assertEquals("13566",sort.toString());
    }
}
