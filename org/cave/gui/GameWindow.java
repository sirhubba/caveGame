package org.cave.gui;
import org.cave.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame {

  private Player player;
  private GameGui gameGui;

/*
  private JTextArea roomInfoText = new JTextArea("testste");
  private JButton goNorthBtn = new JButton("North");
  private JButton goEastBtn = new JButton("East");
  private JButton goSouthBtn = new JButton("South");
  private JButton goWestBtn = new JButton("West");
  private JButton lookObjekt = new JButton("Look");
  private JButton pickUp = new JButton("Pick-Up");
  private JButton quitGame = new JButton("Quit");
  private JButton backPack = new JButton("Backpack");
*/

  public GameWindow(Player player) {

    this.player = player;
    //	Container c = getContentPane();

    this.gameGui = new GameGui();
    add(gameGui);

    //setFonts();
    setTitle("Cave game");
    setVisible(true);
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //setSize(900, 900);

    // visa första rummet texten
    gameGui.roomInfoText.setText( this.player.getCurrentRoom().getRoomInfo() );

    // sätt en tom lista till backpackList
    gameGui.backpackList.setModel(new DefaultListModel());

    /*
    // ONLY FOR TESTING ROOM 120
    // ONLY FOR TESTING ROOM 120
    DefaultListModel listModel = new DefaultListModel();

    for (Things things : this.player.getBackpack().getBackpack()) {

      // Kolla om man ser saken
      if (things.getVisible()) {
        listModel.addElement( things );
      }
    }
    gameGui.backpackList.setModel(listModel);
    gameGui.thingsList.setModel(new DefaultListModel());
    // ONLY FOR TESTING ROOM 120
    // ONLY FOR TESTING ROOM 120
    */

    gameGui.goNorthBtn.addActionListener(goNorth);
    gameGui.goEastBtn.addActionListener(goEast);
    gameGui.goSouthBtn.addActionListener(goSouth);
    gameGui.goWestBtn.addActionListener(goWest);
    gameGui.roomInfoBtn.addActionListener(roomInfo);
    gameGui.quitBtn.addActionListener(quit);
    gameGui.helpBtn.addActionListener(help);
    gameGui.examineBtn.addActionListener(examine);
    gameGui.pickupBtn.addActionListener(pickup);
    gameGui.dropBtn.addActionListener(drop);
    gameGui.openChestBtn.addActionListener(openChest);
  }

  private void handleNewRoom(Room newRoom) {
    String text = player.processRulesPlayEntersRoom();

    if (text.equals("You are the winner of the game!")) {
      diedOrWin(text);
    }

    gameGui.roomInfoText.setText( newRoom.getRoomInfo() );
    System.out.println(newRoom);
  }

  private void blocking(String direction) {
    gameGui.roomInfoText.setText( "You cannot go " + direction + ", something is blocking your path!" );
  }

  private void diedOrWin(String text){
    gameGui.roomInfoText.setText( text);
    gameGui.goEastBtn.setEnabled(false);
    gameGui.goNorthBtn.setEnabled(false);
    gameGui.goWestBtn.setEnabled(false);
    gameGui.goSouthBtn.setEnabled(false);
    gameGui.examineBtn.setEnabled(false);
    gameGui.pickupBtn.setEnabled(false);
    gameGui.roomInfoBtn.setEnabled(false);
    gameGui.helpBtn.setEnabled(false);
    gameGui.dropBtn.setEnabled(false);
    gameGui.openChestBtn.setEnabled(false);
  }

  ActionListener goNorth = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        //Kolla om currentRoom är 34
        if (player.getCurrentRoom().getRoomId() == 34) {

          diedOrWin( "You falled down a cliff and died!\n\nGame over" );

        }
        else {

          Room newRoom = player.goNorth();

          if (newRoom != null) {
            handleNewRoom(newRoom);
          }
          else {
            blocking("north");
          }
        }
      }
  };

  ActionListener goEast = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Room newRoom = player.goEast();

        if (newRoom != null) {
          handleNewRoom(newRoom);
        }
        else {
          blocking("east");
        }
      }
  };

  ActionListener goSouth = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Room newRoom = player.goSouth();

        if (newRoom != null) {
          handleNewRoom(newRoom);
        }
        else {
          blocking("south");
        }
      }
  };

  ActionListener goWest = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        //Kolla om currentRoom är 113
        if (player.getCurrentRoom().getRoomId() == 113) {

          diedOrWin( "You falled down a cliff and died!\n\nGame over" );

        }
        else {
          Room newRoom = player.goWest();

          if (newRoom != null) {
            handleNewRoom(newRoom);
          }
          else {
            blocking("west");
          }
        }
      }
  };

  ActionListener roomInfo = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Room currentRoom = player.getCurrentRoom();

        gameGui.roomInfoText.setText( currentRoom.getRoomInfo() );
      }
  };

  ActionListener help = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        String helpText = "Press 'North', 'East', 'South', 'West' buttons to go to another room.\n" +
                          "Press the 'Room info' button to see the room information again.\n" +
                    			"If you wish to examine the room closer for items, press the 'Examine room' button.\n" +
                          "To pick up any items you might have found, select the item in the list and press the 'Pickup' button.\n" +
                          "If you with to drop an item, select an item from the backpack and press the 'Drop' button.\n" +
	                        "If you wish to quit the game press 'Quit' button";

        gameGui.roomInfoText.setText( helpText );
      }
  };

  ActionListener examine = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        Room currentRoom = player.getCurrentRoom();

        if (currentRoom.getThings().size() == 0) {
          gameGui.roomInfoText.setText( "You don't see anything special when you examine the room!" );
        }
        else {
          String info = "You examine the room and can see the following things on the ground \n\n";

          DefaultListModel listModel = new DefaultListModel();

          for (Things things : currentRoom.getThings()) {

            // Kolla om man ser saken
            if (things.getVisible()) {
              info += things.toString() + "\n\n";
              listModel.addElement( things );
            }
          }
          gameGui.thingsList.setModel(listModel);

          gameGui.roomInfoText.setText( info );

          if (currentRoom.getRoomId() == 250) {
            gameGui.openChestBtn.setEnabled(true);
          }
        }
      }
  };

  ActionListener pickup = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (gameGui.thingsList.getSelectedIndex() != -1)
        {
          // Ta reda på vilken things som är vald
          Things selectedThings = (Things) gameGui.thingsList.getSelectedValue();

          if (!selectedThings.getAttainable()) {
            gameGui.roomInfoText.setText( "You cannot pickup " + selectedThings.getObjectName() );
            return;
          }

          // Lägg den i backpacken
          Backpack backpack = player.getBackpack();

          backpack.addThings(selectedThings);

          // Ta bort den från rummet
          Room currentRoom = player.getCurrentRoom();

          currentRoom.removeThings(selectedThings);

          // Ta bort den från things listan i fönstret
          int selectedIndex = gameGui.thingsList.getSelectedIndex();

          DefaultListModel model = (DefaultListModel) gameGui.thingsList.getModel();

          model.removeElementAt(selectedIndex);

          // Uppdatera backpack listan i fönstret
          DefaultListModel backpackModel = (DefaultListModel) gameGui.backpackList.getModel();

          backpackModel.addElement(selectedThings);

          // Behandla regler
          player.processRulesAfterPickup(selectedThings);

          gameGui.roomInfoText.setText( "You pickuped up " + selectedThings.getObjectName() );

          System.out.println("You picked up " + selectedThings);
          System.out.println("Backpack is now " + backpack);
          System.out.println("Room info now " + currentRoom);
        }

      }
  };

  ActionListener drop = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (gameGui.backpackList.getSelectedIndex() != -1)
        {
          // Ta reda på vilken things som är vald
          Things selectedThings = (Things) gameGui.backpackList.getSelectedValue();

          // Lägg den i rummet
          Room currentRoom = player.getCurrentRoom();

          currentRoom.addThings(selectedThings);

          // Ta bort den från backpack
          Backpack backpack = player.getBackpack();

          backpack.removeThings(selectedThings);

          // Ta bort den från things listan i fönstret
          int selectedIndex = gameGui.backpackList.getSelectedIndex();

          DefaultListModel model = (DefaultListModel) gameGui.backpackList.getModel();

          model.removeElementAt(selectedIndex);

          // Uppdatera things listan i fönstret
          DefaultListModel thingsModel = (DefaultListModel) gameGui.thingsList.getModel();

          // Behandla regler
          String text = player.processRulesAfterDrop(selectedThings);

          if (text != null){
            gameGui.roomInfoText.setText(text);

            // Special regel
            if (text.equals("A glass Key appears infront of you!")) {

              // Find key in room
              for (Things glassKey : currentRoom.getThings()) {
                  if (glassKey.getObjectName().equals("Glass Key")) {
                      // Add to things in room list
                      thingsModel.addElement(glassKey);
                  }
              }
            }
          }

          thingsModel.addElement(selectedThings);

          gameGui.roomInfoText.setText( "You dropped " + selectedThings.getObjectName() );

          System.out.println("You dropped " + selectedThings);
          System.out.println("Backpack is now " + backpack);
          System.out.println("Room info now " + currentRoom);
        }

      }
    };

  ActionListener openChest = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (player.getCurrentRoom().getRoomId() == 250)
        {
            // Kolla om vi har alla nycklar i backpack
            if (player.canOpenChest()) {

              diedOrWin("You are the winner of the game!");
            }
            else {
              gameGui.roomInfoText.setText( "You bang your head against the cheast but it will not crack! You tell your self that maybe you need some key to open the cheast." );
            }
        }
      }
    };

  ActionListener quit = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
  };

}
