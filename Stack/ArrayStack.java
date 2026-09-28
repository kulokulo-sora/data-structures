package Stack;

import java.util.ArrayList;


public class ArrayStack {
    private ArrayList<Integer> stack;


    // 初始化
    public ArrayStack(){
        stack = new ArrayList<>();
    }
    // 判断是否为空
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    // 获得栈顶元素
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stack.getLast();
    }
    // 入栈
    public void push(int num){
        stack.add(num);
    }
    // 出栈
    public int pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stack.removeLast();
    }

    // 转为数组
    public Object[] toArray(){
        return stack.toArray();
    }

}
