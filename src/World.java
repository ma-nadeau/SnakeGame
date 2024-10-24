package src;



public class World {
    private Caterpillar caterpillar;
    private Position food;
    private Region region;
    private ActionQueue actionQueue;
    private TargetQueue targetQueue;
    private GameState gameState;
    private Position nextPosition;


    public World(TargetQueue targetQueue, ActionQueue actionQueue){
        this.targetQueue = targetQueue;

        this.actionQueue = actionQueue;

        this.region = new Region(0,0,15,15);

        this.caterpillar = new Caterpillar();

        this.food = targetQueue.dequeue();

        this.gameState = GameState.MOVE;

        this.nextPosition = new Position(7,7);

    }

    public void step(){

        if(!this.actionQueue.isEmpty()){
            Direction direction = this.actionQueue.dequeue();

            switch (direction) {
                case SOUTH:
                    this.nextPosition.moveSouth();
                    break;
                case NORTH:
                    this.nextPosition.moveNorth();
                    break;
                case EAST:
                    this.nextPosition.moveEast();
                    break;
                case WEST:
                    this.nextPosition.moveWest();
                    break;
            }
        }
        else{
            this.gameState = GameState.NO_MORE_ACTION;
        }

        if(gameState != GameState.EAT && gameState != GameState.MOVE){
            return;
        }

        if(!region.contains(nextPosition)){
            gameState = GameState.WALL_COLLISION;
        }
        else if (caterpillar.selfCollision(nextPosition)) {
            gameState = GameState.SELF_COLLISION; }

        else if (nextPosition.equals(food)) {
            Position p = new Position(nextPosition.getX(),nextPosition.getY());
            caterpillar.eat(p);


            if(targetQueue.isEmpty()){
                gameState = GameState.DONE;
        }
            else {
                this.food = targetQueue.dequeue();
                gameState = GameState.EAT;

            }
        }
        else {
            gameState = GameState.MOVE;
            Position p = new Position(nextPosition.getX(),nextPosition.getY());
            caterpillar.move(p);

            }
    }

    public GameState getState(){
        return gameState;
    }

    public Caterpillar getCaterpillar() {
        return caterpillar;
    }

    public Position getFood(){
        return food;
    }

    public boolean isRunning(){
        if(gameState != GameState.EAT && gameState != GameState.MOVE){
            return false;
        }
        return true;
    }
}
