package LinkList;

import java.util.Scanner;

public class Node {
    int val;
    Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    //创建存在头结点的空表
    public Node initList() {
        Node L = new Node();
        L.next = null;
        return L;
    }

    //尾插法创建单链表
    public Node createTailList(int n) {
        //初始化创建头结点
        Node L = initList();
        Node tail = L;//创建尾结点
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            Node s = new Node(sc.nextInt());
            tail.next = s;//tail结点指向新节点s
            tail = s;//更新尾结点
        }
        return L;
    }

    //头插法创建单链表
    public Node createHeadList(int n) {
        //初始化创建头结点
        Node L = initList();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            Node q = new Node(sc.nextInt());
            q.next = L.next;//使新结点p指向头结点指向的的next结点
            L.next = q;//头结点next指向新结点p
        }
        return L;
    }


    //单链表按值查找
    public Node find(Node L, int e) {
        Node p = L.next;//从第一个存有数据的节点开始
        while (p != null && p.val != e) {
            p = p.next;
        }
        return p;
    }

    //单链表按位序查找 包括头结点情况
    public Node findIndex(Node L, int k) {
        if (L == null || k < 0) return null;
        Node p = L;
        int i = 0;//按位序遍历查找
        while (p != null && i < k) {
            p = p.next;
            i++;
        }
        return p;
    }

    //单链表插入
    public boolean insert(Node L, int e, int i) {
        if (i < 1) {
            return false;
        }
        Node p = findIndex(L, i - 1);
        if (p == null) {
            return false;
        }
        Node s = new Node(e);
        s.next = p.next;
        p.next = s;
        return true;
    }

    //单链表删除
    public boolean delete(Node L, int i) {
        if (i < 1) {
            return false;
        }
        Node p = findIndex(L, i - 1);
        if (p == null || p.next == null) {
            return false;
        }
        Node d = p.next;
        p.next = d.next;
        return true;
    }
}
