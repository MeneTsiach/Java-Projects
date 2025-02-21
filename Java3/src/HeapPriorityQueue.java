import java.util.Comparator;


public class HeapPriorityQueue<T> implements PriorityQueueInterface<T> {
    

    private T[] heap; // orismos pinaka
    private int size; // to megethos ths ouras
    private Comparator<T> comparator; // o comparator gia thn sugkrish antikeimenwn

    private static final int DEFAULT_CAPACITY = 4; // arxikh xwrithkotita
    private static final int AUTOGROW_SIZE = 4; // megethos automaths aukshshs

    
   
    public HeapPriorityQueue(Comparator<T> comparator) {
        // dhmiourgia tou pinaka heap 
        this.heap = (T[]) new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }

    public int getSize(){
        return this.size;//epistrofh size
    }
   
    @Override
    public void add(T item) {
        // elegxos an yparxei xwros
        if (size == heap.length - 1)
            grow();

        // topothetish stoixeiou sthn epomenh thesh
        heap[++size] = item;

        // kane swim gia to neo antikeimeno
        swim(size);
    }

    
    @Override
    public T peek() {
        // elegxos an einai adeio
        if (size == 0)
            return null;

        // epistrofh ths rizas xwris afairesh
        return heap[1];
    }

    
    @Override
    public T getMax() {
        // elegxos an einai adeio
        if (size == 0)
            return null;

        // diathrhsh ths rizas
        T root = heap[1];

        // antikatastash rizas me to deksi fullo
        heap[1] = heap[size];
        size--;

        
        // sink gia to neo stoixeio
        sink(1);

        // epistrofh tou stoixeiou pou afairethhke
        return root;
    }

    
    private void swim(int i) {
        // an h i riza einai ish me ena tote return 
        if (i == 1)
            return;

        // euresh parent
        int parent = i / 2;

        // sugkrish parent me child i
        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }

        
    }

    
    private void sink(int i) {
        // euresh aristerou,deksiou child
        int left = 2 * i;
        int right = left + 1;

        // an 2*i > size, tote o komvos i einai fullo return
        if (left > size)
            return;

        // oso den exei vrethei fyllo
        while (left <= size) {
            // prosdiorise to megalytero paidi tou komvou i
            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }

            // ean isxuei h sunthkh stamata,alliws antalakse kai continue
            // sunthiki: to child mikrotero tou parent
            if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    
    private void swap(int i, int j) {//antallagh
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

   
    private void grow() {//aukshsh megethous tou pinaka
        T[] newHeap = (T[]) new Object[heap.length + AUTOGROW_SIZE];

        // antigrafh pinaka
        for (int i = 0; i <= size; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }
}
