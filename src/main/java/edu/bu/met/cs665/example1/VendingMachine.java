package edu.bu.met.cs665.example1;

import java.util.HashMap;
import java.util.Set;
import edu.bu.met.cs665.example1.Drink;
import edu.bu.met.cs665.example1.Condiment;
import edu.bu.met.cs665.example1.InventoryItem;
import edu.bu.met.cs665.example1.VendingMachineState;

// admin functins
// same coffee multiple places
// reset all settings
 // https://www.google.com/search?q=vending+machine+dictionary&sca_esv=563020551&rlz=1C5CHFA_enTH1018TH1018&ei=00L4ZPawItbk7_UPi6iJwA0&oq=vending+machine+dicti&gs_lp=Egxnd3Mtd2l6LXNlcnAiFXZlbmRpbmcgbWFjaGluZSBkaWN0aSoCCAAyBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMggQABgWGB4YDzIIEAAYFhgeGA8yCBAAGBYYHhgPMgYQABgWGB4yCBAAGBYYHhgPSKEUUPsDWOYKcAB4AZABAJgBiQGgAcIFqgEDMS41uAEDyAEA-AEBwgIEEAAYR8ICBxAAGIoFGEPCAgUQABiABMICBRAuGIAEwgIIEAAYigUYkQLiAwQYACBBiAYBkAYI&sclient=gws-wiz-serp
 // https://dictionary.cambridge.org/dictionary/english/vending-machine
 // a machine that dispenses small articles such as food, drinks, or cigarettes when a coin or token is inserted.
// drink number at the time
// As an optional task, you may also calculate the final price of the hot beverage based on a set of
// base prices. For example, the base price for hot coffee could be set at $2. Each condiment
// could be $.50 each.

class InsufficientInventoryExcepiton extends Exception {
}

class InsufficientChangeException extends Exception {
}

class InsufficientFundsException extends Exception {
}

class OutOfRangeException extends Exception {
}


public class VendingMachine {
  public VendingMachineState state = VendingMachineState.IDLE;
  private HashMap<String, Drink> drinks;
  private HashMap<String, Condiment> condiments;
  private InventoryItem cups;

  public VendingMachine(HashMap<String, Drink> drinks, HashMap<String, Condiment> condiments, int cupCount) {
    super();

    this.drinks = drinks;
    this.condiments = condiments;
    this.cups = new InventoryItem(cupCount);
  }

  public void selectDrink(String drinkName, HashMap<String, Number> condiments) {
    // if(!this.cups.isAvailable(1) || !this.drinks.get(drinkName).isAvailable(1)) {
    //   throw new InsufficientInventoryExcepiton();
    // }
   
    Set<String> condimentNames = condiments.keySet();
    
    for (String condimentName : condimentNames) {
      System.out.println("----------------------------++++++++++++++");
      // print(condimentName);
      // int requestedCondimentCount = condiments.get(condimentName);

      // if(!this.drinks.get(condimentName).isAvailable(requestedCondimentCount)){
      //   throw new InsufficientInventoryExcepiton();
      // }
    }

    this.state = VendingMachineState.WAITING_PAYMENT;
  }

  public void payCard() {
    this.state = VendingMachineState.DISPENSING_DRINK;

    this.state = VendingMachineState.WAITING_COLLECTION;
  }

  public void collectDrink() {
    this.refund();
  }

  public void refund() {
    this.state = VendingMachineState.REFUNDING_PAYMENT;
  }

  // public void insertCoin(Coin coin) {
  //   currentBalance = currentBalance + coin.getDenomination();
  //       cashInventory.add(coin);
  // }

  public void cancel() {
    this.state = VendingMachineState.IDLE;

    // cashInventory.clear(); 
    // itemInventory.clear(); 
    // totalSales = 0; 
    // currentItem = null; 
    // currentBalance = 0; 
  }
}
