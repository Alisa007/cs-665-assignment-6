/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: Drink.java
 * Description: This file encapsulates the Drink class, 
 * which is a specialized type of InventoryItem within a vending machine system. 
 * The Drink class inherits the properties and functionalities of 
 * the InventoryItem class and further extends it by incorporating a price attribute, 
 * indicating the cost of each drink item. Instances of the Drink class 
 * are initialized with a specific count, representing the available quantity, and a price. 
 * The class is a part of a vending machine system, 
 * representing items categorized as condiments in the inventory.
 */

package edu.bu.met.cs665.vm;

import edu.bu.met.cs665.vm.InventoryItem;

public class Drink extends InventoryItem {
  public int price;

  /**
   * Constructor for the Drink class initializing the count and price of the drink.
   * @param count The initial quantity of the drink available in the vending machine.
   * @param price The price of the drink.
   */
  public Drink(int count, int price) {
    super(count);

    this.price = price;
  }
}