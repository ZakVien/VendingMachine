
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public class Food {
    ArrayList<String> foodOptions = new ArrayList<>();
    ArrayList<String> foodCost = new ArrayList<>();
    private String foodMenu;
    private String selectedItem;
    
    public void setFoodOptions(){
        foodOptions.add("Candy");
        foodOptions.add("Snack");
        foodOptions.add("Nuts");
        foodOptions.add("Coke");
        foodOptions.add("Pepsi");
        foodOptions.add("Soda");
    }
    public void setFoodCost(){
        foodCost.add("0.10");
        foodCost.add("0.50");
        foodCost.add("0.90");
        foodCost.add("0.25");
        foodCost.add("0.35");
        foodCost.add("0.45");
    }
    
    public void setFoodMenu(){
        this.setFoodOptions();
        this.setFoodCost();
        String msg = "";
        for(int i = 0; i<foodOptions.size(); i++){
            msg = msg + (i + 1) + " - " + foodOptions.get(i) + " (" + foodCost.get(i) + ")\n";
        }
        msg = msg + "\n0 - Exit";
        foodMenu = msg;
    }
    public String getFoodMenu(){
        return foodMenu;
    }
    public void setSelectedItem(int input){
        switch(input){
            case 1:
                selectedItem = "Candy";
                break;
            case 2:
                selectedItem = "Snack";
                break;
            case 3:
                selectedItem = "Nuts";
                break;
            case 4:
                selectedItem = "Coke";
                break;
            case 5:
                selectedItem = "Pepsi";
                break;
            case 6:
                selectedItem = "Soda";
                break;
        }
    }
    public String getSelectedItem(){
        String item = selectedItem.toLowerCase();
        return item;
    }
}
