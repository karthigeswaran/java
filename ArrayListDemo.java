import java.util.Arrays;

class ArrayListDemo {
    public static void main(String args[]) throws Exception {
        Integer[] array = {5,5,6,5,6,5,2,3,3};
        MyArrayList<Integer> arraylist = new MyArrayList<Integer>(array);
        System.out.println(arraylist);
        arraylist.add(2);
        System.out.println(arraylist);
        arraylist.remove(9);
        System.out.println(arraylist);
        System.out.println(arraylist.pop());
        System.out.println(arraylist);
        System.out.println(arraylist.indexOf(6));
        System.out.println(arraylist.lastIndexOf(6));
        System.out.println(arraylist.get(5));
    }
}

class MyArrayList<T> {
    private int length = 0;
    private int size = 10;
    private Object[] array;

    public MyArrayList(){
        array = new Object[size];
    }

    public MyArrayList(T[] obj) {
        length = obj.length;
        size = 2 * length;
        array = Arrays.copyOf(obj, size);
    }

    public MyArrayList(int cap) {
        if(cap > 0) size = cap;
        array = new Object[size];
    }

    public MyArrayList(T[] obj, int cap) {
        length = obj.length;
        if(cap > 0) size = cap;
        array = Arrays.copyOf(obj,cap);
    }

    void add(T obj) {
        if (length == size) {
           this.increaseSize();
        }
        array[length++] = obj;
    }

    boolean remove(T obj) {
        int ind = this.indexOf(obj);
        if (ind == length-1) {
            array[length--] = 0;
            return true;
        } else if (ind >= 0) {
            for (int i = ind; i < length - 1; i++) {
                array[i] = array[i + 1];
            }
            length--;
            return true;
        } else {
            return false;
        }
    }

    int indexOf(T obj) {
        int ind = -1;
        for (int i = 0; i <= length; i++) {
            if ((T)array[i] == obj) {
                ind = i;
                break;
            }
        }
        return ind;
    }

    int lastIndexOf(T obj) {
        int ind = -1;
        for (int i = length-1; i >= 0; i--) {
            if ((T)array[i] == obj) {
                ind = i;
            }
        }
        return ind;
    }

    T pop() {
        T obj = (T)array[length];
        array[length--] = null;
        return obj;
    }

    public String toString(){
        String arr = "{";
        for(int i=0; i<length-1; i++){
            arr += (array[i]+",");
        }
        arr += array[length-1]+"}";
        return arr;
    }

    T get(int ind) throws Exception {
        if(ind <= length) return (T)array[ind];
        else throw new Exception("ArrayIndexOutOfBoundsException");

    }

    private void increaseSize(){
        size *= 2;
        array = Arrays.copyOf(array, size);
    }

    int getLength(){
        return length;
    }
}