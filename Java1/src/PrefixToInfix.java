import java.util.Scanner;



public class PrefixToInfix extends StringDoubleEndedQueueImpl{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
    
         System.out.println("Input prefix expresion:");

         String prefixExp;
         prefixExp=sc.nextLine();//eisagwgh prefix 
            
        try{
            String infixExp=convertPrefixExp(prefixExp);//metatroph se infix
            System.out.println("Infix Expresion:"+infixExp);

        }catch (Error e){
            System.out.println("Error ");
        }
        
    }
    private static String convertPrefixExp(String prefixExp){
        StringDoubleEndedQueueImpl ListP = new StringDoubleEndedQueueImpl();//dhmhourgia queue
        


        for (int i = prefixExp.length()-1;i>=0;i--){
            char currentChar = prefixExp.charAt(i);

            if(Character.isDigit(currentChar)){//if currentchar einai number
                ListP.addFirst(String.valueOf(currentChar));//eisagwgh timhs sthn ListP
            }else if(isOperator(currentChar)){//if currentchar einai telesths ektelese..
                if (ListP.size() < 2){
                    throw new IllegalArgumentException("False expresion");
                }

                String operant1=ListP.removeFirst();//apothikeuetai o arithmos pou afaireitai apo thn listp
                String operant2=ListP.removeFirst();
                String result = "("+operant1 + currentChar + operant2+")";
                ListP.addFirst(result);
            }else {//if currentchar den einai oute number oute telesths ektypwse wrong
                throw new IllegalArgumentException("Wrong character " + currentChar);//lathos character
            }
        }
        if (ListP.size() != 1){//an listP exei ena akrivos stoixeio eptypwse false
            throw new IllegalArgumentException("False expresion");
        }
        return ListP.removeFirst();//epistrofh telikou apotelesmatos
    }
    
    private static boolean isOperator(char c){//elegxos an o c einai telesths
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
//paradeigma gia input : +-*3456

