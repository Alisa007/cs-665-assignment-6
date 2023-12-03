/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/5/2023
 * File Name: VendingMachine.java
 * Description: This file holds the VendingMachine class, that integrates and 
 * manages the operations of the vending machine, 
 * interacting with other classes such as Drink, Condiment, and InventoryItem. 
 * It maintains the state of the vending machine, the inventory of items and addons, 
 * and the availability of cups.
 * The VendingMachine class provides functionalities to select a item with desired 
 * addons, process payment through a card, handle errors, and manage the operational 
 * progress of the machine.
 * The class also manages the inventory by updating the count of items 
 * upon successful transactions. The class employs a state-based approach using the 
 * VendingMachineState enumeration to manage the different states of the vending machine. 
 * The class responds to user interactions and transitions between states based 
 * on user actions and the availability of inventory items.
 */

package edu.bu.met.cs665.vm;

import edu.bu.met.cs665.vm.InventoryItem;
import edu.bu.met.cs665.vm.VendingMachineError;
import edu.bu.met.cs665.vm.VendingMachineState;
import java.util.HashMap;
import java.util.Set;

public class VendingMachine {
  public VendingMachineState state = VendingMachineState.IDLE;
  private HashMap<String, InventoryItem> items;
  private HashMap<String, InventoryItem> addons;
  private InventoryItem cups;

  private String currentItem;
  private HashMap<String, Number> currentAddons;

  /**
   * Constructor for VendingMachine class initializing the items, addons and cups.
   * @param items HashMap containing the items available in the vending machine.
   * @param addons HashMap containing the addons available in the vending machine.
   * @param cupsCount The number of cups available in the vending machine.
   */
  public VendingMachine(
      HashMap<String, InventoryItem> items, 
      HashMap<String, InventoryItem> addons, 
      int cupsCount
  ) {
    super();

    this.items = items;
    this.addons = addons;
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
   * Resets the current item, current addons and sets the state to IDLE.
   */
  private void reset() {
    this.currentItem = null;
    this.currentAddons = null;
    this.state = VendingMachineState.IDLE;
  }

  /**
   * Selects a item and sets the state to WAITING_PAYMENT if the item is available.
   * Handles insufficient inventory error if the item is unavailable.
   * @param itemName The name of the item to be selected.
   * @param addons The addons chosen for the item.
   */
  public void selectItem(String itemName, HashMap<String, Number> addons) {
    if (this.state != VendingMachineState.IDLE) {
      return;
    }

    if (!this.cups.isAvailable(1) || !this.items.get(itemName).isAvailable(1)) {
      this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
      return;
    }
   
    Set<String> addonNames = addons.keySet();
    
    for (String addonName : addonNames) {
      int requestedAddonCount = addons.get(addonName).intValue();

      if (!this.addons.get(addonName).isAvailable(requestedAddonCount)) {
        this.handleError(VendingMachineError.INSUFFICIENT_INVENTORY);
        return;
      }
    }

    this.currentItem = itemName;
    this.currentAddons = addons;
    this.state = VendingMachineState.WAITING_PAYMENT;
  }

  /**
   * Processes payment, updates inventory, and sets the state to DISPENSING_ITEM.
   */
  public void payCard() {
    if (this.state != VendingMachineState.WAITING_PAYMENT) {
      return;
    }

    this.waitingForOperationProgress(VendingMachineState.DISPENSING_ITEM);

    this.items.get(currentItem).remove(1);

    Set<String> addonNames = this.currentAddons.keySet();
    
    for (String addonName : addonNames) {
      int requestedAddonCount = this.currentAddons.get(addonName).intValue();

      this.addons.get(addonName).remove(requestedAddonCount);
    }

    this.state = VendingMachineState.WAITING_ITEM_COLLECTION;
  }

  /**
   * Resets the vending machine after the item has been collected.
   */
  public void collectItem() {
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
