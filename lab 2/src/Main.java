import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem(0, "item_1", 2.2f);
        GenericItem item2 = new GenericItem(1, "item_2", 4.4f, GenericItem.Category.FOOD);
        item2.analog = item1;
        GenericItem item3 = new GenericItem(2, "item_3", 8.8f, GenericItem.Category.DRESS);

//        item1.printAll();
//        item2.printAll();
//        item3.printAll();

        FoodItem foodItem = new FoodItem(3, "food_item", 16.16f, new Date(), (short) 10);
        FoodItem foodItem2 = new FoodItem(3, "food_item2", 16.16f, new Date(), (short) 10);
        TechnicalItem technicalItem = new TechnicalItem(4, "tech_item", 32.32f, (short) 5);

        GenericItem[] items = new GenericItem[5];
        items[0] = item1;
        items[1] = item2;
        items[2] = item3;
        items[3] = foodItem;
        items[4] = technicalItem;

        for (GenericItem item: items) {
            item.printAll();
        }

        System.out.println(foodItem.equals(foodItem2));
    }
}
