package MyLinkedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();

    for (int i = 0; i<10; i++){
            list.add(i);
        System.out.println(list.getLast());
        }
    list.add(75674, 6);
        System.out.println("---------------------------");
        System.out.println(list.getOnIndex(6));
    list.remove(6);
        System.out.println("---------------------------");
        System.out.println(list.getOnIndex(6));
    }


}
class myLinkedList<E>{
    Node<E> first;
    Node<E> last;
    int size = 0;
    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E item, Node<E> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }
    private void linkLast(E item){
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, item, null);
        last = newNode;
        if(l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    public boolean add(E item){
        linkLast(item);
        return true;
    }
    public E getLast(){
        if(last == null)
            throw new NoSuchElementException();
        return last.item;
    }
    public void add(E item, int index){
        if(index<0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == size)
            linkLast(item);
        else
            linkBefore(item, node(index));

    }

    private void linkBefore(E item, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, item, succ);
        succ.prev = newNode;
        if(pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    Node<E> node(int index){
        if (index < (size >> 1))
        {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;

            return x;
        }
        else
        {
            Node<E> x = last;
            for (int i = size - 1; i  > index; i--)
                x = x.prev;

            return x;
        }
    }
    public E getOnIndex(int index){
        return node(index).item;
    }
    public E remove (int index){
        return unlink(node(index));
    }
    private E unlink (Node<E> x){
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;
        if(prev == null)
            first = next;
        else {
            prev.next = next;
            x.prev = null;
        }
        if(next==null)
            last = prev;
        else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }


}
