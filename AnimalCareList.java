import java.util.ArrayList;
import java.util.List;

public class AnimalCareList {

    private List<VirtualPet> itemsForPet = new ArrayList<>();

    public void addItemsForPet(VirtualPet pet){
        itemsForPet.add(pet);
    }

    public List<VirtualPet> getFreshFood(){
        return itemsForPet;
    }

    public void removeType(String type){
        for (int i = 0; i < itemsForPet.size(); i++){
            if (itemsForPet.get(i).getType().equals(type)){
                itemsForPet.remove(i);
                i--;
            }
        }
    }

    public int getType(String type){
        int results = 0;
        for(int i = 0; i < itemsForPet.size(); i++){
            if (itemsForPet.get(i).getType().equals(type)){
                results = itemsForPet.get(i).getFood();
            }
        }
    return results;
}

    public List<VirtualPet> getFood(){
        return itemsForPet;
    }

    @Override
    public String toString(){
        return "AnimalCareList [itemsForPet=" + itemsForPet + "]";
    }

    public VirtualPet getPetByType(String type) {
        for (VirtualPet pet : itemsForPet) {
            if (pet.getType().equalsIgnoreCase(type)) {
                return pet;
            }
        }
        return null; // Pet with the specified type not found
    }
    

}
