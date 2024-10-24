package src;


import java.util.Iterator;

public class MyQueue<E>{
    private MyDoublyLinkedList<E> queue;

    public MyQueue(){
        this.queue = new MyDoublyLinkedList<E>();
    }

    public boolean enqueue(E element){
        if(element == null)
            return false;
        return queue.addLast(element);
    }
    public int getSize(){
        return queue.getSize();
    }

    public E dequeue(){
        return queue.removeFirst();
    }
    public boolean isEmpty() {
        return queue.size==0;
    }

    public int isSize(){
        return queue.size;
    }
    public E first(){
        return queue.peekFirst();
    }
    public E last(){
        return queue.peekLast();
    }

    public void clear() {
        queue.clear();
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this) {
            return true;
        }

        MyQueue x = (MyQueue) obj;

        if(x.queue.getSize() == 0 && queue.getSize() == 0 ){
            return true;
        }
        if(x.queue.getSize() != queue.getSize()){
            return false;
        }

            if ((obj instanceof MyQueue)) {


            //MyQueue x = (MyQueue) obj;

            Iterator<E> i1 = queue.iterator();;
            Iterator<E> i2 = x.queue.iterator();

            while(i1.hasNext() && i2.hasNext()){
                if(!(i1.next().equals(i2.next()))){
                    return false;
            }
        }
        }
        return true;
    }
}