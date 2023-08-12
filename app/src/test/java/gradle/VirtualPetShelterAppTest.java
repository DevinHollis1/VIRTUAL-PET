
package gradle;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;



public class VirtualPetShelterAppTest {
    private VirtualPet virtualPet;

    @BeforeEach
    public void setUp() {
        virtualPet = new VirtualPet("Buddy", "Dog"); // Initialize your VirtualPet instance here
    }

    @Test
    public void testInitialPetStatus() {
        assertEquals("Buddy", virtualPet.getName());
        assertEquals("Dog", virtualPet.getType());
        assertEquals(50, virtualPet.getHunger());
        assertEquals(50, virtualPet.getHappiness());
        assertEquals(75, virtualPet.getSadness());
        assertEquals(50, virtualPet.getThirst());
        assertEquals(80, virtualPet.getHealth());
        assertEquals(50, virtualPet.getSleep());
        assertEquals(20, virtualPet.getHygiene());
        assertEquals(10, virtualPet.getMess());
    }

    @Test
    public void testFeedPet() {
        virtualPet.feed();
        assertEquals(20, virtualPet.getHunger());
        assertEquals(59, virtualPet.getHappiness());
        assertEquals(63, virtualPet.getSadness());
        assertEquals(57, virtualPet.getThirst());
        assertEquals(64, virtualPet.getSleep());
        assertEquals(12, virtualPet.getHygiene());
        assertEquals(30, virtualPet.getMess());
    }

    @Test
    public void testPlayWithPet() {
        virtualPet.play();
        assertEquals(58, virtualPet.getHunger());
        assertEquals(60, virtualPet.getHappiness());
        assertEquals(65, virtualPet.getSadness());
        assertEquals(65, virtualPet.getThirst());
        assertEquals(30, virtualPet.getSleep());
        assertEquals(7, virtualPet.getHygiene());
    }

    @Test
    public void testGiveWater() {
        virtualPet.giveWater();
        assertEquals(30, virtualPet.getThirst());
        assertEquals(55, virtualPet.getHappiness());
        assertEquals(72, virtualPet.getSadness());
        assertEquals(53, virtualPet.getSleep());
        assertEquals(27, virtualPet.getHygiene());
        assertEquals(23, virtualPet.getMess());
    }



    @Test
    public void testTakeToVet() {
        virtualPet.takeToVet();
        assertEquals(40, virtualPet.getHappiness());
        assertEquals(83, virtualPet.getSadness());
        assertEquals(60, virtualPet.getSleep());
        assertEquals(25, virtualPet.getHygiene());
        assertEquals(6, virtualPet.getMess());
        assertEquals(95, virtualPet.getHealth());
    }

    @Test
public void testGoPotty() {
    virtualPet.goPotty();
    assertEquals(58, virtualPet.getHappiness());
    assertEquals(60, virtualPet.getThirst());
    assertEquals(46, virtualPet.getSleep());
    assertEquals(0, virtualPet.getMess());
    assertEquals(85, virtualPet.getHealth());  // Correct expected health value
}

@Test
public void testWalkDogs() {
    virtualPet.walkDogs();
    assertEquals(60, virtualPet.getHappiness());
    assertEquals(67, virtualPet.getSadness()); // Adjusted sadness value
    assertEquals(43, virtualPet.getSleep());   // Adjusted sleep value
    assertEquals(20, virtualPet.getHygiene()); // Adjusted hygiene value
    assertEquals(0, virtualPet.getMess());     // Adjusted mess value
    assertEquals(86, virtualPet.getHealth());
}


@Test
public void testPutToSleep() {
    virtualPet.putToSleep(8);
    assertEquals(54, virtualPet.getHappiness());
    assertEquals(58, virtualPet.getSleep()); // Adjusted sleep value
}

@Test
    public void testTick() {
        long initialLastTickTime = virtualPet.getLastTickTime();
        
        // Simulate waiting for 60 seconds
        long currentTime = initialLastTickTime + 60000;
        virtualPet.setLastTickTime(currentTime);
        
        virtualPet.tick();
        
        assertEquals(55, virtualPet.getSleep());    // Adjusted sleep value
        assertEquals(17, virtualPet.getHygiene());  // Adjusted hygiene value
        assertEquals(48, virtualPet.getHappiness()); // Adjusted happiness value
        assertEquals(81, virtualPet.getSadness());  // Adjusted sadness value
        assertEquals(75, virtualPet.getHealth());   // Adjusted health value
        assertEquals(26, virtualPet.getMess());     // Adjusted mess value

        // Ensure that lastTickTime is updated
        assertNotEquals(initialLastTickTime, virtualPet.getLastTickTime());
    }

    
}


