package edu.bu.met.cs665.example1;

import java.util.HashMap;
import java.util.Set;
import edu.bu.met.cs665.example1.Drink;
import edu.bu.met.cs665.example1.Condiment;
import edu.bu.met.cs665.example1.InventoryItem;
import edu.bu.met.cs665.example1.VendingMachineState;

enum VendingMachineError {
  INSUFFICIENT_INVENTORY,
  INSUFFICIENT_FUNDS,
  OUT_OF_RANGE,
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

  private void refund() {
    if (this.state == VendingMachineState.ERROR) {
      return;
    }
    
    this.state = VendingMachineState.REFUNDING_PAYMENT;
    this.state = VendingMachineState.IDLE;
  }

  private void handleError(VendingMachineError message) {
    this.state = VendingMachineState.ERROR;
  }

  public void selectDrink(String drinkName, HashMap<String, Number> condiments) {
    if(!this.cups.isAvailable(1) || !this.drinks.get(drinkName).isAvailable(1)) {
      this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
      return;
    }
   
    Set<String> condimentNames = condiments.keySet();
    
    for (String condimentName : condimentNames) {
      System.out.println("----------------------------++++++++++++++");
      // print(condimentName);
      int requestedCondimentCount = condiments.get(condimentName).intValue();

      // if(!this.drinks.get(condimentName).isAvailable(requestedCondimentCount)){
      //   this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
      // }
    }

    this.state = VendingMachineState.WAITING_PAYMENT;
  }

  public void payCard() {
    if (this.state != VendingMachineState.WAITING_PAYMENT) {
      return;
    }

    this.state = VendingMachineState.DISPENSING_DRINK;
    this.state = VendingMachineState.WAITING_DRINK_COLLECTION;
  }

  public void collectDrink() {
    this.refund();
  }

  public void cancel() {
    this.state = VendingMachineState.IDLE;

    // cashInventory.clear(); 
    // itemInventory.clear(); 
    // totalSales = 0; 
    // currentItem = null; 
    // currentBalance = 0; 
  }
}
