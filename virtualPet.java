
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
    private int mess;
    private long lastTickTime = System.currentTimeMillis();
    private static final long TICK_RATE = 60000; // Adjust this value as needed (in milliseconds)


    public VirtualPet(String name, String type) {
        this.name = name;
        this.type = type;
        this.hunger = 50;     // Initial hunger level
        this.happiness = 50;  // Initial happiness level
        this.thirst = 50;     // Initial thirst level
        this.health = 80;     // Initial health level
        this.sadness = 75;    // Initial sadness level
        this.sleep = 50;       // Initial energy level
        this.hygiene = 20;     // Initial energy level
        this.mess = 10;         // Initial mess in cage
    }

    // Getters for name and type
    protected String getName() {
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

    public int getMess() {
        return this.mess;
    }

    public void setMess(int mess) {
        this.mess = mess;
    }

    public long getLastTickTime() {
        return this.lastTickTime;
    }

    public void setLastTickTime(long lastTickTime) {
        this.lastTickTime = lastTickTime;
    }
    
    public void feed() {
        hunger -= 30;
        happiness += 9;
        sadness -= 12;
        sleep += 14;
        hygiene -= 8;
        thirst += 7;
        mess += 20;

// Make sure attributes don't go below 0
    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));

        System.out.println(name + " has been fed.");
    }

    public void play() {
        hunger += 8;
        happiness += 10;
        sadness -= 10;
        thirst += 15;
        sleep -= 20;
        hygiene -= 13;

    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));

        System.out.println(name + " has played with you.");
    }

    public void giveWater() {
        thirst -= 20;
        happiness += 5;
        sadness -= 3;
        sleep += 3;
        hygiene += 7;
        mess += 13;

    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));

        System.out.println(name + " has been given water.");
    }

    public void groomingPets() {
        happiness += 25;
        sadness -= 4;
        sleep += 5;
        hygiene += 30;
        sadness -= 20;
        hunger -= 5;
        mess -= 5;

    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));

        System.out.println("You have groomed " + name);
    }

    public void takeToVet() {
        health += 15;
        happiness -= 10;
        sadness += 8;
        sleep += 10;
        hygiene += 15;
        mess -= 4;

    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    health= Math.min(100, Math.max(0, health));

        System.out.println(name + " has been taken to the vet.");
    }

    public void goPotty() {
        happiness += 6;
        sadness -= 5;
        health += 5;
        hunger += 8;
        thirst += 7;
        sleep -= 4;
        mess -= 25;

    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));
    health= Math.min(100, Math.max(0, health));

        System.out.println(name + " went potty!");
    }

    public void walkDogs() {
        happiness += 10;
        sadness -= 8;
        health += 6;
        hunger += 5;
        thirst += 8;
        sleep -= 7;
        mess -= 10;

    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));
    health= Math.min(100, Math.max(0, health));

        System.out.println(name + " went for a walk!");
    }

    public void putToSleep(int hoursOfSleep) {
        happiness += 4;
        sadness -= 4;
        health += 1;
        hunger += 7;
        thirst += 4;
        sleep += hoursOfSleep;

    hunger = Math.max(0, hunger);
    happiness = Math.min(100, Math.max(0, happiness));
    sadness = Math.max(0, sadness);
    sleep = Math.min(100, Math.max(0, sleep));
    hygiene = Math.max(0, hygiene);
    thirst = Math.min(100, Math.max(0, thirst));
    health= Math.min(100, Math.max(0, health));
        
        if (type.equalsIgnoreCase("robot")) {
            System.out.println(name + " got " + hoursOfSleep + " hours on the charger!");
        } else {
            System.out.println(name + " got " + hoursOfSleep + " hours of sleep!");
        }
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
        happiness -= 2 * tickMultiplier;
        sadness   += 3 * tickMultiplier;
        health    -= 5 * tickMultiplier;
        mess      += 8 * tickMultiplier;

        lastTickTime = currentTime; // Update the last tick time

        // Ensure attributes stay within their valid range
        hunger = Math.min(hunger, 100);
        thirst = Math.min(thirst, 100);
        sleep = Math.max(0, sleep);
        hygiene = Math.max(0, hygiene);
        happiness = Math.max(0,happiness);
        sadness = Math.max(0, sadness);
        health = Math.max(0, health);
        mess =  Math.max(0, mess);
    }


    public void checkStatus() {
        System.out.println("----- " + name + "'s Status -----");
        System.out.println("Type: " + type + "\n");
        
        if (type.equalsIgnoreCase("robot")) {
            System.out.println("Battery: " + sleep);
            System.out.println("Happiness: " + happiness);
            System.out.println("Updates: " + health);
            System.out.println("Sadness: " + sadness);
            System.out.println("Rust: " + hygiene);
        } else {
            System.out.println("Hunger: " + hunger);
            System.out.println("Happiness: " + happiness);
            System.out.println("Sadness: " + sadness);
            System.out.println("Thirst: " + thirst);
            System.out.println("Health: " + health);
            System.out.println("Energy: " + sleep);
            System.out.println("Hygiene: " + hygiene);
            System.out.println("Mess: " + mess);
        }
        
        System.out.println("-------------------------");
    }
    
}

