public class TechnicalItem extends GenericItem {

    short warrantyTime;

    public TechnicalItem(int id, String _name, float _price, short warranty) {
        super(id, _name, _price);
        warrantyTime = warranty;
    }

    void printAll(){
        super.printAll();
        System.out.printf("warranty: %d \n", warrantyTime);
    }
}
