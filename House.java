import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  
  /***
   * Constructor for building a house
   * @param name the name of the house
   * @param address the house address
   * @param nFloors number of floors in the house
   * @param hasDiningRoom whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /***
   * Method to retrieve hasDiningRoom attribute
   * @return whether the house has a dining room or not
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /***
   * Method to retrieve the number of residents in the house
   * @return number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /***
   * Method to move a resident into the house
   */
  public void moveIn(Student s) {
    if (this.residents.contains(s)) {
      throw new RuntimeException("Student already lives in this house!");
    }
    this.residents.add(s);
  }

  /***
   * Method to move a resident out of the house
   * @return the student who is moving out
   */
  public Student moveOut(Student s) {
    if (!this.residents.contains(s)) {
      throw new RuntimeException("Can't move out a student that doesn't live here!");
    }
    this.residents.remove(s);
    return s;
  }

  /***
   * Method to check if a student lives in the house
   * @return whether the student is on the list of house residents
   */
  public boolean isResident(Student s) {
    if (this.residents.contains(s)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    House myHouse = new House("Capen House", "26 Prospect Street", 3, false);
  }

}