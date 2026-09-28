package Stack;

import LinkList.Node;

public class LinkStack {
    private Node stackPeek;
    private int stackSize = 0;

    public LinkStack() {
        stackPeek = null;
    }


    // 获取栈的长度
    public int getStackSize() {
        return stackSize;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return stackSize == 0;

    }

    // 入栈
    public void push(int num) {
        Node s = new Node(num);
        s.next = stackPeek;
        stackPeek = s;
        stackSize++;
    }

    // 出栈
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stackSize--;
        return num;
    }

    // 获取栈顶元素
    public int peek() {
        if (stackSize == 0) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    // toArray返回为数组
    public int[] toArray() {
        Node node = stackPeek;
        int[] res = new int[stackSize];
        for (int i = stackSize - 1; i >= 0; i--) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }


}
