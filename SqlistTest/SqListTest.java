package SqlistTest;

public class SqListTest {
    int[] data;
    int length;
    public SqListTest(int initialLength){
        if(initialLength < 0){
            throw new IllegalArgumentException();
        }
        this.data = new int[initialLength + 1];
        this.length = 0;
    }
    void insert(int pos,int digit){
        if(pos < 1 || pos > length + 1){
            throw new ArrayIndexOutOfBoundsException("Invalid");
        }
        int index = pos - 1;
        for(int j = length - 1 ; j >= index ; j--){
            data[j+1] = data[j];
        }
        data[index] = digit;
        length++;
        sqlistPrint();
        return;
    }

    private void sqlistPrint() {
        for (int i = 0; i < length ; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
