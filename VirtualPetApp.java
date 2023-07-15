import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApp {
    private static long lastInteractionTime;
    private static VirtualPet petToFeed;
    private static boolean isUserInput;
    private static boolean shouldDisplayMenu; // Flag to control menu display

    public static void main(String[] args) {
        AnimalCareList animalCareList = new AnimalCareList();
        lastInteractionTime = System.currentTimeMillis();
        petToFeed = new VirtualPet("Tiger", "Tony", 0, 0);
        animalCareList.addItemsForPet(new VirtualPet("Steak", "TONY", 200, 0));
        animalCareList.addItemsForPet(new VirtualPet("Kibble", "TONY", 500, 0));
        animalCareList.addItemsForPet(new VirtualPet("Chicken", "TONY", 300, 0));
        System.out.println("\n");

        Scanner scanner = new Scanner(System.in);
        String choice = "";

        shouldDisplayMenu = true; // Set the flag to display the menu initially
        // Start a separate thread to update the hunger and water values
        startUpdateThreads();

        while (!choice.equalsIgnoreCase("0")) {
            if (shouldDisplayMenu) {
                displayMenu(petToFeed.getHunger(), petToFeed.getWater(), 0);
                shouldDisplayMenu = false;
            }

            choice = scanner.nextLine();
            lastInteractionTime = System.currentTimeMillis();
            isUserInput = true; // Set the flag to indicate user input

            if (choice.equals("0")) {
                break;
            } else if (choice.equals("1")) {
                displayFoodSource(animalCareList, petToFeed);
                shouldDisplayMenu = true;
            } else if (choice.equals("2")) {
                petToFeed = feedPet(animalCareList, scanner, petToFeed);
                shouldDisplayMenu = true;
            } else if (choice.equals("3")) {
                petToFeed = waterPet(animalCareList, scanner, petToFeed);
                shouldDisplayMenu = true;
            }else if (choice.equals("4")) {
                petToFeed = putPetToSleep(scanner, petToFeed);
                shouldDisplayMenu = true;
            }
        }

        scanner.close();
    }

    private static void startUpdateThreads() {
        Thread hungerUpdateThread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(30); // Wait for 30 seconds
                    if (!isUserInput) {
                        tickHunger(petToFeed); // Update the hunger value
                        shouldDisplayMenu = true;
                    }
                    isUserInput = false; // Reset the flag
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread waterUpdateThread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(30); // Wait for 30 seconds
                    if (!isUserInput) {
                        tickWater(petToFeed); // Update the water value
                        shouldDisplayMenu = true;
                    }
                    isUserInput = false; // Reset the flag
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hungerUpdateThread.setDaemon(true); // Set the thread as a daemon thread
        waterUpdateThread.setDaemon(true); // Set the thread as a daemon thread
        hungerUpdateThread.start();
        waterUpdateThread.start();
    }

    public static void displayMenu(int petToFeed, int petToWater, int energy) {
        System.out.println("\nTony the Tiger");
        System.out.println("Pounds of meat eaten: " + petToFeed);
        System.out.println("Water: " + petToWater + "\n");
        System.out.println("Energy: " + energy + "%\n");
        System.out.println("Choose an option below!");
        System.out.println("1. Display available food");
        System.out.println("2. Feed Tony a meal");
        System.out.println("3. Give Tony water");
        System.out.println("4. Put Tony to sleep");
        System.out.println("0. Exit\n");
    }

    private static void displayFoodSource(AnimalCareList animalCareList, VirtualPet petToFeed) {
        System.out.println("\nAvailable food:");
        boolean foodDisplayed = false;
    
        for (VirtualPet virtualPet : animalCareList.getFood()) {
            String foodType = virtualPet.getType();
            int remainingFoodAmount = virtualPet.getFood() - petToFeed.getFoodByType(foodType);
    
            // Display the food type and remaining amount only if there is remaining food
            if (remainingFoodAmount > 0) {
                System.out.println("Food Type: " + foodType + " in Pounds: " + remainingFoodAmount);
                foodDisplayed = true;
            }
        }
    
        if (!foodDisplayed) {
            System.out.println("No food available.");
        }
    }
    
    
    

    private static VirtualPet feedPet(AnimalCareList animalCareList, Scanner scanner, VirtualPet pet) {
        System.out.println("Enter the food type: ");
        String type = scanner.nextLine().toLowerCase();
        System.out.println("Enter the food amount in pounds: ");
        int foodAmount;
        try {
            foodAmount = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Response: Please enter a valid integer for the food amount. :(");
            scanner.nextLine();
            shouldDisplayMenu = true;
            return pet;
        }

        VirtualPet petToFeed = animalCareList.getPetByType(type);
        if (petToFeed != null) {
            int hungerIncrement = foodAmount;
            petToFeed.increaseHunger(hungerIncrement);
            petToFeed.decreaseFoodAmount(type, foodAmount); // Update the available food amount
            System.out.println("You fed " + petToFeed.getName() + " " + foodAmount + " pounds of " + type + "! :)\n");

            if (petToFeed.getHunger() >= 100) {
                System.out.println("\n" + petToFeed.getName() + " IS STUFFED! :0\n");
            }

            return petToFeed; // Return the updated petToFeed
        } else {
            System.out.println("Invalid Response: Please enter either 'chicken,' 'steak,' or 'kibble' as the food type.\n");
            return pet; // Return the original pet
        }
    }

    private static VirtualPet waterPet(AnimalCareList animalCareList, Scanner scanner, VirtualPet pet) {
        System.out.println("Enter the water amount in gallons: ");
        int waterAmount;
        try {
            waterAmount = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Response: Please enter a valid integer for the water amount.");
            scanner.nextLine();
            shouldDisplayMenu = true;
            return pet;
        }

        int waterIncrement = waterAmount;
        pet.increaseWater(waterIncrement);
        System.out.println("You gave " + pet.getName() + " " + waterAmount + " gallons of water!\n");

        if (pet.getWater() >= 100) {
            System.out.println("\n" + pet.getName() + " IS HYDRATED! :)\n");
        }

        if (pet.getHunger() >= 100 && pet.getWater() >= 100) {
            System.out.println("\n" + pet.getName() + " IS STUFFED AND HYDRATED!\n ROARRRR!!\n");
        }
        return pet;
    }
    
    private static VirtualPet putPetToSleep(Scanner scanner, VirtualPet pet) {
        System.out.println("Enter the number of hours of sleep (maximum 10 hours): ");
        int hours;
        try {
            hours = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Response: Please enter a valid integer for the number of hours.");
            scanner.nextLine();
            shouldDisplayMenu = true;
            return pet;
        }
    
        // Cap the maximum sleep hours at 10
        hours = Math.min(hours, 10);
        int energyIncrement = hours * 10;
        pet.increaseEnergy(energyIncrement);
        System.out.println("You put " + pet.getName() + " to sleep for " + hours + " hours.\n");
    
        if (pet.getEnergy() >= 100) {
            System.out.println("\n" + pet.getName() + " IS FULLY RESTED!\n");
        }
    
        shouldDisplayMenu = true; // Set shouldDisplayMenu to true to trigger menu display
        displayMenu(pet.getHunger(), pet.getWater(), calculateEnergy(pet));
        return pet;
    }
    
    

    private static int calculateEnergy(VirtualPet pet) {
        int foodEnergy = (int) (pet.getFood() * 0.25); // Calculate 25% of the total food
        int waterEnergy = (int) (pet.getWater() * 0.25); // Calculate 25% of the total water
        return Math.min(foodEnergy + waterEnergy, 100); // Cap the energy at 100
    }

    private static void tickHunger(VirtualPet pet) {
        long currentTime = System.currentTimeMillis();
        long elapsedTimeInSeconds = (currentTime - lastInteractionTime) / 1000;

        if (elapsedTimeInSeconds >= 30) {
            int hungerDecrement = (int) (elapsedTimeInSeconds / 30) * 5;
            pet.decreaseHunger(hungerDecrement);
            lastInteractionTime = currentTime; // Update the lastInteractionTime
            if (pet.getHunger() > 100) {
                pet.setHunger(100); // Cap the hunger at 100
            }
            if (pet.getHunger() == 100) {
                System.out.println(pet.getName() + " IS STUFFED!");
            }
        }
    }

    private static void tickWater(VirtualPet pet) {
        long currentTime = System.currentTimeMillis();
        long elapsedTimeInSeconds = (currentTime - lastInteractionTime) / 1000;

        if (elapsedTimeInSeconds >= 30) {
            int waterDecrement = (int) (elapsedTimeInSeconds / 30) * 10;
            pet.decreaseWater(waterDecrement);
            lastInteractionTime = currentTime; // Update the lastInteractionTime
            if (pet.getWater() > 100) {
                pet.setWater(100); // Cap the water level at 100
            }
            if (pet.getWater() == 100) {
                System.out.println("\n" + pet.getName() + " IS HYDRATED!\n");
            }
        }
    }
}

