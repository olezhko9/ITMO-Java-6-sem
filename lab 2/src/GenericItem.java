public class GenericItem {

    public enum Category {FOOD, PRINT, DRESS, GENERAL};

    private int ID;
    private String name;
    private float price;
    public GenericItem analog;
    Category category = Category.GENERAL;

    public GenericItem(int id, String _name, float _price) {
        ID = id;
        name = _name;
        price = _price;
    }

    public GenericItem(int id, String _name, float _price, Category _category){
        ID = id;
        name = _name;
        price = _price;
        category = _category;
    }

    void printAll(){
        System.out.printf("ID: %d , name: %-10s , price:%5.2f , category: %s , \n", ID, name, price, category);
        if (analog != null) {
            System.out.println("analog is: ");
            analog.printAll();
        }
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        } else {
            GenericItem genericObj = (GenericItem) obj;
            return ID == genericObj.ID;
        }
    }
}


