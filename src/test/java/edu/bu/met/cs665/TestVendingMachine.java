package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import org.junit.Test;
import edu.bu.met.cs665.example1.Drink;
import edu.bu.met.cs665.example1.Condiment;
import edu.bu.met.cs665.example1.VendingMachine;
import edu.bu.met.cs665.example1.VendingMachineState;

public class TestVendingMachine {

    public TestVendingMachine() {
    }

    @Test
    public void testSuccessfulDrinkDispensionWithCard() {
        HashMap<String, Drink> drinks = new HashMap();

        drinks.put("Espresso", new Drink(97, 199));
        drinks.put("Americano", new Drink(44, 199));
        drinks.put("Latte Macchiato", new Drink(67, 299));
        drinks.put("Black Tea", new Drink(97, 199));
        drinks.put("Green Tea", new Drink(44, 150));
        drinks.put("Yellow Tea", new Drink(67, 199));
          
        HashMap<String, Condiment> condiments = new HashMap();

        condiments.put("milk", new Condiment(200, 0, 3));
        condiments.put("sugar", new Condiment(100, 0, 3));
        
        VendingMachine vendingMachine = new VendingMachine(drinks, condiments, 999);

        HashMap<String, Number> currentCondiments = new HashMap();

        currentCondiments.put("sugar", 2);
        
        vendingMachine.selectDrink("Black Tea", currentCondiments);
        
        vendingMachine.payCard();
  
        assertEquals(VendingMachineState.IDLE, vendingMachine.state);
    }
}
