public class VirtualPet {
    private String name;
    private String type;
    private int hunger;
    private int happiness;
    private int sadness;
    private int thirst;
    private int health;

    public VirtualPet(String name, String type) {
        this.name = name;
        this.type = type;
        this.hunger = 50;     // Initial hunger level
        this.happiness = 50;  // Initial happiness level
        this.thirst = 50;     // Initial thirst level
        this.health = 80;     // Initial health level
        this.sadness = 80;    // Initial sadness level

    }

    // Getters for name and type
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    // Other getters and setters 
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getSadness() {
        return this.sadness;
    }

    public void setSadness(int sadness) {
        this.sadness = sadness;
    }

    public int getThirst() {
        return this.thirst;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void feed() {
        hunger -= 10;
        happiness += 7;
        sadness -= 10;
        System.out.println(name + " has been fed.");
    }

    public void play() {
        hunger += 5;
        happiness += 10;
        sadness -= 10;
        thirst += 5;
        System.out.println(name + " has played with you.");
    }

    public void giveWater() {
        thirst -= 10;
        happiness += 5;
        sadness -= 3;
        System.out.println(name + " has been given water.");
    }

    public void cleanCages() {
        happiness += 5;
        sadness -= 4;
        System.out.println("You cleaned the animal cages.");
    }

    public void takeToVet() {
        health += 6;
        happiness -= 6;
        sadness += 8;
        System.out.println(name + " has been taken to the vet.");
    }

    public void goPotty() {
        happiness += 4;
        sadness -= 4;
        health += 2;
        hunger += 5;
        thirst += 3;
        System.out.println(name + " went potty.");
    }

    public void checkStatus() {
        System.out.println("----- " + name + "'s Status -----");
        System.out.println("Type: " + type + "\n");
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Sadness: " + sadness);
        System.out.println("Thirst: " + thirst);
        System.out.println("Health: " + health);
        System.out.println("-------------------------");
    }
}

