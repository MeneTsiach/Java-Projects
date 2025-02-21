import java.io.FileNotFoundException;

public class Influenza_k  {

    public static void main(String[] args) throws FileNotFoundException{

        String file="C:\\Users\\menel\\Desktop\\Εργασιες Δομες 23-24\\DOMESEX2\\file.txt ";
        int k = 4; 
        ReadFile reader = new ReadFile();//dhmiourgia antikeimenou gia thn anagnwsh arxeiou
        City [] cities = reader.readFile(file);//anagnwsh dedomenwn tou file

        if (k > cities.length){//elegxos an k>megalutero apo sunolo cities
            System.out.println("incorrect k");//emfanish katallhlou mhnymatos
            System.exit(0);//termatismo kwdika
        }else {
            QuickSort quickSort = new QuickSort(); //taksinomhsh tou pinaka cities
            quickSort.s(cities,0,cities.length-1);

            System.out.println("The top " + k + " cities are:");
            for (int i=0; i<k ; i++){
                System.out.println(cities[i].getName());//print ta onomata twn cities
            }
        }
    
       
    }
}