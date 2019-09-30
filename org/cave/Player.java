package org.cave;
import java.util.*;

/*
  Spellogiken, denna styr hur spelets gång, vad som händer när man går från ett rum till ett annat
*/
public class Player {

  private ArrayList<Room> myRooms = new ArrayList<>();
  private Room currentRoom;
  private Backpack backpack;

  public Player(ArrayList<Room> myRooms)
  {
    this.myRooms = myRooms;
    this.currentRoom = myRooms.get(0); //rummen som man är i
    this.backpack = new Backpack();

    /*
    // För testning gå direkt till ett rum
    int index = Collections.binarySearch(myRooms , new Room(213));
    this.currentRoom = myRooms.get(index); //rummen som man är i
    */

    /*
    // ONLY FOR TESTING ROOM 120
    // ONLY FOR TESTING ROOM 120
    backpack.addThings(new Things(1, "Gold", true, true));
    backpack.addThings(new Things(1, "Silver", true, true));
    backpack.addThings(new Things(1, "Jewelry", true, true));
    backpack.addThings(new Things(1, "Diamonds", true, true));
    // ONLY FOR TESTING ROOM 120
    // ONLY FOR TESTING ROOM 120

    // ONLY FOR TESTING ROOM 250
    // ONLY FOR TESTING ROOM 250
    backpack.addThings(new Things(1, "Skeleton Key", true, true));
    backpack.addThings(new Things(1, "Rusty Key", true, true));
    backpack.addThings(new Things(1, "Brass Key", true, true));
    backpack.addThings(new Things(1, "Glass Key", true, true));
    // ONLY FOR TESTING ROOM 250
    // ONLY FOR TESTING ROOM 250
    */

    System.out.println("Game start in room");
    System.out.println(currentRoom);
  }

  public Room getCurrentRoom()
  {
    return currentRoom;
  }

  public Backpack getBackpack()
  {
    return backpack;
  }

  public Room goNorth()
  {
    int roomNrNorth = currentRoom.getNorth();
    if (roomNrNorth > 0){
      int index = Collections.binarySearch(myRooms , new Room(roomNrNorth));
      currentRoom = myRooms.get(index);
      System.out.println("Go north");
      //System.out.println(currentRoom.toString()); //kontroll (fungerar)
      return currentRoom;
    } else {
      System.out.println("Can't go north");
      return null;
    }
  }

  public Room goEast()
  {
    int roomNrEast = currentRoom.getEast();
    if (roomNrEast > 0){
      int index = Collections.binarySearch(myRooms , new Room(roomNrEast));
      currentRoom = myRooms.get(index);
      System.out.println("Go east");
      //System.out.println(currentRoom.toString()); //kontroll (fungerar)
      return currentRoom;
    } else {
      System.out.println("Can't go east");
      return null;
    }
  }

  public Room goSouth()
  {
    int roomNrSouth = currentRoom.getSouth();
    if (roomNrSouth > 0){
      int index = Collections.binarySearch(myRooms , new Room(roomNrSouth));
      currentRoom = myRooms.get(index);
      System.out.println("Go south");
      //System.out.println(currentRoom.toString()); //kontroll (fungerar)
      return currentRoom;
    } else {
      System.out.println("Can't go south");
      return null;
    }
  }

  public Room goWest()
  {
    int roomNrWest = currentRoom.getWest();
    if (roomNrWest > 0){
      int index = Collections.binarySearch(myRooms , new Room(roomNrWest));
      currentRoom = myRooms.get(index);
      System.out.println("Go west");
      //System.out.println(currentRoom.toString()); //kontroll (fungerar)
      return currentRoom;
    } else {
      System.out.println("Can't go west");
      return null;
    }
  }

  public String processRulesPlayEntersRoom()
  {
    if (currentRoom.getRoomId() == 13)
    {
      // Kolla om vi har staven i backpack
      if (backpack.containsThings(new Things("Rod"))) {
        // Hämta fågel i rum 13
        for (Things bird : currentRoom.getThings()) {
          if (bird.getObjectName().equals("Bird")) {
              // Ändra fågel så att den inte syns mer i rummet
            bird.setVisible(false);
            bird.setAttainable(false);
          }
        }
      }
    }

    return "";
  }

  public void processRulesAfterPickup(Things things)
  {
    if (currentRoom.getRoomId() == 10 && things.getObjectName().equals("Cage"))
    {
      // Hämta rum 13
      int roomIndex = Collections.binarySearch(myRooms , new Room(13));
      Room roomWithBird = myRooms.get(roomIndex);

      // Hämta fågel i rum 13
      for (Things bird : roomWithBird.getThings()) {
        if (bird.getObjectName().equals("Bird")) {
          // Ändra fågel så att man kan ta den
          bird.setAttainable(true);
        }
      }
    }
  }

  public String processRulesAfterDrop(Things things)
  {
    if (currentRoom.getRoomId() == 19 && things.getObjectName().equals("Bird"))
    {
      currentRoom.setSouth(29);

      return "The snake is scared by the bird and the snake is not blocking the way anymore";
    }
    else if (currentRoom.getRoomId() == 120)
    {
      boolean key1 = false;
      boolean key2 = false;
      boolean key3 = false;
      boolean key4 = false;

      for (Things keyThings : currentRoom.getThings()) {
        if (keyThings.getObjectName().equals("Gold")){
          key1 = true;
        }
        else if (keyThings.getObjectName().equals("Diamonds")){
          key2 = true;
        }
        else if (keyThings.getObjectName().equals("Jewelry")){
          key3 = true;
        }
        else if (keyThings.getObjectName().equals("Silver")){
          key4 = true;
        }
      }

      if (key1 && key2 && key3 && key4) {

        currentRoom.setWest(0);

        // Gör så att nykeln syns
        for (Things glassKey : currentRoom.getThings()) {
          if (glassKey.getObjectName().equals("Glass Key")) {
            // Ändra nyckeln så att man kan se den
            glassKey.setAttainable(true);
          }
        }

        return "A glass Key appears infront of you!";
      }
    }

    return null;
  }

  public boolean canOpenChest()
  {
    return backpack.containsThings(new Things("Glass Key"))
      && backpack.containsThings(new Things("Rusty Key"))
      && backpack.containsThings(new Things("Brass Key"))
      && backpack.containsThings(new Things("Skeleton Key"));
  }
}
