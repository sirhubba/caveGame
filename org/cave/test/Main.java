package org.cave.test;
import org.cave.*;
import org.cave.gui.*;

public class Main {

  public static void main (String args[]){

    Builder builder = new Builder();

    builder.load();

    for (Room r : builder.myRooms) {
      System.out.println(r.toString());
    }

    Player player = new Player(builder.myRooms);

    GameWindow gameWindow = new GameWindow(player); //swing fönstret

  }
}
