import java.util.Scanner;

public class DNAPalindrome{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Input DNA:");
        String dnaSequence = scanner.nextLine();//eisagwgh dna

        if (ValidDNASeq(dnaSequence)){
            StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();//dhmiourgia ouras

            for (char nucl:dnaSequence.toCharArray()){//gia kathe stoixeio dna..
                queue.addLast(String.valueOf(nucl));//eisagwgh stoixeiwn dna sthn oura
            } 
            if (WatsonCrickPalin(queue)){
                System.out.println("The DNA is Watson Crick complemented palindrome");
            }else{
                System.out.println("The DNA ins't Watson Crick complemented palindrome");
            }
        }else{
            System.out.println("Wrong DNA input ");
        }
    }

        private static boolean ValidDNASeq(String seq){
            return seq.matches("[ATCG]+");//if dna tairiazei me ta ATCG
        }

        private static boolean WatsonCrickPalin(StringDoubleEndedQueueImpl queue){
            while (queue.size()>1){//oso megethos queue>1
                String firstN=queue.removeFirst();//apothikeush prwtou stoixeiou sthn firstN
                String lastN=queue.removeLast();//apothikeush teleuataiou stoixeiou sthn lastN

                if (!(Complementary(firstN,lastN))){//if firstN den einai upokatastato me lastN
                    return false;
                }
            }
            return true;
        }

        private static boolean Complementary(String fir,String las){//elegxos an h mia timh einai sumplhrwma ths allhs
            return  (fir.equals("A")) && (las.equals("T")) ||
                    (fir.equals("T")) && (las.equals("A")) ||
                    (fir.equals("C")) && (las.equals("G")) ||
                    (fir.equals("G")) && (las.equals("C")) ;

        }   
    
}
//paradeigma gia input : AACGTT