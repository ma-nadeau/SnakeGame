package src;

public class Region {
    private int min_x;
    private int min_y;
    private int max_x;
    private int max_y;

    public Region(int min_x,int min_y,int max_x, int max_y){

        if(min_x < 0 || max_x < 0 || min_y < 0 || max_y <0){
            throw new IllegalArgumentException("0 or negaive inputs");
        }
        else if(min_x > max_x|| min_y > max_y){throw new IllegalArgumentException("min>max");}

        this.min_x = min_x;
        this.min_y = min_y;
        this.max_x = max_x;
        this.max_y = max_y;
    }
    public boolean contains(Position p){
        boolean x_bounds = p.getX() >= min_x && p.getX()  <= max_x;
        boolean y_bounds = p.getY() >= min_y && p.getY()  <= max_y;
        return x_bounds && y_bounds;
    }
}
