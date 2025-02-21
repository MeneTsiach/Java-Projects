public class LargeDepositor /*implements Comparable<LargeDepositor>*/{
    private int AFM;
    private String firstName;
    private String lastName;
    private double savings;
    private double taxedIncome;
    private double diff;

    public LargeDepositor() {
    }
    //constructor
    public LargeDepositor(int AFM, String firstName, String lastName, double savings, double taxedIncome) {
        this.AFM = AFM;
        this.firstName = firstName;
        this.lastName = lastName;
        this.savings = savings;
        this.taxedIncome = taxedIncome;
        this.diff = calculate();
    }
    //getters-setters
    public int getAFM() {
        return AFM;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getTaxedIncome() {
        return taxedIncome;
    }

    public void setTaxedIncome(double taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    public int key() {
        return this.AFM;
    }

    //print
    @Override
    public String toString() {
        final StringBuilder s = new StringBuilder("LargeDepositor {");
        s.append("AFM=").append(AFM);
        s.append(", firstName='").append(firstName).append('\'');
        s.append(", lastName='").append(lastName).append('\'');
        s.append(", savings=").append(savings);
        s.append(", taxedIncome=").append(taxedIncome);
        s.append(", diff=").append(diff);
        s.append('}');
        return s.toString();
    }

    //ypologismos saving-sunolikou apothikeumenou eisodhmatos(apoklish katathesewn sto ekswteriko kai tou dhlwthen eisodhmatos sthn ellada)
    public double calculate() {
        return this.savings - this.taxedIncome;
    }

    /*@Override
    public int compareTo(LargeDepositor LargeDepositor) {
        double compared = this.calculate() - LargeDepositor.calculate();
        if (this.taxedIncome < 8000.0) {
            if (LargeDepositor.taxedIncome < this.taxedIncome)
                return -1;
            else if (LargeDepositor.taxedIncome > this.taxedIncome)
                return 1;
            else
                return 0;
        }
        else {
            if (compared > 0)
                return 1;
            else if (compared < 0)
                return -1;
            else
                return 0;
        }
    }*/
}