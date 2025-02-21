public class PQ {
    //private metavlhtes
    private City[] heap;
    private int size;


    public PQ(int capacity){//constructor pou orizei thn xwrhtikothta
        heap = new City[capacity +1];//dhmiourgia sorou
        size = 0;//arxikopoihsh megethous
    }

    public PQ(){
        this(10);
    }

    

    public boolean isEmpty(){//elegxos an o soros einai adeios
        return size==0;
    }

    public int size(){//epistrofh megethous sorou
        return size;
    }

    public void insert(City x){//eisagwgh polhs ston soro
        if (size==heap.length-1){

            resize(2*heap.length);//diplasiazei thn xwrhtikothta tou sorou 
        }

        heap[++size]=x;//prosthkh ths polhs sto telos tou sorou
        swim(size);
    }

    public City min(){//epistrofh ths elaxisths polhs
        return heap[1];
    }

    public City getMin(){//epistrofh kai afairesth ths elaxisths polhs
        City min =heap[1];//apothikeush ths elaxisths polhs 
        swap(1,size--);//antalagh rizas me teleutaio komvo
        heap[size +1]=null;//afairesh teleutaioy komvou
        sink(1);
        return min;
    }
    //remove mias polhs, me anazhthsh tou id
    public City remove(int id){
        int index = findIndex(id);
        if (index == -1){//ean den vrethei to id ,return null
            return null;
        }

        City removedCity = heap[index];//apothikeush ths polhs pou afairethike
        swap(index,size--);//antalagh tou komvou me ton teleutaio komvo
        heap[size+1]=null;//afairesh teleutaiou komvou
        swim(index);
        sink(index);

        return removedCity;//epistrogh ths polhs pou afaireitai
    }

    private int findIndex(int id){//elegxos gia thn euresh tou deikth enos komvou me vash to id
        for (int i=1; i<= size; i++){
            if (heap[i].getID()==id){
                return i;
            }
        }
        return -1;//se periptwsh pou den vrethei epistrefei false
    }

    //antalagh duo komvwn ston pinaka
    private void swap(int i ,int j){
        City temp = heap[i];
        heap[i] = heap[j];
        heap[j]=temp;
    }

    //elegxos pros ta panw gia thn swsth leitourgia toy sorou
    private void swim(int k){
        while (k>1 && heap[k].getInfluenzaCases() < heap[k/2].getInfluenzaCases()){
            swap(k,k/2);
            k= (k/2) ;
        }
    }

    //elegxos pros ta katw gia thn swsth leitourgia tou sorou
    private void sink(int k){
        while (2*k<=size){
            int j=2*k;
            if (j<size && heap[j].getInfluenzaCases() > heap[j+1].getInfluenzaCases()){
                j++;
            }
            if (heap[k].getInfluenzaCases()<=heap[j].getInfluenzaCases()){
                break;
            }
            swap(k,j);
            k=j;
        }
    }

    //allagh sto megethos sorou
    private void resize(int capacity){
        City[] newHeap=new City[capacity];
        System.arraycopy(heap,1,newHeap,1,size);//antigrafei ta stoixeia tou heap se enan neo pinaka newHeap
        heap=newHeap;
    }


}                              