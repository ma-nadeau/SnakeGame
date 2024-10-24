package src;

public class TargetQueue extends MyQueue<Position> {

    private MyStack<String> stack;

    // to verify

    public TargetQueue(){
        super();
        stack = new MyStack<String>();

    }

    public void clear(){
        super.clear();
        stack.clear();
    }

    public static boolean isNumeric(String s){
        boolean result;
        try{
            Integer.parseInt(s);
            result = true;
        }
        catch(NumberFormatException e){
            result = false;
        }
        return result;
    }

    public void addTargets(String s){
        String num = "";
        if(s.length() < 4){
            throw new IllegalArgumentException("Your input is to short");
        }
        else if(s.charAt(0) == '.' && s.charAt(1) == '('){
        }
        else if(s.charAt(0)!= '('){
            throw new IllegalArgumentException("Your input is to short");
        }
        if(s.charAt(s.length()-1)!= ')' && Character.isDigit(s.charAt(s.length()-2))){
            throw new IllegalArgumentException("Doesn't end with )");
        }

        for(int i = 0 ; i < s.length() ; ++i){
            char character = s.charAt(i);

            if (character == '('){
                try{
                    if(!Character.isDigit((s.charAt(i + 1)))){
                        throw new IllegalArgumentException("wrong");
                    }
                    else if(i != 0 && s.charAt(i-1) != '.'){
                        throw new IllegalArgumentException("wrong 99");
                    }
                    else if(num.length() == 0 && stack.isEmpty() ){
                        stack.push("(");
                    }
                    else{
                        throw new IllegalArgumentException("Syntax Error - It appears that there is an additional '(' character");
                    }
                }
                catch (IndexOutOfBoundsException e){
                    throw new IllegalArgumentException(e);
                }
            }

            else if (Character.isDigit(character)) {

                num += character;
            }

            else if (character ==','){
                if(num.length() ==0 ){
                    throw new IllegalArgumentException("Syntax Error - It appears that there is no digit before the character ',' ");
                }
                else if (!isNumeric(num)){
                    throw new IllegalArgumentException("Syntax Error - It appears that num is not an integer");
                }
                else if (!Character.isDigit(s.charAt(i - 1))){
                    throw new IllegalArgumentException("Syntax Error - It appears that num is not an integer");
                }
                else if(isNumeric(num)) {
                    stack.push(num);
                    stack.push(",");
                    num = "";
                }
            }
            else if(character == ')'){
                try{
                    String tmp1 = stack.pop();
                    String tmp2 = stack.pop();
                    String tmp3 = stack.pop();

                    if(num.length() == 0){
                        throw new IllegalArgumentException("Syntax Error - It appears that there is no digit before the character ')' ");
                    }
                    else if(!isNumeric(num)){
                        throw new IllegalArgumentException("Syntax Error - It appears that num is not an integer");
                    }
                    else if( !tmp1.equals(",") || !isNumeric(tmp2) || !tmp3.equals("(")){
                        throw new IllegalArgumentException("the information in the stack is incorrect");
                    }
                    else if(i < s.length()-1 && s.charAt(i+1) != '.'){
                        throw new IllegalArgumentException("wrong1");
                    }
                    else if(isNumeric(tmp2)){
                        enqueue(new Position( Integer.parseInt(tmp2),Integer.parseInt(num)));
                        num = "";
                    }
                }
                catch(Exception e){
                    throw new IllegalArgumentException(e);
                }
            }
            else if(character == '.'){
                try{
                    if(s.charAt(0) == '.' && s.charAt(1) == '('){
                    }
                    else if((s.charAt(s.length()-1) == '.' && (s.charAt(s.length()-2) == ')'))){
                    }
                    else if(num.length() != 0 || !(s.charAt(i - 1) == ')' )|| !((s.charAt(i + 1)) == '(' )){
                            throw new IllegalArgumentException("wrong");
                        }
                    }
                catch(IndexOutOfBoundsException e){
                    throw new IllegalArgumentException("wrong");
                }
            }
            else{
                throw new IllegalArgumentException("Undefined character");
            }
        }
    }
}