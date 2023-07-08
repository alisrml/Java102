package Generics;

public class MyList<T> {
    private int capacity;
    private T[] array;

    public MyList(){
        this.setCapacity(10);
        setArray(new Object[this.getCapacity()]);
    }

    public MyList(int capacity){
        this.setCapacity(capacity);
        setArray(new Object[this.getCapacity()]);
    }

    public int size(){
        int counter = 0;
        for(T i:this.getArray()){
            if(i!=null){
                counter++;
            }
        }
        return counter;
    }

    public void add(T data){
        if(size()>=this.getCapacity()){
            doubleCapacity();
        }else {
            this.getArray()[this.size()] = data;
        }
    }

    public void doubleCapacity(){
        T[] tempArray = getArray();

        this.setCapacity(this.getCapacity()*2);
        setArray(new Object[this.getCapacity()]);

        int i = 0;
        for(T oldElement:tempArray){
            this.getArray()[i] = oldElement;
            i++;
        }
    }

    public <T> T get(int index){
        if(index>=size()-1){
            return null;
        }else {
            return (T) this.getArray()[index];
        }
    }

    public boolean remove(int index){
        if(index>=size()-1) {
            return false;
        }else {
            T[] tempArray = getArray();
            setArray(new Object[this.getCapacity()]);
            for(int i=0;i<index;i++){
                getArray()[i] = tempArray[i];
            }
            for(int i =index+1;i<tempArray.length;i++){
                getArray()[i-1] = tempArray[i];
            }
            return true;
        }
    }

    public boolean set(int index,T data){
        if(index>=size()-1) {
            return false;
        }else{
            T[] tempArray = getArray();
            setArray(new Object[this.getCapacity()]);
            for(int i=0;i<index;i++){
                getArray()[i] = tempArray[i];
            }
            getArray()[index] = data;
            for(int i = index+1;i<getArray().length;i++){
                getArray()[i] = tempArray[i];
            }
            return true;
        }
    }

    public String toString(){
        System.out.print("[");
        for (T x:getArray()){
            if (x!= null){
                System.out.print(x+ ",");
            }
        }
        System.out.println("]");
        return "";
    }

    public int indexOf(T data){
        T[] tempArray= getArray();

        for(int i = 0;i<size();i++){
            if(tempArray[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        T[] tempArray= getArray();
        int index = -1;
        for(int i=0;i<size();i++){
            if(tempArray[i] == data){
                index = i;
            }
        }
        return index;
    }

    public boolean isEmpty(){
        boolean isEmpty = true;
        for(T element:getArray()){
            if(element!=null){
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public T[] toArray(){
        T[] newArray = (T[])new Object[size()];
        for(int i =0;i<size();i++){
            newArray[i] = getArray()[i];
        }
        return newArray;
    }

    public void clear(){
        for(int i=0;i<size();i++){
            getArray()[i] =null;
        }
    }
    /*
    public T[] subList(int start,int finish){
        T[] newList = (T[]) new Object[finish-start+1];
        int index=0;
        for(int i=start;i<=finish;i++){
            newList[index] = getArray()[i];
            index++;
        }
        return newList;
    }*/

    public MyList<T> subList(int start,int finish){

        if(start>=0 && finish>=0){

            if(start<=this.getCapacity() && finish<=this.getCapacity()){
                int size = finish - start + 1;

                MyList<T> myList = new MyList<>(size);
                for(int i = start; i <= finish; i++){
                    myList.add(get(i));
                }
                return myList;
            }

        }return null;

    }

    public boolean contains(T data){
        boolean contain=false;
        for(T element:getArray()){
            if(element==data){
                contain=true;
                break;
            }
        }
        return contain;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = (T[]) array;
    }
}
