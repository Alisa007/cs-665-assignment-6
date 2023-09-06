package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import org.junit.Test;
import edu.bu.met.cs665.example1.Drink;
import edu.bu.met.cs665.example1.Condiment;
import edu.bu.met.cs665.example1.VendingMachine;
import edu.bu.met.cs665.example1.VendingMachineState;

public class TestVendingMachineCard {
    public TestVendingMachineCard() {}

    private VendingMachine getVendingMachine(int drinkCount, int condimentCount, int cupCount) {
        HashMap<String, Drink> drinks = new HashMap();

        drinks.put("Espresso", new Drink(drinkCount, 198));
        drinks.put("Americano", new Drink(44, 199));
        drinks.put("Latte Macchiato", new Drink(67, 299));
        drinks.put("Black Tea", new Drink(97, 199));
        drinks.put("Green Tea", new Drink(44, 150));
        drinks.put("Yellow Tea", new Drink(67, 199));


        HashMap<String, Condiment> condiments = new HashMap();

        condiments.put("milk", new Condiment(100, 0, 3));
        condiments.put("sugar", new Condiment(condimentCount, 0, 3));

        return new VendingMachine(drinks, condiments, cupCount);
    }

    @Test
    public void testSuccessfulDrinkDispension() {
        VendingMachine vendingMachine = getVendingMachine(100, 100, 100);

        HashMap<String, Number> currentCondiments = new HashMap();

        currentCondiments.put("sugar", 2);
        
        vendingMachine.selectDrink("Espresso", currentCondiments);
        assertEquals(VendingMachineState.WAITING_PAYMENT, vendingMachine.state);
        
        vendingMachine.payCard();
        assertEquals(VendingMachineState.WAITING_COLLECTION, vendingMachine.state);

        vendingMachine.collectDrink();
  
        assertEquals(VendingMachineState.IDLE, vendingMachine.state);
    }

    @Test
    public void testNoCupException() {
        VendingMachine vendingMachine = getVendingMachine(100, 100, 0);

        HashMap<String, Number> currentCondiments = new HashMap();

        currentCondiments.put("sugar", 2);
        
        vendingMachine.selectDrink("Espresso", currentCondiments);
        assertEquals(VendingMachineState.ERROR, vendingMachine.state);
    }

    @Test
    public void testNoDrinkException() {
        VendingMachine vendingMachine = getVendingMachine(0, 100, 100);

        HashMap<String, Number> currentCondiments = new HashMap();

        currentCondiments.put("sugar", 2);
        
        vendingMachine.selectDrink("Espresso", currentCondiments);
        assertEquals(VendingMachineState.ERROR, vendingMachine.state);
    }

    // @Test
    // public void testInsufficientCondimentsException() {
    //     VendingMachine vendingMachine = getVendingMachine(100, 1, 100);

    //     HashMap<String, Number> currentCondiments = new HashMap();

    //     currentCondiments.put("sugar", 2);
        
    //     vendingMachine.selectDrink("Espresso", currentCondiments);
    //     assertEquals(VendingMachineState.ERROR, vendingMachine.state);
    // }

    @Test
    public void testKeepErrorStateOnException() {
        VendingMachine vendingMachine = getVendingMachine(0, 100, 100);

        HashMap<String, Number> currentCondiments = new HashMap();

        currentCondiments.put("sugar", 2);
        
        vendingMachine.selectDrink("Espresso", currentCondiments);
        assertEquals(VendingMachineState.ERROR, vendingMachine.state);
        
        vendingMachine.payCard();
        assertEquals(VendingMachineState.ERROR, vendingMachine.state);

        vendingMachine.collectDrink();
  
        assertEquals(VendingMachineState.ERROR, vendingMachine.state);
    }
}
