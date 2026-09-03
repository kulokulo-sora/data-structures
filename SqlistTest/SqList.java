package SqlistTest;

public class SqList {
    int[] data;
    int length;
    private static final int DEFAULT_LENGTH = 10;
    public SqList(){
        this(DEFAULT_LENGTH);
    }
    public SqList(int initialLength){
        if(initialLength< 0){
            throw new IllegalArgumentException("容量不能为负");
        }
        //分配的内存大小
        this.data = new int[initialLength];
        this.length = 0;

    }
    //1.尾部追加
    boolean add (int x){
        //先判断是否满，满了就扩容
        if(length == data.length){
            grow();
        }
        data[length++] = x;
        return true;
    }

    //2.扩容 2倍
    private void grow() {
        int newLength = data.length == 0 ? 1 : data.length*2;
        int[] newData = new int[newLength];
        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }
        //替换为新数组
        data = newData;
    }
    //3.插入 按下标
    void insert(int x,int index){
        if(index<0||index>length){
            throw new IndexOutOfBoundsException("下标不能越界！");
        }
        if(length == data.length){
            grow();
        }
        for(int j = length - 1  ; j >= index ; j--){
            data[j+1] = data[j];
        }
        data[index] = x;
        length++;
    }
    //4.删除 按下标
    int remove(int index) {
        if (index < 0 || index >= length ) {//按照逻辑位序 应为if (index<1 || index > length)
            throw new IndexOutOfBoundsException("下标不能越界！");
        }
        int x = data[index];//按照逻辑位序 data[i-1]
        for (int j = index; j < length - 1; j++) {
            // 按照逻辑位序 for(int j = index - 1; j<= length - 1 ; j++){data[j] = data[j+1]}
            data[j] = data[j+1];
        }
        data[length-1] = 0;
        length--;
        return x;
    }

    int remove_2(int index){
        if(index < 1 || index > length){
            throw new IndexOutOfBoundsException();
        }
        //删除下标i-1上的元素
        int x = data[index - 1];
        for(int j = index ; j<= length - 1;j++){
            data[j-1] = data[j];
        }
        data[length-1] = 0;
        length--;
        return x;
    }
    //5.获得元素 按照下标
    int get(int index){
        if (index < 0 || index >= length ) {//按照逻辑位序 应为if (index<1 || index > length)
            throw new IndexOutOfBoundsException("下标不能越界！");
        }
        return data[index];
    }
    //6.修改 按照下标
    int set(int x,int index){
        if (index < 0 || index >= length ) {//按照逻辑位序 应为if (index<1 || index > length)
            throw new IndexOutOfBoundsException("下标不能越界！");
        }
        int element = data[index];
        data[index] = x;
        return element;
    }
    //7.查找 按照小标
    int indexOf(int x){
        for (int i = 0; i < length; i++) {
            if(data[i] == x){
                return i;
            }
        }
        return -1;
    }
    //8.清空 直接clear
    void clear(){
        length = 0;
    }
    //9.打印
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]);
            if(i != length - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //10.判空
    boolean isEmpty(){
        return length==0;
    }
    //11.返回长度
    int size(){
        return length;
    }
}
