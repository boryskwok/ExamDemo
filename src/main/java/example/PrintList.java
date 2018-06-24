package example;
//https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PrintList {
    // 堆栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrList = new ArrayList<>();
        if (listNode == null)
            return arrList;
        // init class
        ListNode t = listNode;
        //temp ListNode
        while (t != null) {
            stack.push(t.val);
            t = t.next;
        }
        while (!stack.empty()) {
            arrList.add(stack.pop());
        }
        return arrList;
    }

    //java 递归超简洁版本
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    // Collections
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode){
        ArrayList<Integer> list =new ArrayList<>();
        while (listNode !=null){
            list.add(listNode.val);
            // 将val 存入list
            listNode=listNode.next;
        }
        Collections.reverse(list);
        // 使用Collections的reverse进行反转
        return list;
    }
}
