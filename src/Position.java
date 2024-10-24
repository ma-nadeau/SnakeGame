package src;


public class Position{
    private int x_coor;
    private int y_coor;

    public Position(int x_coor, int y_coor){
        if( x_coor < 0 || y_coor < 0){
            throw new IllegalArgumentException("move to negative");
        }
        this.x_coor = x_coor;
        this.y_coor = y_coor;

    }
    public Position(Position p){
        if( p.getY() < 0 || p.getX() < 0){
            throw new IllegalArgumentException("move to negative");
        }
        else{
        this.x_coor = p.x_coor;
        this.y_coor = p.y_coor;}
    }
    public void reset(int x, int y){
        if( x_coor < 0 || y_coor < 0){
            throw new IllegalArgumentException("move to negative");
        }
        this.x_coor = x;
        this.y_coor = y;
    }

    public void reset(Position p){
        if( p.getY() < 0 || p.getX() < 0){
            throw new IllegalArgumentException("move to negative");
        }
        this.x_coor = p.x_coor;
        this.y_coor = p.y_coor;
    }

    public int getDistance(Position p){
        int dist_x = Math.abs(this.x_coor - p.x_coor);
        int dist_y = Math.abs(this.y_coor - p.y_coor);

        return dist_x + dist_y;
    }

    public int getX(){
        return this.x_coor;
    }
    public int getY(){
        return this.y_coor;
    }

    public void moveWest(){
        if(this.x_coor == 0){
            throw new IllegalStateException("move to negative");
        }
        this.x_coor = this.x_coor - 1;
    }
    public void moveEast(){
        if(this.x_coor == Integer.MAX_VALUE){
            throw new IllegalStateException("Too high of a num");
        }
        this.x_coor = this.x_coor + 1;
    }

    public void moveSouth(){
        if(this.y_coor == Integer.MAX_VALUE){
            throw new IllegalStateException("Too high of a num");
        }
        this.y_coor = this.y_coor + 1;
    }
    public void moveNorth(){
        if(this.y_coor == 0){
            throw new IllegalStateException("move to negative");
        }
        this.y_coor = this.y_coor - 1;
    }

    public boolean equals(Object o){

        if(o instanceof Position) {
            Position new_o = (Position) o;
            return new_o.x_coor == this.x_coor && new_o.y_coor == this.y_coor;
        }
        return false;
    }

}