
public class VirtualPet {
    private String name;
    private String type;
    private int hunger;
    private int happiness;
    private int sadness;
    private int thirst;
    private int health;
    private int sleep;
    private int hygiene;
    private long lastTickTime = System.currentTimeMillis();
    private static final long TICK_RATE = 60000; // Adjust this value as needed (in milliseconds)


    public VirtualPet(String name, String type) {
        this.name = name;
        this.type = type;
        this.hunger = 50;     // Initial hunger level
        this.happiness = 50;  // Initial happiness level
        this.thirst = 50;     // Initial thirst level
        this.health = 80;     // Initial health level
        this.sadness = 80;    // Initial sadness level
        this.sleep = 50;       // Initial energy level
        this.hygiene = 20;     // Initial energy level
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

    public int getHygiene() {
        return this.hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getSleep() {
        return this.sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public void feed() {
        hunger -= 10;
        happiness += 7;
        sadness -= 10;
        sleep += 4;
        hygiene -= 1;
        thirst += 5;
        System.out.println(name + " has been fed.");
    }

    public void play() {
        hunger += 5;
        happiness += 10;
        sadness -= 10;
        thirst += 5;
        sleep -= 7;
        hygiene -= 6;
        System.out.println(name + " has played with you.");
    }

    public void giveWater() {
        thirst -= 10;
        happiness += 5;
        sadness -= 3;
        System.out.println(name + " has been given water.");
    }

    public void groomingPets() {
        happiness += 5;
        sadness -= 4;
        sleep += 3;
        hygiene += 10;
        System.out.println("You have groomed " + name);
    }

    public void takeToVet() {
        health += 6;
        happiness -= 6;
        sadness += 8;
        sleep += 5;
        hygiene += 5;
        System.out.println(name + " has been taken to the vet.");
    }

    public void goPotty() {
        happiness += 4;
        sadness -= 4;
        health += 2;
        hunger += 5;
        thirst += 5;
        System.out.println(name + " went potty.");
    }

    public void putToSleep(int hoursOfSleep) {
        happiness += 4;
        sadness -= 4;
        health += 1;
        hunger += 7;
        thirst += 4;
        sleep += hoursOfSleep;
        System.out.println(name + " got " + hoursOfSleep + " hours of sleep!");
    }

    public void tick() {
        long currentTime = System.currentTimeMillis();
        long timeSinceLastTick = currentTime - lastTickTime;
        int tickMultiplier = (int) (timeSinceLastTick / TICK_RATE); // Calculate the number of ticks

        // Update the attributes based on the tick multiplier
        hunger += 5 * tickMultiplier;
        thirst += 5 * tickMultiplier;
        sleep -= 5 * tickMultiplier;
        hygiene -= 3 * tickMultiplier;
        sadness += 2 * tickMultiplier;

        lastTickTime = currentTime; // Update the last tick time

        // Ensure attributes stay within their valid range
        hunger = Math.min(hunger, 100);
        thirst = Math.min(thirst, 100);
        sleep = Math.max(0, sleep);
        hygiene = Math.max(0, hygiene);
        sadness = Math.max(0, sadness);
    }

    public void checkStatus() {
        System.out.println("----- " + name + "'s Status -----");
        System.out.println("Type: " + type + "\n");
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Sadness: " + sadness);
        System.out.println("Thirst: " + thirst);
        System.out.println("Health: " + health);
        System.out.println("Energy: " + sleep);
        System.out.println("Hygiene: " + hygiene);
        System.out.println("-------------------------");
        System.out.println("are the animals ok?");
    }
}

