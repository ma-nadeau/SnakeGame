package src;

public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> stack;
    private String K;
    private String D;
    private int num;


    public ActionQueue(){
        super();
        stack = new MyStack<String>();
        K = "" ;
        D = "";
        num = 0;

    }

    public void clear(){
        super.clear();
        stack.clear();
        K = "";
        D = "";
        num=0;

    }

    public void loadFromEncodedString(String s){
        if(s.length() == 0){
            throw new IllegalArgumentException("Length 0");
        }
        for(int i = 0 ; i < s.length() ; i++){
            char character = s.charAt(i);


            if(Character.isDigit(character)){
                try{
                    if(s.charAt(i+1) == '[' || Character.isDigit(s.charAt(i+1))){
                        K += character;
                    }
                    else{
                        throw new IllegalArgumentException("Illegal character placement");
                    }

                }
                catch(IndexOutOfBoundsException e){
                    throw new IllegalArgumentException("Illegal character placement");
                }


            }
            else if(character == 'N' || character == 'S' || character == 'E' || character == 'W'){
                D += character;
            }
            // right bracket point right ??
            else if(character == '['){
                num+=1;
                if(!Character.isDigit(s.charAt(i-1))){
                    throw new IllegalArgumentException("No integer before the '['");
                }
                stack.push(K);
                stack.push(D);
                K = "";
                D = "";

            }
            // right bracket point left ??
            else if(character == ']') {
                num -=1;
                if(D.isEmpty()){
                    throw new IllegalArgumentException("the stack is empty");
                }
                try{
                String direction = stack.pop();
                String multiple = stack.pop();
                if(Integer.parseInt(multiple) == 0){
                    throw new IllegalArgumentException("multiply my 0");
                }
                for (int j = 0; j < Integer.parseInt(multiple); j++ ){
                    direction += D;
                }
                D = direction;
                K = "";

                }
            catch(Exception e ){
                throw new IllegalArgumentException("multiply my 0");
            }
            }
            else{
                throw new IllegalArgumentException("Your inputs contains unknown characters");
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid syntax - None Empty Stack");}
        if(num != 0){
            throw new IllegalArgumentException("Invalid syntax - None Empty Stack");}

        for (int b = 0; b < D.length(); b++) {
            char character1 = D.charAt(b);
                switch (character1) {
                    case 'N':
                        enqueue(Direction.NORTH);
                        break;
                    case 'S':
                        enqueue(Direction.SOUTH);
                        break;
                    case 'W':
                        enqueue(Direction.WEST);
                        break;
                    case 'E':
                        enqueue(Direction.EAST);
                        break;
                }
        }
    }
}


