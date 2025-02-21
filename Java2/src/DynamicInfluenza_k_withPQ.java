import java.io.FileNotFoundException;

public class DynamicInfluenza_k_withPQ{
    public static void main(String[] args)throws FileNotFoundException{
        ReadFile reader = new ReadFile(); //dhmiourgia antikeimenou gia thn anagnwsh arxeiou
        String file="C:\\Users\\menel\\Desktop\\Εργασιες Δομες 23-24\\DOMESEX2\\file.txt ";//filepath
        int k = 6;
        PQ ob = new PQ();//dhmiourgia antikeimenou gia na xrhshmopoihsoume tis leitourgies ths class PQ
        try{
            City [] cities = reader.readFile(file);//anagnwsh dedomenwn tou file
            for (City city:cities){
                ob.insert(city);//insert twn polewn ston soro
            }
        }catch(FileNotFoundException e){//se mh evresh file emfanhse katallhlo mhnhma
            e.printStackTrace();
        }
        //dhmiourgia antikeimenwn (polewn) kai insert ston soro
        City citi = new City(22,"Karditsa",50000,4000);
        ob.insert(citi);
        City cit = new City(99,"Metsovo",3000,1000);
        ob.insert(cit);
        City ci = new City(31,"Kavala",12000,520);
        ob.insert(ci);
        //remove antikeimenwn apo ton soro me vash to id
        ob.remove(12);
        ob.remove(17);
        if (ob.size()>=k){//an to megethos tou sorou einai megalutero apo to k
            for (int i =0;i<k;i++){
                City city = ob.getMin();//topothethsh twn stoixeiwn tou sorou me vash thn mikroterh puknothta krousmatwn
                System.out.println("ID : "+city.getID() +"  Name : "+ city.getName() +"      Population :  "+city.getPopulation() + "  Influenza victims : "+ city.getInfluenzaCases());
            }
        }else {//mhnuma an to k einai megalutero apo to megethos tou sorou
            System.out.println("Wrong k!");
        }
        
        

        
    }
}