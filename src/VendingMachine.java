
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Food vendingFood = new Food();
        Payment payments = new Payment();
        String vendingMenu;
        String paymentMenu;
        String response;
        String selectedItem;
        int responseInt = 0;
        boolean addMoreMoney = true;
        boolean returnMoney = false;
        boolean forceMenuOpen = true;

        vendingFood.setFoodMenu();
        vendingMenu = vendingFood.getFoodMenu();
        payments.setPaymentOptions();

        //display main menu
        while (forceMenuOpen) {
            do {
                response = "";
                responseInt = 0;
                try {
                    response = JOptionPane.showInputDialog(null, vendingMenu, "Zach's Vending - Choose an item", JOptionPane.PLAIN_MESSAGE);
                    if(response == null){
                        System.exit(0);
                    }
                    responseInt = Integer.parseInt(response);
                    if (responseInt == 0) {
                        System.exit(0);
                    } else if (responseInt < 1 || responseInt > 6) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Please enter a number 0-6", "Zach's Vending - Invalid option", JOptionPane.WARNING_MESSAGE);
                }
            } while (responseInt < 1 || responseInt > 6);
            
            vendingFood.setSelectedItem(responseInt);
            selectedItem = vendingFood.getSelectedItem();
            payments.setAmountDue(responseInt);
            
            //begin payment
            do {
                paymentMenu = payments.getPaymentOptions();
                responseInt = 0;
                response = "";
                try {
                    response = JOptionPane.showInputDialog(null, paymentMenu, "Zach's Vending - Enter payment", JOptionPane.PLAIN_MESSAGE);
                    if(response == null){
                        break;
                    }
                    responseInt = Integer.parseInt(response);
                    if (responseInt == 0) {
                        returnMoney = true;
                    }else if (responseInt < 1 || responseInt > 6) {
                        throw new NumberFormatException();
                    }else{
                        payments.takePayment(responseInt);
                    }
                    //return money or add more money dialogue
                    if(returnMoney) {
                        payments.returnPayment();
                        returnMoney = false;
                    }
                    if(payments.enoughPaid()){
                        addMoreMoney = false;
                        break;
                    }else{
                        addMoreMoney = true;
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Please enter a number 0-6", "Zach's Vending - Invalid option", JOptionPane.WARNING_MESSAGE);
                }
            } while (addMoreMoney);
            
            //if done adding money, determine change due
            if(!addMoreMoney){
                String changeOwed = payments.returnChange();
                JOptionPane.showMessageDialog(null, changeOwed + "\nEnjoy your " + selectedItem + "!", "Zach's Vending - Enjoy!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
