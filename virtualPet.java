public class VirtualPet{
    private String type;
    private int Food;

// constructor
    public VirtualPet(String type, int Food) {
        this.type = type;
        this.Food = Food;
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

}