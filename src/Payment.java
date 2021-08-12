
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class Payment {
    private double penny = 0.01;
    private double nickel = 0.05;
    private double dime = 0.10;
    private double quarter = 0.25;
    private double halfDollar = 0.50;
    private double dollar = 1.00;
    private double amountDue = 0.0;
    private double amountPaid = 0.00;
    private double changeDue = 0.0;
    private int numPennies = 0;
    private int numNickels = 0;
    private int numDimes = 0;
    private int numQuarters = 0;
    private int numHalfDollars = 0;
    private int numDollars = 0;
    ArrayList<String> paymentOptions = new ArrayList<>();
    
    public void setPaymentOptions(){
        paymentOptions.add("Penny");
        paymentOptions.add("Nickel");
        paymentOptions.add("Dime");
        paymentOptions.add("Quarter");
        paymentOptions.add("Half-dollar");
        paymentOptions.add("Dollar");
    }
    public String getPaymentOptions(){
        String msg = "Total due: $" + String.format("%.2f",amountDue)
                + "\nYou've paid $" + String.format("%.2f",amountPaid) + "\n\n";
        for(int i = 0; i<paymentOptions.size(); i++){
            msg = msg + (i + 1) + " - " + paymentOptions.get(i) + "\n";
        }
        msg = msg + "\n0 - Return money";
        return msg;
    }
    
    public void takePayment(int payment){
        switch (payment){
            case 1:
                amountPaid = amountPaid + penny;
                break;
            case 2:
                amountPaid = amountPaid + nickel;
                break;
            case 3:
                amountPaid = amountPaid + dime;
                break;
            case 4:
                amountPaid = amountPaid + quarter;
                break;
            case 5:
                amountPaid = amountPaid + halfDollar;
                break;
            case 6:
                amountPaid = amountPaid + dollar;
                break;
        }
    }
    public void returnPayment(){
        if(amountPaid > 0){
            JOptionPane.showMessageDialog(null, "Your $" + String.format("%.2f",amountPaid) + " has been returned.", "Zach's Vending - Return money", JOptionPane.PLAIN_MESSAGE);
            amountPaid = 0.0;
        }else{
            JOptionPane.showMessageDialog(null, "You have no money to return!", "Zach's Vending - Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String returnChange(){
        //reset variables
        numPennies = numNickels = numDimes = numQuarters = numHalfDollars = numDollars = 0;
        
        changeDue = Math.round((amountPaid - amountDue)*100) / 100.0;
        double totalOwed = changeDue;
        do{
            if((changeDue/dollar) >= 1){
                changeDue = Math.round((changeDue - 1)*100) / 100.0;
                numDollars++;
            }else if((changeDue/halfDollar) >= 1){
                changeDue = Math.round((changeDue - 0.5)*100) / 100.0;
                numHalfDollars++;
            }else if((changeDue/quarter) >= 1){
                changeDue = Math.round((changeDue - 0.25)*100) / 100.0;
                numQuarters++;
            }else if((changeDue/dime) >= 1){
                changeDue = Math.round((changeDue - 0.1)*100) / 100.0;
                numDimes++;
            }else if((changeDue/nickel) >= 1){
                changeDue = Math.round((changeDue - 0.05)*100) / 100.0;
                numNickels++;
            }else if((changeDue/penny) >= 1){
                changeDue = Math.round((changeDue - 0.01)*100) / 100.0;
                numPennies++;
            }
        }while(changeDue != 0.0);
        String msg = "Change due: $" + String.format("%.2f", totalOwed) + "\n";
        
        if(numDollars != 0){
            if(numDollars == 1){
                msg = msg + "-" + numDollars + " dollar\n";
            }else{
                msg = msg + "-" + numDollars + " dollars\n";
            }
        }
        if(numHalfDollars != 0){
            if(numHalfDollars == 1){
                msg = msg + "-" + numHalfDollars + " half-dollar\n";
            }else{
                msg = msg + "-" + numHalfDollars + " half-dollars\n";
            }
        }
        if(numQuarters != 0){
            if(numQuarters == 1){
                msg = msg + "-" + numQuarters + " quarter\n";
            }else{
                msg = msg + "-" + numQuarters + " quarters\n";
            }
        }
        if(numDimes != 0){
            if(numDimes == 1){
                msg = msg + "-" + numDimes + " dime\n";
            }else{
                msg = msg + "-" + numDimes + " dimes\n";
            }
        }
        if(numNickels != 0){
            if(numNickels == 1){
                msg = msg + "-" + numNickels + " nickel\n";
            }else{
                msg = msg + "-" + numNickels + " nickels\n";
            }
        }
        if(numPennies != 0){
            if(numPennies == 1){
                msg = msg + "-" + numPennies + " penny\n";
            }else{
                msg = msg + "-" + numPennies + " pennies\n";
            }
        }
        amountPaid = 0.0;
        return msg;
    }
    public void setAmountDue(int input){
        switch (input) {
            case 1: 
                amountDue = 0.10;
                break;
            case 2: 
                amountDue = 0.50;
                break;
            case 3: 
                 amountDue = 0.90;
                break;
            case 4: 
                amountDue = 0.25;
                break;
            case 5: 
                amountDue = 0.35;
                break;
            case 6: 
                amountDue = 0.45;
                break;
        } 
    }
    public boolean enoughPaid(){
        if(amountPaid >= amountDue){
            return true;
        }else{
            return false;
        }
    }
}
