/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: InventoryItem.java
 * Description: This file contains the definition for the InventoryItem class. 
 * The InventoryItem class represents a generic item within the inventory 
 * of the vending machine, holding attributes such as count and maxPerOrder 
 * to manage the quantity and maximum allowable order of each item. 
 * It provides a constructor for initializing the item count and, optionally, 
 * the maximum per order.
 * The InventoryItem class serves as a base class and is extended by specialized 
 * item classes like Drink and Condiment in the system, enabling a structured and 
 * modular approach to representing various items within the vending machine.
 */

package edu.bu.met.cs665.vm;

public class InventoryItem {
  public int count = 0;
  public int maxPerOrder = Integer.MAX_VALUE;

  /**
   * Constructor for the InventoryItem class initializing the count and, optionally, 
   * the maximum quantity per order.
   * @param count The initial quantity of the item available in the vending machine.
   * @param maxPerOrder Optional parameter indicating the maximum quantity of the item.
   */
  public InventoryItem(int count, int... maxPerOrder) {
    super();
    this.count = count;

    if (maxPerOrder.length > 0) {
      this.maxPerOrder = maxPerOrder[0]; 
    }
  }

  /**
   * Adjusts the quantity of the inventory item upon removal.
   * @param removeCount The number of items to be removed from the inventory.
   */
  protected void remove(int removeCount) {
    this.count = this.count - removeCount;
  }

  /**
   * Checks the availability of the requested item count against the inventory 
   * and order limits.
   * @param requestedCount The number of items requested.
   * @return Boolean indicating whether the requested count of items is available.
   */
  protected Boolean isAvailable(int requestedCount) {
    return requestedCount <= count && requestedCount <= maxPerOrder;
  }
}
