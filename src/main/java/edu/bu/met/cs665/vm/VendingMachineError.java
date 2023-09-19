/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: VendingMachineError.java
 * Description: The VendingMachineError enum represents the various error states or issues 
 * that may arise during the operation of the vending machine. 
 * The enumeration consists of the following error types:
 * - INSUFFICIENT_INVENTORY: This error occurs when the vending machine does 
 * not have enough inventory to fulfill the user's request, either for a drink, 
 * condiment, or any other item.
 * - INSUFFICIENT_FUNDS: This error is triggered when there are not enough funds 
 * provided by the user to complete the transaction for the selected items.
 */

package edu.bu.met.cs665.vm;

public enum VendingMachineError {
  INSUFFICIENT_INVENTORY,
  INSUFFICIENT_FUNDS,
}
