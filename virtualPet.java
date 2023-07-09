public class VirtualPet{
    private String type;
    private int Food;
    private int hunger;

    public static final int HUNGER_INCREMENT = 5;

// constructor
    public VirtualPet(String type, int Food) {
        this.type = type;
        this.Food = Food;
        this.hunger = 0;
    }
    
//getter
    public String getType() {
        return this.type;
    }
//setter
    public void setType(String type) {
        this.type = type;
    }
//getter
    public int getFood() {
        return this.Food;
    }
//setter
    public void setFood(int Food) {
        this.Food = Food;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void increaseHunger(int amount) {
        hunger += amount;
    }

}