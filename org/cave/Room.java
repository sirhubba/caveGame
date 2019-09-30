package org.cave;
import java.util.*;

public class Room implements Comparable<Room>, Comparator<Room> {

	private int roomId;
	private int north;
	private int east;
	private int west;
	private int south;

	private String roomInfo;
	private ArrayList<Things> things;

	public Room (int roomId) {
		this.roomId   = roomId;
	}

	public Room (int roomId, int north, int east,int west ,int south ) {

    	this.roomId   = roomId;
    	this.north    = north;
    	this.south    = south;
    	this.east     = east;
    	this.west     = west;
			this.things = new ArrayList<>();
    }

		public int getRoomId(){
			return this.roomId;
		}

		public int getNorth(){
			return this.north;
		}

		public int getSouth(){
			return this.south;
		}

		public void setSouth(int south) {
			this.south = south;
		}

		public int getEast(){
			return this.east;
		}

		public int getWest(){
			return this.west;
		}

		public void setWest(int west){
			this.west = west;
		}

		public String getRoomInfo(){
	    return this.roomInfo;
	  }

		public void setRoomInfo(String roomInfo){
	    this.roomInfo = roomInfo;
	  }

		public ArrayList<Things> getThings(){
			return this.things;
		}

		public void addThings(Things things){
			this.things.add(things);
		}

		public void removeThings(Things things){
			this.things.remove(things);
		}

	 @Override
	 public int compareTo(final Room room){
		 return Integer.compare(this.roomId, room.roomId); // bara compare för att vi ska jämföra två nummer med varnadra
	 }

	 public int compare(Room room1, Room room2){
		 return Integer.compare(room1.roomId, room2.roomId);
	 }

		public String toString() {
				String allThings = "";
				for (Things things : this.things) {
					allThings += "{ name: " + things.getObjectName() + ", visible: " + things.getVisible() + ", attainable: " + things.getAttainable() + "}";
				}
        return  this.roomId +  ", n: " + this.north + ", s: " + this.south + ", e: " + this.east + ", w: " + this.west + ", no of things: " + this.things.size() + ", roominfo: [" + this.roomInfo.replace("\n", "|") + "], things in room: [" + allThings + "]\n--------------------------------------------------------------------------------";
		}

}
