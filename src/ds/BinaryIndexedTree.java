package ds;

public class BinaryIndexedTree {

    /*
     * This BIT supports integers from -2^31 to 2^31-1.
     * It has a theoretical max size of an array's length of 2^31-2;
     * */

    private int[] resp;

    public BinaryIndexedTree(int size){
        resp = new int[size + 1];
    }

    public BinaryIndexedTree(int[] arr){
        resp = new int[arr.length + 1];
    }

    public void set(int index, int val){
        index++;
        int x = query(index, index);
        int add = val - x;

        for (int i = index; i < resp.length; i += i & (-i)) {
            resp[i] += add;
        }
    }

    public int query(int begin, int end){
        return query(end) - query(begin - 1);
    }

    public int query(int end){
        int total = 0;
        for (int i = end; i > 0; i -= i & (-i)) {
            total += resp[i];
        }

        return total;
    }

    private void createArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            set(i, arr[i]);
        }
    }

}
