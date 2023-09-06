package edu.bu.met.cs665.example1;

public class InventoryItem {
  private int count = 0;

  public InventoryItem(int count) {
    super();
    this.count = count;
  }

  protected void add(int addCount) {
    this.count = this.count + addCount;
  }

  protected void remove(int removeCount) {
    this.count = this.count + removeCount;
  }

  protected Boolean isAvailable(int requestedCount) {
    return requestedCount <= count;
  }
}
