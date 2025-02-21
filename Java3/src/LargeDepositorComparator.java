/*import java.util.Comparator;

public class LargeDepositorComparator implements Comparator<LargeDepositor> {

    @Override
    public int compare(LargeDepositor LDOne, LargeDepositor LDTwo) {
        double compared = LDOne.calculate() - LDTwo.calculate();
        if (LDOne.getTaxedIncome() < 8000.0) {
            if (LDTwo.getTaxedIncome() < LDOne.getTaxedIncome())
                return -1;
            else if (LDTwo.getTaxedIncome() > LDOne.getTaxedIncome())
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
    }
}*/