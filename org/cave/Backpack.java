package org.cave;
import org.cave.*;
import java.util.*;

public class Backpack{

  private ArrayList<Things> backpack = new ArrayList<>();

  public ArrayList<Things> getBackpack()
  {
    return backpack;
  }

  public void addThings(Things things)
  {
    backpack.add(things);
  }

  public void removeThings(Things things)
  {
    backpack.remove(things);
  }

  public boolean containsThings(Things things)
  {
    for (Things item : backpack) {
      if (item.getObjectName().equals(things.getObjectName())) {
        return true;
      }
    }
    return false;
  }

  public String toString() {
    String allThings = "";
    for (Things things : backpack) {
      allThings += "{ name: " + things.getObjectName() + ", visible: " + things.getVisible() + ", attainable: " + things.getAttainable() + "}\n";
    }
    return allThings;
  }
}
