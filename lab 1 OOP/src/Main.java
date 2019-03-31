
public class Main {
    public static void main(String[] args) {

        Fraction frac = new Fraction(2, 3);
        Fraction frac1 = new Fraction(1, 3);
        Fraction frac2 = new Fraction(4, 3);
        Fraction frac3 = new Fraction(3, 3);

        FractionList fractionList = new FractionList();
        fractionList.insert(frac).insert(frac1).insert(frac2).insert(frac3, 0).remove(2);
        System.out.println(fractionList);
        System.out.println("Max is " + fractionList.getMax());
        System.out.println("Min is " + fractionList.getMin());
        System.out.println(fractionList.countMoreThan(frac1));
        System.out.println(fractionList.countLessThan(frac3));

        FractionList fractionListFromFile = new FractionList();
        fractionListFromFile.fromFile("C:\\Users\\Oleg Naumov\\YandexDisk\\Учеба\\6 семестр\\Технологии программирования\\lab 1 OOP\\src\\list.txt");
        System.out.println(fractionListFromFile);


        fractionList.insert(new Fraction(2));

        FractionList fractionArray = new FractionList();
        fractionArray.insert(frac1).insert(frac2).insert(new Fraction(3));

        Polynom p1 = new Polynom(fractionList);
        Polynom p2 = new Polynom(fractionArray);
        System.out.println(p1);
        System.out.println(p2);

        Polynom p = p1.addPolynom(p2);
        System.out.println(p);
    }
}
