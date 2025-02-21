public class QuickSort{

    public QuickSort(){}

    public void s(City[] arr,int first,int last){

        if (first <= last ){ //elegxos an einai uparxoun poleis sthn oura
            return;
        }
        int num= method(arr,first,last);//klhsh method me orismata
        //kalei anadromika ton euato ths
        s(arr,first,num-1);
        s(arr,num+1,last);
    }
    private int method(City[] array,int l,int r){
        City point = array[r];//thetw point to teleutaio stoixeio

        int IndexPoint = l;//

        for(int i=l ; i<r; i++){

            if(array[i].compareTo(point)>0){
                //an to stoixeio i einai megalytero apo to point to antallasei
                swap(array,i,IndexPoint);
                IndexPoint= IndexPoint+1;

            } else if (array[i].compareTo(point)==0){
                //an einai to i idio me to point sukgrinei ta onomata..
                String first = array[i].getName();
                String sec = point.getName();

                if (first.compareTo(sec)<0){
                    //analoga me thn protereothta twn onomatwn antallasei ta stoixeia 
                    swap(array,i,IndexPoint);
                    IndexPoint=IndexPoint+1;

                }else if(first.equals(sec)){//an einai idia kai ta onomata ,sygkrinei ta ids

                    if (array[i].getID() < point.getID()){
                        //analoga me ta ids kanei tis katallhles antallages thesewn sta stoixeia
                        swap(array,i,IndexPoint);
                        IndexPoint=IndexPoint+1;
                    }
                }
            
            }
        }
        //vazei ton pivot sthn swsth thesh
        swap(array,IndexPoint,r);
    
        return IndexPoint;
    }
    //methodos swap gia thn antallagh stoixeiwn
    private void swap(City arr[],int i,int j){
        City temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}