package org.cave;

import java.util.*;

public class Lines{

  private int roomId;
  private String roomInfo;
  private ArrayList<Lines> myLines = new ArrayList<>();

  public Lines(int roomId, String roomInfo){

    this.roomId = roomId;
    this.roomInfo = roomInfo;

  }

  public int getRoomId(){
    return this.roomId;
  }
  public String getRoomInfo(){
    return this.roomInfo;
  }
  public void setRoomId(int newRoomId){
    this.roomId = newRoomId;
  }
  public void setRoomInfo(String newRoomInfo){
    this.roomInfo = newRoomInfo;
  }

}
