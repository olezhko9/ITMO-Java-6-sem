import java.util.Date;

public class FoodItem extends GenericItem {

    Date dateOfIncome;
    short expires;

    public FoodItem(int id, String _name, float _price, Date incomeDate, short expiresIn) {
        super(id, _name, _price);
        dateOfIncome = incomeDate;
        expires = expiresIn;
    }

    void printAll(){
        super.printAll();
        System.out.printf("income: %s , expires: %d\n", dateOfIncome, expires);
    }
}
