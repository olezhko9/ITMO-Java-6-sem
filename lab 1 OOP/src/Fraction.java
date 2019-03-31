public class Fraction implements Comparable<Fraction>{
    int numerator;
    int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("denominator shouldn't be 0");
        } else {
            int g = this.gcd(numerator, denominator);
            this.numerator = numerator / g;
            this.denominator = denominator / g;
        }
    }

    public Fraction(int holeNumber) {
        this.numerator = holeNumber;
        this.denominator = 1;
    }

    public Fraction add(Fraction f){
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator,
                this.denominator * f.denominator);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        long a = this.numerator * o.denominator;
        long b = o.numerator * this.denominator;
        if(a > b) {
            return 1;
        }
        else if(a < b) {
            return -1;
        }
        return 0;
    }
}
