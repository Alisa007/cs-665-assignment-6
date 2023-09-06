package edu.bu.met.cs665.example1;

import edu.bu.met.cs665.example1.InventoryItem;

public class Condiment extends InventoryItem {
    public int minCount;
    public int maxCount;
  
    public Condiment(int count, int minCount, int maxCount) {
      super(count);
  
      this.minCount = minCount;
      this.maxCount = maxCount;
    }
  }
  