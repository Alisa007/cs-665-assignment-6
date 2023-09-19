/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: Condiment.java
 * Description: This file contains the definition for the Condiment class 
 * which extends the InventoryItem class.
 * The Condiment class is a part of a vending machine system, 
 * representing items categorized as condiments in the inventory.
 * It inherits properties and methods from the InventoryItem class 
 * and is initialized with a count and maximum count.
 */

package edu.bu.met.cs665.vm;

import edu.bu.met.cs665.vm.InventoryItem;

public class Condiment extends InventoryItem {
  public Condiment(int count, int maxCount) {
    super(count, maxCount);
  }
}
  