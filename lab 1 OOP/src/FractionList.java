import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionList {

    private ArrayList<Fraction> fractions = new ArrayList<>();
    private Fraction max = new Fraction(Integer.MIN_VALUE, 1);
    private Fraction min = new Fraction(Integer.MAX_VALUE, 1);

    public Fraction getMax() {
        return max;
    }

    public Fraction getMin() {
        return min;
    }

    public ArrayList<Fraction> getFractions() {
        return fractions;
    }


    public void fromFile(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] fractionsString = scanner.nextLine().split(" ");
                int n = Integer.parseInt(fractionsString[0]);
                int d = Integer.parseInt(fractionsString[1]);
                this.insert(new Fraction(n, d));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FractionList insert(Fraction fraction){
        if (fraction.compareTo(max) > 0){
            max = fraction;
        }
        if (fraction.compareTo(min) < 0){
            min = fraction;
        }
        fractions.add(fraction);
        return this;
    }

    public FractionList insert(Fraction fraction, int index){
        if (index < 0 || index > fractions.size()) {
            System.out.println("Invalid index");
        } else {
            if (fraction.compareTo(max) > 0) {
                max = fraction;
            }
            if (fraction.compareTo(min) < 0) {
                min = fraction;
            }
            fractions.add(index, fraction);
        }
        return this;
    }

    public FractionList insert(FractionList fractionList){
        for (Fraction f : fractionList.getFractions()){
            this.insert(f);
        }
        return this;
    }

    public Fraction getFraction(int index){
        return fractions.get(index);
    }


    public FractionList remove(int index){
        Fraction fraction = fractions.remove(index);
        if (fraction.compareTo(max) == 0) {
            Fraction real_max = new Fraction(Integer.MIN_VALUE, 1);
            for (Fraction f : fractions) {
                if (real_max.compareTo(f) < 0) {
                    real_max = f;
                }
                max = real_max;
            }
        }
        if (fraction.compareTo(min) == 0) {
            Fraction real_min = new Fraction(Integer.MAX_VALUE, 1);
            for (Fraction f : fractions) {
                if (real_min.compareTo(f) > 0) {
                    real_min = f;
                }
                min = real_min;
            }
        }
        return this;
    }

    public int length(){
        return fractions.size();
    }

    public int countMoreThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions){
            if (f.compareTo(fraction) > 0){
                ++count;
            }
        }

        return count;
    }

    public int countLessThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions){
            if (f.compareTo(fraction) < 0){
                ++count;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "FractionList{" +
                "fractions=" + fractions +
                '}';
    }
}
