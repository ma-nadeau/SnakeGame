package src;

import java.util.Iterator;

public class Caterpillar extends MyDoublyLinkedList<Position>{

    public Caterpillar(){
        // if I call super and add (7,7) should the size automatically be 1???

        super();
        add(new Position(7,7));
    }
    public Position getHead(){
        return peekFirst();
    }

    public void eat(Position p){
        if(selfCollision(p)){
            throw new IllegalArgumentException("self collision");
        }
        if(getHead().getDistance(p) == 1){
            addFirst(p);}
        else{
            throw new IllegalArgumentException("Food is not orthogonally adjacent");
        }

    }

    public void move(Position p){
        if(selfCollision(p)){
            throw new IllegalArgumentException("self collision");
        }
        this.eat(p);
        this.removeLast();
    }

    //implement using equal method?

    public boolean selfCollision(Position p){

            if(p == null){
                return false;
            }
            Iterator<Position> i1 = this.iterator();

                while(i1.hasNext()){
                    if((i1.next().equals(p))){
                        return true;
                    }
                }
            return false;
    }
}
