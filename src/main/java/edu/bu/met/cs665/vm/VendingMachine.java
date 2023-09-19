/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: VendingMachine.java
 * Description: This file holds the VendingMachine class, that integrates and 
 * manages the operations of the vending machine, 
 * interacting with other classes such as Drink, Condiment, and InventoryItem. 
 * It maintains the state of the vending machine, the inventory of drinks and condiments, 
 * and the availability of cups.
 * The VendingMachine class provides functionalities to select a drink with desired 
 * condiments, process payment through a card, handle errors, and manage the operational 
 * progress of the machine.
 * The class also manages the inventory by updating the count of items 
 * upon successful transactions. The class employs a state-based approach using the 
 * VendingMachineState enumeration to manage the different states of the vending machine. 
 * The class responds to user interactions and transitions between states based 
 * on user actions and the availability of inventory items.
 */

package edu.bu.met.cs665.vm;

import edu.bu.met.cs665.vm.Condiment;
import edu.bu.met.cs665.vm.Drink;
import edu.bu.met.cs665.vm.InventoryItem;
import edu.bu.met.cs665.vm.VendingMachineError;
import edu.bu.met.cs665.vm.VendingMachineState;
import java.util.HashMap;
import java.util.Set;

public class VendingMachine {
  public VendingMachineState state = VendingMachineState.IDLE;
  private HashMap<String, Drink> drinks;
  private HashMap<String, Condiment> condiments;
  private InventoryItem cups;

  private String currentDrink;
  private HashMap<String, Number> currentCondiments;

  /**
   * Constructor for VendingMachine class initializing the drinks, condiments and cups.
   * @param drinks HashMap containing the drinks available in the vending machine.
   * @param condiments HashMap containing the condiments available in the vending machine.
   * @param cupsCount The number of cups available in the vending machine.
   */
  public VendingMachine(
      HashMap<String, Drink> drinks, 
      HashMap<String, Condiment> condiments, 
      int cupsCount
  ) {
    super();

    this.drinks = drinks;
    this.condiments = condiments;
    this.cups = new InventoryItem(cupsCount);
  }

  /**
   * Handles errors and sets the vending machine state to ERROR.
   * @param message The error message to be displayed.
   */
  private void handleError(VendingMachineError message) {
    System.out.println(message);
    
    this.state = VendingMachineState.ERROR;
  }

  /**
   * Updates the progress of the operation and sets the vending machine state.
   * @param state The state to be set for the vending machine.
   */
  private void waitingForOperationProgress(VendingMachineState state) {
    System.out.println(state);
    
    this.state = state;
  }

  /**
   * Resets the current drink, current condiments and sets the state to IDLE.
   */
  private void reset() {
    this.currentDrink = null;
    this.currentCondiments = null;
    this.state = VendingMachineState.IDLE;
  }

  /**
   * Selects a drink and sets the state to WAITING_PAYMENT if the item is available.
   * Handles insufficient inventory error if the item is unavailable.
   * @param drinkName The name of the drink to be selected.
   * @param condiments The condiments chosen for the drink.
   */
  public void selectDrink(String drinkName, HashMap<String, Number> condiments) {
    if (this.state != VendingMachineState.IDLE) {
      return;
    }

    if (!this.cups.isAvailable(1) || !this.drinks.get(drinkName).isAvailable(1)) {
      this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
      return;
    }
   
    Set<String> condimentNames = condiments.keySet();
    
    for (String condimentName : condimentNames) {
      int requestedCondimentCount = condiments.get(condimentName).intValue();

      if (!this.condiments.get(condimentName).isAvailable(requestedCondimentCount)) {
        this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
        return;
      }
    }

    this.currentDrink = drinkName;
    this.currentCondiments = condiments;
    this.state = VendingMachineState.WAITING_PAYMENT;
  }

  /**
   * Processes payment, updates inventory, and sets the state to DISPENSING_DRINK.
   */
  public void payCard() {
    if (this.state != VendingMachineState.WAITING_PAYMENT) {
      return;
    }

    this.waitingForOperationProgress(VendingMachineState.DISPENSING_DRINK);

    this.drinks.get(currentDrink).remove(1);

    Set<String> condimentNames = this.currentCondiments.keySet();
    
    for (String condimentName : condimentNames) {
      int requestedCondimentCount = this.currentCondiments.get(condimentName).intValue();

      this.condiments.get(condimentName).remove(requestedCondimentCount);
    }

    this.state = VendingMachineState.WAITING_DRINK_COLLECTION;
  }

  /**
   * Resets the vending machine after the drink has been collected.
   */
  public void collectDrink() {
    this.reset();
  }

  /**
   * Cancels the operation, resets the vending machine, and sets the state to REFUNDING_PAYMENT.
   */
  public void cancel() {
    waitingForOperationProgress(VendingMachineState.REFUNDING_PAYMENT);
    
    this.reset();
  }
}
