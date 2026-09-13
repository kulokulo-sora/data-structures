package LinkList;

import java.util.Scanner;

public class DoublyNode {
    int data;
    DoublyNode prior;
    DoublyNode next;

    public DoublyNode() {
    }

    public DoublyNode(int data, DoublyNode prior, DoublyNode next) {
        this.data = data;
        this.prior = prior;
        this.next = next;
    }

    public DoublyNode(int data) {
        this.data = data;
    }

    //创建存在头节点的双向循环链表（空）
    public DoublyNode initList() {
        DoublyNode head = new DoublyNode();
        head.next = head;
        head.prior = head;
        return head;
    }

    //尾插法创建双向链表
    public DoublyNode createTailDoublyList(int n) {
        DoublyNode head = initList();
        DoublyNode tail = head;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            DoublyNode s = new DoublyNode(sc.nextInt());
            s.prior = tail;//新结点的prior指向原tail
            tail.next = s;//原tail指向新结点
            tail = s;//更新尾结点
        }
        tail.next = head;
        head.prior = tail;
        return head;
    }

    //双向链表按位查找
    public DoublyNode getElemDoubly(DoublyNode head, int k) {
        if (head == null || k < 1) return null;

        DoublyNode p = head.next;
        int i = 1;
        while (p != head && i < k) {
            p = p.next;
            i++;
        }
        return i == k ? p : null;
    }

    //双向循环链表插入
    public boolean insertDoubly(DoublyNode L, int i, int e) {
        if (i < 1) {
            return false;
        }
        DoublyNode p = getElemDoubly(L, i);//直接获得i处的节点 用于插入操作
        if (p == null) {
            return false;
        }
        DoublyNode s = new DoublyNode(e);//创建需要插入的节点
        s.prior = p.prior;//将 i处前驱结点 赋值给 新结点前驱
        p.prior.next = s;// i处前驱的后继结点为s
        s.next = p;// s后继为p
        p.prior = s;
        return true;
    }

    //双向循环链表删除
    public boolean deleteDoubly(DoublyNode L, int i) {
        if (i < 1) {
            return false;
        }
        DoublyNode p = getElemDoubly(L, i);
        if (p == null || p == L) {
            return false;
        }
        p.prior.next = p.next;
        p.next.prior = p.prior;
        return true;
    }
}
