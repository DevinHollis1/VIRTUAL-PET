import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Virtual Pet Paradise!");

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
        VirtualPet robocat = new VirtualPet("RoboCat", "Robot");
        VirtualPet robodog = new VirtualPet("RoboDog", "Robot");

        petShelter.put(wyatt.getName().toLowerCase(), wyatt);
        petShelter.put(snickers.getName().toLowerCase(), snickers);
        petShelter.put(ghost.getName().toLowerCase(), ghost);
        petShelter.put(kanen.getName().toLowerCase(), kanen);
        petShelter.put(boomer.getName().toLowerCase(), boomer);
        petShelter.put(larry.getName().toLowerCase(), larry);
        petShelter.put(ruby.getName().toLowerCase(), ruby);
        petShelter.put(tony.getName().toLowerCase(), tony);
        // Create Robot pets
        petShelter.put(robocat.getName().toLowerCase(), (VirtualPet) robocat);
        petShelter.put(robodog.getName().toLowerCase(), (VirtualPet) robodog);

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
            System.out.println("7. Take dogs for a walk");
            System.out.println("8. Display all animals in the shelter");
            System.out.println("9. Take a pet to the vet");
            System.out.println("10. Adopt a pet");
            System.out.println("11. Put pets to sleep");
            System.out.println("12. Groom Pets");
            System.out.println("13. Robot animal care");
            System.out.println("14. Clean animal cages");
            System.out.println("15. Exit Pet Paradise");
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
                    walkDogs(scanner, petShelter);
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
                    robotAnimalCare(scanner, petShelter);
                    break;
                    case 14:
                    cleanCages(scanner, petShelter);
                    break;
                    case 15:
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

        } while (choice != 15);

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
        System.out.print("Enter the name or type of the pet you want to feed: ");
        String input = scanner.next().toLowerCase();
    
        VirtualPet pet = petShelter.get(input);
    
        if (pet != null) {
            if (pet.getType().equalsIgnoreCase("robot")) {
                System.out.println("You cannot feed a robot pet.");
                return; // Exit the method immediately
            }
            pet.feed();
            if (pet.getType().equalsIgnoreCase("dog")) {
                // Print the dog image only if the pet is a dog
                System.out.println("                _,) \r\n" + 
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
                System.out.println("        _..---...,\"\"-._     ,/}/)\r\n" + 
                        "     .''        ,      ``..'(/-<\r\n" + 
                        "    /   _      {      )         \\\r\n" + 
                        "   ;   _ `.     `.   <         a(\r\n" + 
                        " ,'   ( \\  )      `.  \\ __.._ .: y\r\n" + 
                        "(  <\\_-) )'-.____...\\  `._   //-' ><_>\r\n" + 
                        " `. `-' /-._)))      `-._)))\r\n" +
                        "   `...'         MeOw MeOw!");
            } else if ( pet.getType().equalsIgnoreCase("lizard")){
                System.out.println("                      )/_\r\n" + 
                        "               _.--..---\"-,--0_\r\n" + 
                        "          \\L..'           ._0__)_____ 8\r\n" + 
                        "  ,-.     _.+  _  \\..--( /           \r\n" + 
                        "    `\\.-''__.-' \\ (     \\_      \r\n" + 
                        "      `'''       `\\__   /\\\r\n" + 
                        "                  ')");
            } else if (pet.getType().equalsIgnoreCase("bird")){
                System.out.println(" ,`````.          _________\r\n" + 
                        "' WhOO!  `,      /_  ___   \\\r\n" + 
                        "'         `.    /@ \\/@  \\   \\\r\n" + 
                        " ` , . , '  `.. \\__/\\___/   /\r\n" + 
                        "                 \\_\\/______/\r\n" + 
                        "                  /     /\\\\\\\\\\\r\n" + 
                        "                 |     |\\\\\\\\\\\\\r\n" + 
                        "                 \\      \\\\\\\\\\\\\r\n" + 
                        "                  \\______/\\\\\\\\   \r\n" + 
                        " ()()        _______ ||_||_______\r\n" +
                        " (..)       (______(((_(((______(@)" );
            } else if (pet.getType().equalsIgnoreCase("tiger")){
                System.out.println("     (^\\-==-/^)\r\n" + 
                        "     >\\\\ == //<\r\n" + 
                        "    :== q''p ==:     _\r\n" + 
                        "     .__ qp __.    .' )\r\n" + 
                        "      / ^--^ \\    /\\.'\r\n" + 
                        "     /_`    / )  '\\/\r\n" + 
                        "     (  )  \\  |-'-/\r\n" + 
                        "     \\^^,   |-|--'\r\n" + 
                        "    ( `'    |_| )\r\n" + 
                        "     \\-     |-|/\r\n" + 
                        "    (( )^---( )) RoARRR!!!");
            }
        } else {
            // If the input is not a pet's name, try feeding pets of the specified type
            for (VirtualPet p : petShelter.values()) {
                if (!p.getType().equalsIgnoreCase("robot") && p.getType().equalsIgnoreCase(input)) {
                    p.feed();
                }
            }
        }
    }
    

    // Play with a specific pet
    private static void playWithPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the pet you want to play with: ");
        String petName = scanner.next().toLowerCase();
    
        VirtualPet pet = petShelter.get(petName);
    
        if (pet != null) {
            pet.play();
        } else {
            // If the input is not a pet's name, try playing with pets of the specified type
            for (VirtualPet p : petShelter.values()) {
                if (!p.getType().equalsIgnoreCase("robot") && p.getName().equalsIgnoreCase(petName)) {
                    p.play();
                }
            }
        }
    }
    

    private static void giveWaterToPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name or type of the pet you want to give water to: ");
        String input = scanner.next().toLowerCase();
    
        VirtualPet pet = petShelter.get(input);
    
        if (pet != null) {
            if (pet.getType().equalsIgnoreCase("robot")) {
                System.out.println("You cannot give water to a robot pet.");
                return; // Exit the method immediately
            }
    
            pet.giveWater();
        } else {
            // If the input is not a pet's name, try giving water to pets of the specified type
            for (VirtualPet p : petShelter.values()) {
                if (!p.getType().equalsIgnoreCase("robot") && p.getName().equalsIgnoreCase(input)) {
                    p.giveWater();
                }
            }
        }
    }
    
    
    private static void putAllPetsToSleepByType(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the 'type' of the pet (type 'all' to put all pets to sleep): ");
        String petType = scanner.next().toLowerCase();
    
        if (petType.equalsIgnoreCase("all")) {
            for (VirtualPet pet : petShelter.values()) {
                pet.putToSleep(8); // 8 hours of sleep for all pets
            }
            System.out.println("You've locked down the cages, all animals are asleep and charging.");
        } else {
            int count = 0;
            for (VirtualPet pet : petShelter.values()) {
                if (pet.getType().equalsIgnoreCase(petType)) {
                    pet.putToSleep(8); // 8 hours of sleep for specific pet type
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("All " + petType + " animals have been charged for 8 hours.");
            } else {
                // Check if there are any donated pets of the specified type
                for (VirtualPet pet : petShelter.values()) {
                    if (!pet.getType().equalsIgnoreCase("robot") && pet.getType().equalsIgnoreCase(petType)) {
                        pet.putToSleep(8); // 8 hours of sleep for specific donated pet type
                        System.out.println(pet.getName() + "' has been charged for 8 hours.");
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("No " + petType + " found in the shelter.");
                }
            }
        }
    }

    private static void cleanCages(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type of animal whose cage needs to be cleaned (or 'all' to clean all cages): ");
        String input = scanner.next().toLowerCase();
        
        if (input.equals("all")) {
            cleanAllCages(petShelter);
        } else {
            cleanCagesByType(input, petShelter);
        }
    }
    
    private static void cleanAllCages(Map<String, VirtualPet> petShelter) {
        System.out.println("Cleaning all cages and litter boxes...");
        for (VirtualPet pet : petShelter.values()) {
            if (!pet.getType().equalsIgnoreCase("robot")) {
                if (pet.getType().equalsIgnoreCase("cat")) {
                    pet.setHygiene(pet.getHygiene() + 20); // Cleaning the litter box for cats
                }
                pet.setHygiene(pet.getHygiene() + 20); // Cleaning the cage
                pet.setMess(pet.getMess() - 50); // Decrease the mess attribute by 50
            }
        }
    }
    
    
    private static void cleanCagesByType(String type, Map<String, VirtualPet> petShelter) {
        int count = 0;
        for (VirtualPet pet : petShelter.values()) {
            if (!pet.getType().equalsIgnoreCase("robot") && pet.getType().equalsIgnoreCase(type)) {
                if (type.equalsIgnoreCase("cat")) {
                    pet.setHygiene(pet.getHygiene() + 20); // Cleaning the litter box for cats
                }
                pet.setHygiene(pet.getHygiene() + 20); // Cleaning the cage
                pet.setMess(pet.getMess() - 50); // Decrease the mess attribute by 50
                count++;
            }
        }
        
        if (count > 0) {
            System.out.println("Cages for " + type + " animals have been cleaned.");
        } else {
            System.out.println("Robot animals cages are always clean.");
        }
    }

    
    private static void checkPetStatus(Scanner scanner, Map<String, VirtualPet> petShelter) {
    System.out.print("Enter the name of the pet you want to check (type 'all' for all pets): ");
    String petName = scanner.nextLine().trim(); // Use nextLine() to read the whole line.

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
    System.out.println("\n|------------------------------- All Organic Pets' Statuses -------------------------------|\n");
    System.out.println(String.format("%-8s| %-7s| %-7s| %-8s|%-8s| %-7s| %-7s| %-7s| %-7s| %-7s|", "Name", "Type", "Hunger", "Thirst", "Happiness", "Sadness", "Health", "Energy", "Hygiene", "Mess"));
    System.out.println("--------|--------|--------|---------|---------|--------|--------|--------|--------|--------|");

    for (VirtualPet pet : petShelter.values()) {
        if (!pet.getType().equalsIgnoreCase("robot")) {
            String name = pet.getName();
            String type = pet.getType();
            int hunger = pet.getHunger();
            int thirst = pet.getThirst();
            int happiness = pet.getHappiness();
            int sadness = pet.getSadness();
            int health = pet.getHealth();
            int energy = pet.getSleep(); // energy is equivalent to sleep for organic pets
            int hygiene = pet.getHygiene();
            int mess = pet.getMess();

            System.out.println(String.format("%-8s| %-7s| %-7d| %-8d| %-8d| %-7d| %-7d| %-7d| %-7d| %-7d|", name, type, hunger, thirst, happiness, sadness, health, energy, hygiene, mess));
        }
    }

    System.out.println("\n|----------------------------------- Robot Pets' Statuses ---------------------------------|\n");
    System.out.println(String.format("%-8s| %-7s| %-8s|%-8s| %-8s| %-7s| %-7s|", "Name", "Type", "Updates", "Happiness", "Sadness", "Battery", "Rust"));
    System.out.println("--------|--------|---------|---------|---------|--------|--------|");

    for (VirtualPet pet : petShelter.values()) {
        if (pet.getType().equalsIgnoreCase("robot")) {
            String name = pet.getName();
            String type = pet.getType();
            int health = pet.getHealth();
            int happiness = pet.getHappiness();
            int sadness = pet.getSadness();
            int energy = pet.getSleep();
            int hygiene = pet.getHygiene();

            System.out.println(String.format("%-8s| %-7s| %-8d| %-8d| %-8d| %-7d| %-7d|", name, type, health, happiness, sadness, energy, hygiene));
        }
    }

    System.out.println("\n|------------------------------------------------------------------------------------------|");
}





private static void takePetToVet(Scanner scanner, Map<String, VirtualPet> petShelter) {
    System.out.print("Enter the name of the pet you want to take to the vet: ");
    String petName = scanner.next();
    VirtualPet pet = petShelter.get(petName);
    
    if (pet != null) {
        if (pet.getType().equalsIgnoreCase("robot")) {
            System.out.println("You cannot take a robot pet to the vet.");
            return; // Exit the method immediately
        }
        
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
        System.out.print("Enter the type of the pet (dog, cat, lizard, bird, robot): ");
        String petType = scanner.next().toLowerCase(); // Convert to lowercase for consistent comparison
        System.out.print("Enter the name of the pet: ");
        String petName = scanner.next().toLowerCase();
        String key = petName.toLowerCase(); // pet name as the key in the map
        VirtualPet adoptedPet = petShelter.remove(key);
    
        if (adoptedPet != null) {
            System.out.println("Congratulations on adopting " + petName + " the " + petType + "!");
            System.out.print("Please enter the adopter's first name: ");
            String adopterFirstName = scanner.next();
            System.out.print("Please enter the adopter's last name: ");
            String adopterLastName = scanner.next();
            System.out.print("Please enter the adopter's phone number(XXX-XXX-XXX): ");
            String phoneNumber = scanner.next();
            System.out.print("Please enter the adopter's address(ex:1234): ");
            String address = scanner.next();
            System.out.print("Please enter the adopter's street(ex:Tucker): ");
            String street = scanner.next();
    
            displayAdoptionPaperwork(adopterFirstName, adopterLastName, phoneNumber, address, street, adoptedPet);
    
            System.out.println("Thank you for adopting " + petName + "!");
        } else {
            System.out.println("Pet not found in the shelter with the given type and name.");
        }
        scanner.nextLine();
    }

    private static void displayAdoptionPaperwork(String adopterFirstName, String adoptersLastName, String phoneNumber, String address, String street, VirtualPet adoptedPet) {
        System.out.println("\n|--- Adoption Paperwork ---|");
        System.out.println("Adopter's Name: " + adopterFirstName + " " + adoptersLastName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address + " " + street);
        System.out.println("Adopted Pet: " + adoptedPet.getType() + " named " + adoptedPet.getName());
        System.out.println("|---------------------------|");
    }
    
    private static void showGroomingMenu(Scanner scanner, VirtualPet pet) {
        boolean grooming = true;

        if (pet.getType().equalsIgnoreCase("robot")) {
            System.out.println("You cannot perform this action on a robot pet.");
            return; // Exit the method immediately
        }
        
        while (grooming) {
            System.out.println("\nGrooming Options for " + pet.getName() + ":");
            System.out.println("A. Brush " + pet.getName() + " fur");
            System.out.println("B. Clip " + pet.getName() + " nails");
            System.out.println("C. Give " + pet.getName() + " a bath");
            System.out.println("D. Give " + pet.getName() + " a treat");
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
                    pet.setHygiene(pet.getHygiene() + 40);
                    break;
                case "D":
                    System.out.println(pet.getName() + " has been given a treat.");
                    pet.setHunger(pet.getHunger() - 10);
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
    
    private static void robotAnimalCare(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the name of the robot pet you want to take care of: ");
        String petName = scanner.next().toLowerCase();
        VirtualPet pet = petShelter.get(petName);
        
        if (pet != null && pet.getType().equalsIgnoreCase("robot")) {
            showRobotCareMenu(scanner, pet); // Show robot care menu for the specific robot pet
        } else if (pet != null) {
            System.out.println("You can only perform robot care on robot pets.");
        } else {
            System.out.println("Robot pet not found in the shelter with the given name.");
        }
    }
    
    private static void showRobotCareMenu(Scanner scanner, VirtualPet robotPet) {
        boolean caring = true;
    
        while (caring) {
            System.out.println("\nRobot Care Options for " + robotPet.getName() + ":");
            System.out.println("A. Give " + robotPet.getName() + " oil");
            System.out.println("B. Give" + robotPet.getName() + "an update");
            System.out.println("C. Clean the " + robotPet.getName() + " components");
            System.out.println("D. Charge " + robotPet.getName());
            System.out.println("E. Exit robot care");
    
            System.out.print("Select robot care option: ");
            String option = scanner.next().toUpperCase();
    
            switch (option) {
                case "A":
                    System.out.println(robotPet.getName() + " has been oiled.");
                    // Perform oiling operation on the robot (add or subtract attributes as needed)
                    robotPet.setHappiness(robotPet.getHappiness() + 2);
                    robotPet.setSleep(robotPet.getSleep() + 10);
                    break;
                case "B":
                    System.out.println(robotPet.getName() + " has been given updates.");
                    robotPet.setHappiness(robotPet.getHappiness() + 3);
                    break;
                case "C":
                    System.out.println(robotPet.getName() + " has been cleaned.");
                    robotPet.setHygiene(robotPet.getHygiene() + 4);
                    break;
                case "D":
                    System.out.println(robotPet.getName() + " has been charged.");
                    robotPet.setSleep(robotPet.getSleep() + 20);
                    break;
                case "E":
                    System.out.println("Exiting robot care for " + robotPet.getName() + ".");
                    caring = false;
                    break;
                default:
                    System.out.println("Invalid robot care option.");
                    break;
            }
        }
    }

    private static void donateNewPet(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.print("Enter the type of pet (dog, cat, lizard, bird, robot): ");
        String petType = scanner.next().toLowerCase();
        System.out.print("Enter the name of the pet: ");
        String petName = scanner.next().toLowerCase();
        String key = petName.toLowerCase(); // Use pet name as the key in the map
        VirtualPet newPet = new VirtualPet(petName, petType);
        petShelter.put(key, newPet);
        System.out.println("You donated a new " + petType + " named " + petName + ".");
    }

    private static void walkDogs(Scanner scanner, Map<String, VirtualPet> petShelter) {
        System.out.println("\nYou took the dogs for a walk.");
        
        int count = 0;
        for (VirtualPet pet : petShelter.values()) {
            if (pet.getType().equalsIgnoreCase("dog")) {
                pet.walkDogs();
                count++;
            }
        }
        
        if (count > 0) {
            System.out.println("The dogs had a good time on their walk!");
        } else {
            System.out.println("No dogs found in the shelter to walk.");
        }
    }
    

    private static void displayAllPets(Map<String, VirtualPet> petShelter) {
        System.out.println("\n|----- All Animals in the Shelter! -----|");
        for (VirtualPet pet : petShelter.values()) {
            System.out.println("Type: " + pet.getType() + "    " + "Name:  " + pet.getName());
        }
        System.out.println("|----------------------------------------|");
    }

    private static void tickAllPets(Map<String, VirtualPet> petShelter) {
        for (VirtualPet pet : petShelter.values()) {
            pet.tick();
        }
    }
}



