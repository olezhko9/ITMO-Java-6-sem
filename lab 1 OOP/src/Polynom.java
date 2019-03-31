public class Polynom {

    private int degree;
    /**
     * polynom:         1/2*x^2 + 0*x + 3/7 = 0
     * polynomParts:    1/2, 0/1, 3/7
     * part:            0    1    2
     * */
    FractionList polynomParts;

    public Polynom() {}

    public Polynom(FractionList fractionList){
        this.polynomParts = fractionList;
        this.degree = fractionList.length() - 1;
    }

    public int getDegree() {
        return degree;
    }

    /** Change a fraction value at position */
    public void setPolynomPart(Fraction fraction, int part){
        this.polynomParts.remove(part);
        this.polynomParts.insert(fraction, part);
    }

    /** Return a fraction value at position */
    public Fraction getPolynomPart(int part){
        return polynomParts.getFraction(part);
    }

    /** Addition of two polynoms */
    public Polynom addPolynom(Polynom polynom){
        FractionList polynomSumList = new FractionList();
        int minDegree = degree;
        int insertPos = 0;

        if (polynom.getDegree() > degree){
            insertPos = 1;
            minDegree = degree;
            for (int i = 0; i < polynom.getDegree() - degree; i++){
                polynomSumList.insert(polynom.getPolynomPart(i));
            }
        } else if (polynom.getDegree() < degree){
            insertPos = 1;
            minDegree = polynom.getDegree();
            for (int i = 0; i < degree - polynom.getDegree(); i++){
                polynomSumList.insert(this.getPolynomPart(i), i);
            }
        }

        for (int j = 0; j <= minDegree; j++){
            polynomSumList.insert(this.getPolynomPart(this.degree - j).add(polynom.getPolynomPart(polynom.getDegree() - j)), insertPos);
        }
        return new Polynom(polynomSumList);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < polynomParts.length(); i++) {
            toReturn += polynomParts.getFraction(i) + "x^" + (polynomParts.length() - 1 - i);
            if (i != polynomParts.length() - 1) toReturn += " + ";
        }
        return "Polynom{" + toReturn + '}';
    }
}
