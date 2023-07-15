import java.util.ArrayList;
import java.util.List;

class AnimalCareList {
    private List<VirtualPet> food = new ArrayList<>();

    public void addItemsForPet(VirtualPet pet) {
        food.add(pet);
    }

    public List<VirtualPet> getFood() {
        return food;
    }

    public VirtualPet getPetByType(String type) {
        for (VirtualPet pet : food) {
            if (pet.getType().equalsIgnoreCase(type) && !pet.hasFedType(type)) {
                return pet;
            }
        }
        return null; // Pet with the specified type not found or already fed
    }
}