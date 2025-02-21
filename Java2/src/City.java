import java.text.DecimalFormat;;

public class City implements CityInterface,  Comparable<City>{ 
    //variables
    private int id;
    private String name;
    private int population;
    private int InfluenzaCases; 
    

    //constructor
    
    public City(int id,String name ,int population, int InfluenzaCases){
        this.id=id;
        this.name=name;
        this.population=population;
        this.InfluenzaCases=InfluenzaCases;
    }
    //getters
    @Override
    public int getID(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getPopulation(){
        return population;
    }

    @Override
    public int getInfluenzaCases(){
        return InfluenzaCases;
    }
    //setters
    @Override
    public void setID(int id){
        this.id=id;
    }

    @Override
    public void setName(String name){
        this.name=name;
    }

    @Override
    public void setPopulation(int population){
        this.population=population;
    }
    
    @Override
    public void setInfluenzaCases(int InfluenzaCases){
        this.InfluenzaCases=InfluenzaCases;
    }
    
   

    //sygkrinei thn puknothta krousmatwn ana 50.000 katoikous metaksy duo polewn
    public int compareTo(City obj){
        double compared = this.calculateDensity() - obj.calculateDensity();
        if(compared>0){
            return 1;
        }else if (compared == 0){
            return 0;
        }else{
            return -1;
        }
    }

    //ypologizei thn pyknothta krousmatvnwn gia mia polh
    public double calculateDensity(){
        double density = (this.getInfluenzaCases() * 50_000)/this.getPopulation();
        DecimalFormat DF = new DecimalFormat();
        DF.setMaximumFractionDigits(2);
        return Double.parseDouble(DF.format(density));
    }
}

