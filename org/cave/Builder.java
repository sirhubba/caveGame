package org.cave;
import org.cave.db.*;
import java.util.*;
import java.sql.*;

public class Builder {

  public ArrayList<Room> myRooms = new ArrayList<>();

  public void load()
  {
    loadMyRooms();
    loadLines();
    loadThings();
  }

  private void loadMyRooms() {
    String query;

    //query = "select * from cave natural join lines left join things on cave.roomid=things.roomid order by cave.roomId";
    query = "select * from cave order by cave.roomId";

    CaveDB caveDB = new CaveDB();

    caveDB.c = caveDB.createConnection();

    caveDB.s = caveDB.myCreateStatement(caveDB.c);

    caveDB.rs = caveDB.myCreateResultSet(caveDB.s, query);

    try {

      while (caveDB.rs.next()) {

        // har ej ändrat här, ska ändra ordningen på det.
        int roomId      = caveDB.rs.getInt(1);
  	    int north       = caveDB.rs.getInt(2);
  	    int south       = caveDB.rs.getInt(3);
  	    int east        = caveDB.rs.getInt(4);
  	    int west        = caveDB.rs.getInt(5);

        myRooms.add(new Room(roomId, north, south, east, west));

      }
      caveDB.rs.close();
    } catch (SQLException se) {
      System.out.println("We got an exception while getting a result:this " +
                         "shouldn't happen: we've done something really bad.");
      System.out.println(se.getMessage());
      System.exit(1);
      }

  }

  private void loadLines() {

    for (Room room : myRooms) {

      String query;

      query = "select * from lines where roomid = " + room.getRoomId();

      CaveDB caveDB = new CaveDB();

      caveDB.c = caveDB.createConnection();

      caveDB.s = caveDB.myCreateStatement(caveDB.c);

      caveDB.rs = caveDB.myCreateResultSet(caveDB.s, query);

      try {

        ArrayList<String> lines = new ArrayList<String>();

        while (caveDB.rs.next()) {
          lines.add( caveDB.rs.getString(3) );
        }

        room.setRoomInfo(String.join("\n", lines));

        caveDB.rs.close();
      } catch (SQLException se) {
        System.out.println("We got an exception while getting a result:this " +
                           "shouldn't happen: we've done something really bad.");
        System.out.println(se.getMessage());
        System.exit(1);
        }
      }
    }

    private void loadThings() {

      for (Room room : myRooms) {

        String query;

        query = "select * from Things where roomid = " + room.getRoomId();

        CaveDB caveDB = new CaveDB();

        caveDB.c = caveDB.createConnection();

        caveDB.s = caveDB.myCreateStatement(caveDB.c);

        caveDB.rs = caveDB.myCreateResultSet(caveDB.s, query);

        try {

          while (caveDB.rs.next()) {
            String objectName  = caveDB.rs.getString(1);
            int roomId         = caveDB.rs.getInt(2);
            boolean visible    = caveDB.rs.getBoolean(3);
            boolean attainable = caveDB.rs.getBoolean(4);

            room.addThings(new Things(roomId, objectName, visible, attainable));
          }

          caveDB.rs.close();
        } catch (SQLException se) {
          System.out.println("We got an exception while getting a result:this " +
                             "shouldn't happen: we've done something really bad.");
          System.out.println(se.getMessage());
          System.exit(1);
          }
        }
      }
}
