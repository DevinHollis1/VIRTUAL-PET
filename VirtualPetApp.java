import java.util.InputMismatchException;
import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) {
        AnimalCareList animalCareList = new AnimalCareList();
        animalCareList.addItemsForPet(new VirtualPet("Steak", 0));
        animalCareList.addItemsForPet(new VirtualPet("Kibble", 0));
        animalCareList.addItemsForPet(new VirtualPet("Chicken", 0));

        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("0")) {
            displayMenu();
            choice = scanner.nextLine();
            if (choice.equals("0")) {
                break;
            } else if (choice.equals("1")) {
                displayFoodSource(animalCareList);
            } else if (choice.equals("2")) {
                feedPet(animalCareList, scanner);
            }
        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Tony the Tiger \n Hunger: 20 \n Thirst: 3 \n Hygiene: 15 \n Energy: 15 \n Fun meter: 10 \n");
        System.out.println("Choose an option below!");
        System.out.println("1. Display available food");
        System.out.println("2. Feed Tony a meal");
        System.out.println("0. Exit");
    }

    private static void displayFoodSource(AnimalCareList animalCareList) {
        System.out.println("\nAvailable food:");
        for (VirtualPet virtualPet : animalCareList.getFood()) {
            System.out.println("Food Type: " + virtualPet.getType() + " Pounds: " + virtualPet.getFood());
        }
    }
    private static void feedPet(AnimalCareList animalCareList, Scanner scanner) {
    System.out.println("Enter the food type: ");
    String type = scanner.nextLine().toLowerCase(); // Convert to lowercase
    System.out.println("Enter the food amount in pounds: ");
    int foodAmount;
    try {
        foodAmount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
    } catch (InputMismatchException e) {
        System.out.println("Invalid Response: Please enter a valid integer for the food amount.");
        scanner.nextLine(); // Consume the invalid input
        return;
    }

    VirtualPet pet = animalCareList.getPetByType(type);
    if (pet != null) {
        int hungerIncrement = foodAmount * VirtualPet.HUNGER_INCREMENT;
        pet.increaseHunger(hungerIncrement);
        System.out.println("You fed Tony " + foodAmount + " pounds of " + type + "!\n");
        System.out.println("Hunger: " + pet.getHunger() + "\n");
        if (pet.getHunger() >= 100) {
            System.out.println("Tony is full!");
        }
    } else {
        System.out.println("Invalid Response: Please enter either 'chicken,' 'steak,' or 'kibble' as the food type.");
    }
}

    
    
}
        // Optional: You can perform additional actions based on the food type or amount
        // For example, updating the pet's attributes or triggering specific behaviors.



