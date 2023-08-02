import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Virtual Pet Shelter!");

        Map<String, VirtualPet> petShelter = new HashMap<>();

        // Adding sample pets to the shelter
        VirtualPet wyatt = new VirtualPet("Wyatt", "Dog");
        VirtualPet snickers = new VirtualPet("Snickers", "Cat");
        VirtualPet ghost = new VirtualPet("Ghost", "Dog");
        VirtualPet kanen = new VirtualPet("Kanen", "Dog");
        VirtualPet boomer = new VirtualPet("Boomer", "Cat");
        VirtualPet larry = new VirtualPet("Larry", "Lizard");
        VirtualPet ruby = new VirtualPet("Ruby", "Bird");
        VirtualPet tony = new VirtualPet("Tony", "Tiger");

        petShelter.put(wyatt.getName(), wyatt);
        petShelter.put(snickers.getName(), snickers);
        petShelter.put(ghost.getName(), ghost);
        petShelter.put(kanen.getName(), kanen);
        petShelter.put(boomer.getName(), boomer);
        petShelter.put(larry.getName(),larry);
        petShelter.put(ruby.getName(), ruby);
        petShelter.put(tony.getName(), tony);

        boolean adopted = false;
        int choice;

        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed a pet");
            System.out.println("2. Play with a pet");
            System.out.println("3. Give water to a pet");
            System.out.println("4. Let dogs go potty");
            System.out.println("5. Check a pet's status");
            System.out.println("6. Donate a new pet to the shelter");
            System.out.println("7. Search pet by type and name");
            System.out.println("8. Display all animals in the shelter");
            System.out.println("9. Take a pet to the vet");
            System.out.println("10. Adopt a pet");
            System.out.println("11. Put pets to sleep");
            System.out.println("12. Groom Pets");
            System.out.println("13. Exit Shelter");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after reading the integer

            switch (choice) {
                case 1:
                    feedPet(scanner, petShelter);
                    break;
                case 2:
                    playWithPet(scanner, petShelter);
                    break;
                case 3:
                    giveWaterToPet(scanner, petShelter);
                    break;
                case 4:
                    letDogsGoPotty(petShelter);
                    break;
                case 5:
                    checkPetStatus(scanner, petShelter);
                    break;
                case 6:
                    donateNewPet(scanner, petShelter);
                    break;
                case 7:
                    searchPet(scanner, petShelter);
                    break;
                case 8:
                    displayAllPets(petShelter);
                    break;
                case 9:
                    takePetToVet(scanner, petShelter);
                    break;
                case 10:
                    adoptNewPet(scanner, petShelter);
                    adopted = true; // Mark that an adoption has been made
                    break;
                    case 11:
                    putAllPetsToSleepByType(scanner, petShelter);
                    break;                
                    case 12:
                    groomPets(scanner, petShelter);
                    break;
                    case 13:
                    System.out.println("Thank you for visiting the Virtual Pet Shelter!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (adopted) {
                displayAllPets(petShelter); // Display the updated list of pets after adoption
                adopted = false; // Reset the adoption flag for the next iteration
            }

            tickAllPets(petShelter);

        } while (choice != 13);

        scanner.close();
    }


    private static void letDogsGoPotty(Map<String, VirtualPet> petShelter) {
        System.out.println("\nYou let the dogs and tigers go potty.");
        for (VirtualPet pet : petShelter.values()) {
            if (pet.getType().equalsIgnoreCase("dog") || pet.getType().equalsIgnoreCase("tiger")) {
                pet.goPotty();
            }
        }
    }
    

    private static void feedPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the pet you want to feed: ");
        String petName = scanner.next();
        VirtualPet pet = petShelter.get(petName);
        if (pet != null) {
            pet.feed();
            if (pet.getType().equalsIgnoreCase("dog")) {
                // Print the dog image only if the pet is a dog
                System.out.println("            Wag  _,) WaG\r\n" + 
                        "        _..._.-;-'\r\n" + 
                        "     .-'     `(\r\n" + 
                        "    /      ;   \\\r\n" + 
                        "   ;.' ;`  ,;  ;\r\n" + 
                        "  .'' ``. (  \\ ;\r\n" + 
                        " / f_ _L \\ ;  )\\\r\n" + 
                        " \\/|` '|\\/;; <;/\r\n" + 
                        "((; \\_/  (()       BaRk BaRK!\r\n" + 
                        "     \" 8====8");
            } else if(pet.getType().equalsIgnoreCase("cat")){
                System.out.println("        _..---...,\"\"-._     ,/}/)\r\n" + //
                        "     .''        ,      ``..'(/-<\r\n" + //
                        "    /   _      {      )         \\\r\n" + //
                        "   ;   _ `.     `.   <         a(\r\n" + //
                        " ,'   ( \\  )      `.  \\ __.._ .: y\r\n" + //
                        "(  <\\_-) )'-.____...\\  `._   //-' ><_>\r\n" + //
                        " `. `-' /-._)))      `-._)))\r\n" +
                        "   `...'         MeOw MeOw!");
            } else if ( pet.getType().equalsIgnoreCase("lizard")){
                System.out.println("                      )/_\r\n" + //
                        "               _.--..---\"-,--0_\r\n" + //
                        "          \\L..'           ._0__)_____ 8\r\n" + //
                        "  ,-.     _.+  _  \\..--( /           \r\n" + //
                        "    `\\.-''__.-' \\ (     \\_      \r\n" + //
                        "      `'''       `\\__   /\\\r\n" + //
                        "                  ')");
            } else if (pet.getType().equalsIgnoreCase("bird")){
                System.out.println(" ,`````.          _________\r\n" + //
                        "' WhOO!  `,      /_  ___   \\\r\n" + //
                        "'         `.    /@ \\/@  \\   \\\r\n" + //
                        " ` , . , '  `.. \\__/\\___/   /\r\n" + //
                        "                 \\_\\/______/\r\n" + //
                        "                  /     /\\\\\\\\\\\r\n" + //
                        "                 |     |\\\\\\\\\\\\\r\n" + //
                        "                 \\      \\\\\\\\\\\\\r\n" + //
                        "                  \\______/\\\\\\\\   \r\n" + //
                        " ()()        _______ ||_||_______\r\n" +
                        " (..)       (______(((_(((______(@)" );
            } else if (pet.getType().equalsIgnoreCase("tiger")){
                System.out.println("     (^\\-==-/^)\r\n" + //
                        "     >\\\\ == //<\r\n" + //
                        "    :== q''p ==:     _\r\n" + //
                        "     .__ qp __.    .' )\r\n" + //
                        "      / ^--^ \\    /\\.'\r\n" + //
                        "     /_`    / )  '\\/\r\n" + //
                        "     (  )  \\  |-'-/\r\n" + //
                        "     \\^^,   |-|--'\r\n" + //
                        "    ( `'    |_| )\r\n" + //
                        "     \\-     |-|/\r\n" + //
                        "    (( )^---( )) RoARRR!!!");
            }
        } else {
            System.out.println("Pet not found in the shelter with the given name.");
        }
    }
    

    // Play with a specific pet
    private static void playWithPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the pet you want to play with: ");
        String petName = scanner.next();
        VirtualPet pet = petShelter.get(petName);
        if (pet != null) {
            pet.play();
        } else {
            System.out.println("Pet not found in the shelter with the given name.");
        }
    }

    private static void giveWaterToPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the pet you want to give water to: ");
        String petName = scanner.next();
        VirtualPet pet = petShelter.get(petName);
        if (pet != null) {
            pet.giveWater();
        } else {
            System.out.println("Pet not found in the shelter with the given name.");
        }
    }
    
    private static void putAllPetsToSleepByType(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the 'type' of the pet (type 'all' to put all pets to sleep): ");
        String petType = scanner.next().toLowerCase();
    
        if (petType.equalsIgnoreCase("all")) {
            for (VirtualPet pet : petShelter.values()) {
                pet.putToSleep(8); // Assuming 8 hours of sleep for all pets
            }
            System.out.println("You've locked down the cages, and all animals are asleep.");
        } else {
            int count = 0;
            for (VirtualPet pet : petShelter.values()) {
                if (pet.getType().equalsIgnoreCase(petType)) {
                    pet.putToSleep(8); // Assuming 8 hours of sleep for specific pet type
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("All " + petType + "s are asleep.");
            } else {
                System.out.println("No " + petType + " found in the shelter.");
            }
        }
    }
    


    
    private static void checkPetStatus(Scanner scanner, Map<String, VirtualPet> petShelter) {
    System.out.print("Enter the name of the pet you want to check (type 'all' for all pets): ");
    String petName = scanner.nextLine().trim(); // Use nextLine() to read the whole line and trim whitespaces

    if (petName.equalsIgnoreCase("all")) {
        displayAllPetStatuses(petShelter);
    } else {
        VirtualPet pet = petShelter.get(petName);
        if (pet != null) {
            pet.checkStatus();
        } else {
            System.out.println("Pet not found in the shelter with the given name.");
        }
    }
}

private static void displayAllPetStatuses(Map<String, VirtualPet> petShelter) {
    System.out.println("\n|----- All Pets' Statuses -----|");
    System.out.println(String.format("%-8s| %-7s| %-7s| %-8s| %-7s| %-7s| %-7s", "Name", "Hunger", "Thirst", "Boredom", "Health", "Energy", "Hygiene"));
    System.out.println("--------|-------|-------|--------|--------|--------|--------");

    for (VirtualPet pet : petShelter.values()) {
        String name = pet.getName();
        int hunger = pet.getHunger();
        int thirst = pet.getThirst();
        int happiness = pet.getHappiness();
        int health = pet.getHealth();
        int sleep = pet.getSleep();
        int hygiene = pet.getHygiene();

        System.out.println(String.format("%-8s| %-7d| %-7d| %-8d| %-7d| %-7d| %-7d", name, hunger, thirst, happiness, health, sleep, hygiene));
    }

    System.out.println("|----------------------------|");
}


    private static void takePetToVet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the pet you want to take to the vet: ");
        String petName = scanner.next();
        VirtualPet pet = petShelter.get(petName);
        if (pet != null) {
            pet.takeToVet();
            petShelter.put(petName, pet);
            System.out.println(petName + "'s health has been increased to " + pet.getHealth() + ".");
        } else {
            System.out.println("Pet not found in the shelter with the given name.");
        }
    } 

    private static void groomPets(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type or name of the pet you want to groom: ");
        String input = scanner.next();
    
        boolean isType = false;
    
        // Check if the input is a type
        for (VirtualPet pet : petShelter.values()) {
            if (pet.getType().equalsIgnoreCase(input)) {
                isType = true;
                break;
            }
        }
    
        if (isType) {
            // Groom all pets of the specified type
            for (VirtualPet pet : petShelter.values()) {
                if (pet.getType().equalsIgnoreCase(input)) {
                    showGroomingMenu(scanner, pet); // Show grooming menu for each pet of the specified type
                }
            }
        } else {
            // Groom the specific pet by name
            VirtualPet pet = petShelter.get(input);
            if (pet != null) {
                showGroomingMenu(scanner, pet); // Show grooming menu for the specific pet
            } else {
                System.out.println("Pet not found in the shelter with the given type or name.");
            }
        }
    }

    
    private static void adoptNewPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type of the pet (dog, cat, lizard, bird): ");
        String petType = scanner.next().toLowerCase(); // Convert to lowercase for consistent comparison
        System.out.print("Enter the name of the pet: ");
        String petName = scanner.next();
        String key = petName; // Combine pet name and type as the key in the map
        VirtualPet adoptedPet = petShelter.remove(key);
    
        if (adoptedPet != null) {
            System.out.println("Congratulations on adopting " + petName + " the " + petType + "!");
            System.out.print("Please enter the adopter's name: ");
            String adopterName = scanner.next();
            System.out.print("Please enter the adopter's phone number: ");
            String phoneNumber = scanner.next();
            System.out.print("Please enter the adopter's address: ");
            String address = scanner.next();
    
            displayAdoptionPaperwork(adopterName, phoneNumber, address, adoptedPet);
    
            System.out.println("Thank you for adopting " + petName + "!");
        } else {
            System.out.println("Pet not found in the shelter with the given type and name.");
        }
        scanner.nextLine();
    }
    
    private static void showGroomingMenu(Scanner scanner, VirtualPet pet) {
        boolean grooming = true;
    
        while (grooming) {
            System.out.println("\nGrooming Options for " + pet.getName() + ":");
            System.out.println("A. Brush pet's fur");
            System.out.println("B. Clip pet's nails");
            System.out.println("C. Give pet a bath");
            System.out.println("D. Give pet a treat");
            System.out.println("E. Exit grooming");
    
            System.out.print("Select grooming option: ");
            String option = scanner.next().toUpperCase();
    
            switch (option) {
                case "A":
                    System.out.println(pet.getName() + " has been brushed.");
                    // Perform brushing operation on the pet (add or subtract attributes as needed)
                    pet.setHappiness(pet.getHappiness() + 5);
                    pet.setHygiene(pet.getHygiene() + 2);
                    break;
                case "B":
                    System.out.println(pet.getName() + "'s nails have been clipped.");
                    pet.setHygiene(pet.getHygiene() + 2);
                    break;
                case "C":
                    System.out.println(pet.getName() + " has taken a bath.");
                    pet.setHealth(pet.getHealth() + 2);
                    pet.setHygiene(pet.getHygiene() + 4);
                    break;
                case "D":
                    System.out.println(pet.getName() + " has been given a treat.");
                    pet.setHunger(pet.getHunger() - 5);
                    break;
                case "E":
                    System.out.println("Exiting grooming for " + pet.getName() + ".");
                    grooming = false;
                    break;
                default:
                    System.out.println("Invalid grooming option.");
                    break;
            }
        }
    }
    

    private static void displayAdoptionPaperwork(String adopterName, String phoneNumber, String address, VirtualPet adoptedPet) {
        System.out.println("\n|--- Adoption Paperwork ---|");
        System.out.println("Adopter's Name: " + adopterName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Adopted Pet: " + adoptedPet.getType() + " named " + adoptedPet.getName());
        System.out.println("|----------------------------|");
    }


    private static void donateNewPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type of pet (dog, cat, lizard, bird): ");
        String petType = scanner.next().toLowerCase(); // Convert to lowercase for consistent key format
        System.out.print("Enter the name of the pet: ");
        String petName = scanner.next();
        String key = petName + ":" + petType; // Combine pet name and type as the key in the map
        VirtualPet newPet = new VirtualPet(petName, petType);
        petShelter.put(key, newPet);
        System.out.println("You donated a new " + petType + " named " + petName + ".");
    }

    private static void searchPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type of the pet: ");
        String petType = scanner.next();
        System.out.print("Enter the name of the pet: ");
        String petName = scanner.next();
        
        
        VirtualPet pet = petShelter.get(petName);
        if (pet != null && pet.getType().equalsIgnoreCase(petType)) {
            System.out.println("\n|----- " + pet.getName() + "'s Status -----|");
            System.out.println("Type: " + pet.getType());
            System.out.println("Hunger: " + pet.getHunger());
            System.out.println("Happiness: " + pet.getHappiness());
            System.out.println("Thirst: " + pet.getThirst());
            System.out.println("Health: " + pet.getHealth());
            System.out.println("Sadness: " + pet.getSadness());
            System.out.println("Energy: " + pet.getSleep());
            System.out.println("Hygiene: " + pet.getHygiene());
            System.out.println("|--------------------------|");
        } else {
            System.out.println("Pet not found in the shelter with the given type and name.");
        }
    }

    private static void displayAllPets(Map<String, VirtualPet> petShelter) {
        System.out.println("\n|----- All Animals in the Shelter! -----|");
        for (VirtualPet pet : petShelter.values()) {
            System.out.println("Type: " + pet.getType() + "    " + "Name: " + pet.getName());
        }
        System.out.println("|-----------------------------------------|");
    }

    private static void tickAllPets(Map<String, VirtualPet> petShelter) {
        for (VirtualPet pet : petShelter.values()) {
            pet.tick();
        }
    }
    
}



