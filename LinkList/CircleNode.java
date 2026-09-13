package LinkList;

import java.util.Scanner;

public class CircleNode {
    int data;
    CircleNode next;

    public CircleNode() {
    }

    public CircleNode(int data, CircleNode next) {
        this.data = data;
        this.next = next;
    }

    public CircleNode(int data) {
        this.data = data;
    }
    //创建存在头结点的循环空链表
    public CircleNode initList(){
        CircleNode L = new CircleNode();
        L.next=L;
        return L;
    }
    //尾插法创建循环链表
    public CircleNode createTailCircleList(int n){
        CircleNode L = initList();
        CircleNode tail = L;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            CircleNode s = new CircleNode(sc.nextInt());
            tail.next = s;
            tail = s;
        }
        tail.next = L;//实现循环

        return tail;
    }

    //循环链表获得首元节点
    public CircleNode getFirstNode(CircleNode tail){
        return tail.next.next;
    }
}
