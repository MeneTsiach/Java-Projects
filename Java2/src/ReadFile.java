import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class ReadFile{
    public ReadFile(){} 
    
    public City[] readFile(String file) throws FileNotFoundException {
        ArrayList<City> influenCity = new ArrayList<City>();//dhmiourgia arraylist
       
            File object =new File(file);//dhmiourgia object gia anagnwsh apo to arxeio
            
            String [] arr;//dhmiourgia pinaka
            Scanner reader = new Scanner(object); //dhmiourgia scanner
            //dhlwsh metavlhtwn
            int id;
            int pop;
            int InfluenzaCases;
            String name;

            while (reader.hasNextLine()){//anagnwsh grammwn apo to arxeio

                String data = reader.nextLine();
                arr = data.split(" ");//afhnei keno metaksu dedomenwn
                //prosthikh dedomenwn se katallhles theseis ston pinaka
                id = Integer.parseInt(arr[0]);
                name= arr[1];
                pop = Integer.parseInt(arr[2]);
                InfluenzaCases = Integer.parseInt(arr[3]);
                //dhmiourgia neou antikeimenou city
                City c = new City(id,name,pop,InfluenzaCases);

                influenCity.add(c);//prosthiki antikeimeou sto arraylist
            }

            reader.close();//kleisimo reader
        
        //dhmiourgia pinaka city 
        City[] C = new City[influenCity.size()];
        C = influenCity.toArray(C);
        return C;
    }
   
}