/**
 * Name: Alisa Belousova
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2023
 * File Name: VendingMachineState.java
 * Description: The VendingMachineState enum represents the different operational 
 * states that a vending machine can be in throughout its transaction cycle. 
 * The enumeration includes the following states:
 * - IDLE: The initial state, indicating that the vending machine 
 * is ready for a new transaction.
 * - WAITING_PAYMENT: The state after a user has selected a drink 
 * and the machine is awaiting payment.
 * - DISPENSING_DRINK: The state when the machine is in the process 
 * of dispensing the selected drink after receiving payment.
 * - WAITING_DRINK_COLLECTION: The state in which the machine waits 
 * for the user to collect the dispensed drink.
 * - REFUNDING_PAYMENT: The state during which the machine is 
 * refunding the payment, usually due to a cancellation or error.
 * - ERROR: The state representing that an error has occurred, 
 * such as insufficient inventory or funds.
 */

package edu.bu.met.cs665.vm;

public enum VendingMachineState {
  IDLE,
  WAITING_PAYMENT,
  DISPENSING_DRINK,
  WAITING_DRINK_COLLECTION,
  REFUNDING_PAYMENT,
  ERROR,
}