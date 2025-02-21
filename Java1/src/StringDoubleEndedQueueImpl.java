import java.io.PrintStream;
import java.util.NoSuchElementException;



public class  StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {
	private Node first;//deiktis ouras
    private Node last;
    private int size;

    private static class Node{//class kombou 
        String data;//periexomeno kombou
        Node next;//deikths epomenou stoixeiou tou komvou
        Node prev;//deikths prohgoumenou stoixeiou tou komvou
    }

    
	public boolean isEmpty(){//elegxos an h oura einai adeia
        return size==0;//epistrefei size(megethos)=0
    }
	
	public void addFirst(String data){//dhmiourgia kai eisagwgh komvou apo thn arxh ths ouras

        Node newNode = new Node();//dhmiourgia komvou
        newNode.data=data;
        newNode.next=first;

        if (isEmpty()){//elegxos an einai adeia h oura 
            last = newNode;
        }else{
            
            first.prev = newNode;
            
        }
        first=newNode;
        size ++;
    }
    
	public String removeFirst() throws NoSuchElementException{//afairesh prwtou komvou apo thn arxh ths ouras

        if (isEmpty()){//an adeia oura emfanise katallhlo mnma
            throw new NoSuchElementException();
        }

        String data = first.data;//data isoute me to data ths theshs first
        first=first.next;//prwtos komvos deixnei mia thesh meta apo ton komvo pou edeixne
        size --;//meiwsh megethous ouras kata ena
        if (isEmpty()){//an adeia h oura 
            last = null;
        }else{
            first.prev=null;
        }
        
        return data;
    }

	public void addLast(String data){//dhmiourgia kai eisagwgh komvou sto telos ths ouras

        Node newNode = new Node ();//dhmiourgia komvou
        newNode.data=data;
        newNode.prev=last;

        if (isEmpty()){//an adeia oura
            first =  newNode;//eisagwgh komvou sthn prwth thesh
        }else {
            last.next = newNode;//alliws eisagwgh komvou mia thesh meta ton teleutaio komvo ths ouras
            
        }
        last=newNode;
        size++;//aukshsh megethous ouras kata ena
    }

	public String removeLast() throws NoSuchElementException{//afairesh teleutaiou komvou apo to telos ths ouras

        if (isEmpty()){//an oura adeia emfanise mnma
            throw new NoSuchElementException();
        }

        String data = last.data;
        last=last.prev;
        size --;
        if (last != null) {
            last.next = null; // An uparxei prev komvos kane ton next null
        } else {
            first = null; // an den uparxei h oura einai kenh
        }
        
        return data;
    }

    public String getFirst() {//emfanish prwtou komvou

        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return first.data;

        
    }

	public String getLast() throws NoSuchElementException{//emfanish teleutaiou komvou

        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return last.data;
	
	
	    
    }
	 
	public void printQueue(PrintStream stream){//print ta dedomena olwn twn komvwn ths ouras
        Node temp = first;
        while (temp!=null){//oso h oura den einai adeia synexise
            stream.print(temp.data+ " ");//emfanise to periexomeno tou komvou
            temp = temp.next;//temp ston next komvo
        }
        stream.println();
    }

	
	public int size(){//megethos ouras
        return size;
    }
}


