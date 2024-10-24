package src;


public class MyStack<E>{
    private MyDoublyLinkedList<E> stack;

    public MyStack(){
        this.stack = new MyDoublyLinkedList<E>();
    }
    public boolean push(E e){
        if(e == null)
            return false;
        return stack.addLast(e);
    }

    public E pop(){
        return stack.removeLast();
    }

    public E peek(){
        return stack.peekLast();
    }
    public boolean isEmpty(){
        return stack.size == 0;
    }

    public void clear(){
        stack.clear();
    }

    public int getSize(){
        return stack.size;
    }
}