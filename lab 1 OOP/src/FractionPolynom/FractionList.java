package FractionPolynom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionList {

    private List<Fraction> fractions = new ArrayList<>();
    private Fraction max = null;
    private Fraction min = null;

    public Fraction getMax() {
        return this.max;
    }

    public Fraction getMin() {
        return this.min;
    }

    public List<Fraction> getFractions() {
        return fractions;
    }

    public void insertFromFile(File file) {
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

    public FractionList insert(Fraction fraction) {
        if (this.max == null) {
            this.max = fraction;
            this.min = fraction;
        } else {
            if (fraction.compareTo(this.max) > 0) {
                this.max = fraction;
            }
            if (fraction.compareTo(this.min) < 0) {
                this.min = fraction;
            }
        }
        fractions.add(fraction);
        return this;
    }

    public FractionList insert(Fraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            System.out.println("Invalid index");
        } else {
            if (this.max == null) {
                this.max = fraction;
                this.min = fraction;
            } else {
                if (fraction.compareTo(this.max) > 0) {
                    this.max = fraction;
                }
                if (fraction.compareTo(this.min) < 0) {
                    this.min = fraction;
                }
            }
            fractions.add(index, fraction);
        }
        return this;
    }

    public FractionList insert(FractionList fractionList) {
        for (Fraction f : fractionList.getFractions()) {
            this.insert(f);
        }
        return this;
    }

    public Fraction getFraction(int index) {
        return fractions.get(index);
    }

    public FractionList remove(int index) {
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

    public int length() {
        return fractions.size();
    }


    public int countLargerThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) > 0) {
                ++count;
            }
        }

        return count;
    }

    public int countLessThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) < 0) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("FractionList{%s}", fractions);
    }
}
