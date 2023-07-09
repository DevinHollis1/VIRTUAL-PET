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
        String type = scanner.nextLine();
        System.out.println("Enter the food amount in pounds: ");
        int foodAmount =  scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        VirtualPet pet = new VirtualPet(type, foodAmount);
        animalCareList.addItemsForPet(pet);
        
        if (type.equals("chicken")) {
            System.out.println("You fed Tony " + foodAmount + " pounds of chicken! \nTony says the chicken is gRRREEAT! \n");
        } else if (type.equals("steak")) {
            System.out.println("You fed Tony " + foodAmount + " pounds of steak! \nTony says the steak is gRRREEAT! \n");
        } else if (type.equals("kibble")) {
            System.out.println("You fed Tony " + foodAmount + " pounds of kibble! \nTony says he wants to hunt!");
        } else {
            System.out.println("Invalid Response: Please enter either 'chicken,' 'steak,' or 'kibble' as the food type.");
        }
        // Optional: You can perform additional actions based on the food type or amount
        // For example, updating the pet's attributes or triggering specific behaviors.
    
}
}
