package edu.bu.met.cs665.example1;

public class InventoryItem {
  public int count = 0;
  public int maxPerOrder = Integer.MAX_VALUE;

  public InventoryItem(int count, int... maxPerOrder) {
    super();
    this.count = count;

    if (maxPerOrder.length > 0) {
      this.maxPerOrder = maxPerOrder[0]; 
    }
  }

  protected void remove(int removeCount) {
    this.count = this.count - removeCount;
  }

  protected Boolean isAvailable(int requestedCount) {
    return requestedCount <= count && requestedCount <= maxPerOrder;
  }
}
