package edu.bu.met.cs665.example1;

public enum VendingMachineState {
    IDLE,
    WAITING_PAYMENT,
    DISPENSING_DRINK,
    WAITING_DRINK_COLLECTION,
    REFUNDING_PAYMENT,
    ERROR,
  }