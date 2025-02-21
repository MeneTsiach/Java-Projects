public interface TaxEvasionInterface {
    
    void insert(LargeDepositor item);
    void load(String filename);
    void updateSavings(int AFM, double savings);
    LargeDepositor searchByAFM(int AFM);
    StringDoubleEndedQueue<LargeDepositor> searchByLastName(String last_name);
    void remove(int AFM);
    double getMeanSavings();
    //void printTopLargeDepositors(int k);
    void printByAFM();
}