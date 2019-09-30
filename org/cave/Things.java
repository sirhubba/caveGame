package org.cave;
import org.cave.*;

public class Things {

  int roomId;
  String objectName;
  boolean visible;
  boolean attainable;

  public Things(String objectName) {
    this.objectName = objectName;
  }

  public Things(int roomId, String objectName, boolean visible, boolean attainable){

    this.roomId = roomId;
    this.objectName = objectName;
    this.visible = visible;
    this.attainable = attainable;

  }

  public int getRoomId(){
    return this.roomId;
  }
  public String getObjectName(){
    return this.objectName;
  }
  public boolean getVisible(){
    return this.visible;
  }
  public boolean getAttainable(){
    return this.attainable;
  }
  public void setRoomId(int newRoomId){
    this.roomId = newRoomId;
  }
  public void setObjectName(String newObjectName){
    this.objectName = newObjectName;
  }
  public void setVisible(boolean newVisible){
    this.visible = newVisible;
  }
  public void setAttainable(boolean newAttainable){
    this.attainable = newAttainable;
  }

  @Override
  public String toString() {
      //return   this.roomId +  "," + this.objectName + "," + this.visible + "," + this.attainable + "," + "\n\n--------\n\n";
      return this.objectName;
  }
}
