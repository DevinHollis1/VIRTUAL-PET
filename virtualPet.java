import java.util.HashMap;
import java.util.Map;

public class VirtualPet {
    private String name;
    private String type;
    private int food;
    private int hunger;
    private int water;
    private int energy;
    private Map<String, Integer> fedFoodTypes;

    public VirtualPet(String type, String name, int food, int water) {
        this.name = name;
        this.type = type;
        this.food = food;
        this.water = water;
        this.fedFoodTypes = new HashMap<>();
        setHunger(hunger); // Call the setter method to cap the hunger level
        setWater(water); // Call the setter method to cap the water level
        setEnergy(energy); // Call the setter method to cap the energy level
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getFood() {
        return food;
    }

    public int getHunger() {
        return hunger;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setHunger(int hunger) {
        this.hunger = Math.min(hunger, 100);
    }

    public int getWater() {
        return water;
    }

    public void increaseHunger(int amount) {
        hunger += amount;
        hunger = Math.min(hunger, 100); // Cap the hunger level at 100
    }

    public void decreaseHunger(int amount) {
        hunger -= amount;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void increaseWater(int amount) {
        water += amount;
        water = Math.min(water, 100); // Cap the water level at 100
    }

    public void decreaseWater(int amount) {
        water -= amount;
        if (water < 0) {
            water = 0;
        }
    }

    public void setEnergy(int energy) {
        this.energy = Math.min(energy, 100);
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy(int amount) {
        energy += amount;
        energy = Math.min(energy, 100); // Cap the energy level at 100
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
        if (energy < 0) {
            energy = 0;
        }
    }

    public void feedFoodType(String foodType, int foodAmount) {
        fedFoodTypes.put(foodType, foodAmount);
    }

    // Method to check if all food types have been fed
    public boolean hasFedAllTypes() {
        return fedFoodTypes.containsKey("steak") && fedFoodTypes.containsKey("kibble")
                && fedFoodTypes.containsKey("chicken");
    }

    // Method to check if a specific food type has been fed
    public boolean hasFedType(String foodType) {
        return fedFoodTypes.containsKey(foodType);
    }

    // Method to get the food amount for a specific food type
    public int getFoodByType(String foodType) {
        return fedFoodTypes.getOrDefault(foodType, 0);
    }

    public void addFoodAmount(String foodType, int amount) {
        food += amount;
    }

    public void decreaseFoodAmount(String foodType, int amount) {
        food -= amount;
        if (food < 0) {
            food = 0;
        }
    }

    @Override
    public String toString() {
        return "VirtualPet [type=" + type + ", food=" + food + ", hunger=" + hunger + ", water=" + water + ", energy=" + energy + "]";
    }
}
