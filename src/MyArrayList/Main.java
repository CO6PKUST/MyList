package MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i<27; i++){
            myArrayList.add(i*1);
        }
        for (int i = 0; i< myArrayList.size(); i++){
            System.out.println(myArrayList.get(i));
        }
        System.out.println("размер массива текущий " + myArrayList.size());
        System.out.println("размер массива максимальный " + myArrayList.maxSize());
        System.out.println("-----");
        System.out.println(myArrayList.ofIndex(10));
        System.out.println("-----");
        myArrayList.removeOnIndex(5);
        System.out.println("удален элемент с индексом 5");
        for (int i = 0; i< myArrayList.size(); i++){
            System.out.println(myArrayList.get(i));
        }
        System.out.println("размер массива текущий " + myArrayList.size());
        }
    }

    class MyArrayList<T>{
    private int INIT_SIZE = 16;
    private  int CUT_RATE = 4;
    private Object array[] = new Object[INIT_SIZE];
    private int counter = 0;

    public void add(T item){
        if(counter == array.length-1)
            resize(array.length*2);
        array[counter++] = item;
    }

        public boolean remove(Object o) {

            int i;
            for (i = 0; i < counter; i++) {
                if (array[i] == o) {
                    shiftToLeft(i);
                    return true;
                }
            }
            return false;
        }

        public void removeOnIndex(int index){

        shiftToLeft(index);
        }
    public T get(int index){
        return (T)array[index];
    }
    public int ofIndex(T item){
        int index = 0;
        for(int i = 0; i<counter; i++)
            if (array[i] == item){
                index = i;
                break;}
        return index;
    }

    public int size(){
        return counter;
    }

    public int maxSize(){
        return array.length;
    }
    private void resize (int NewLenght_size){
        Object newArray[] = new Object[NewLenght_size];
        System.arraycopy(array, 0, newArray, 0, counter);
        array = newArray;
    }
        private void shiftToLeft(int index) {
           counter--;
            System.arraycopy(array, index + 1, array, index, counter - index);

            array[counter] = null;
            if(array.length>INIT_SIZE && counter < array.length/CUT_RATE){
                resize(array.length/2);

            }
        }
    }
