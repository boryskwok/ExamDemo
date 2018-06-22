package com.migu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BorysKwok on 2018/6/21.
 */
public class Sort {
    static List<Integer> list=new ArrayList<Integer>();

    public void sortList(int[] arr){
        for (int i=0;i<arr.length;i++)
            list.add(arr[i]);
        Collections.sort(list);
    }

    @Override
    public String toString() {
        String s=new String();
        for(int a:list){
            s+=a;
        }
        return s;
    }
}
