import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  /***
   * Constructor for building a library
   * @param name the name of the library
   * @param address the library address
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Method to add a book to the library's collection
   * @param title a string with the book's details, formatted as "Book by Author" 
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Method to remove a book from the library's collection
   * @param title a string with the book's details, formatted as "Book by Author"
   * @return the string title of the removed book
   */
  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  }

  /**
   * Method to check out a book from the library's collection 
   * @param title a string with the book's details, formatted as "Book by Author"
   */
  public void checkOut(String title) {
    if (this.collection.get(title) == true) {
      this.collection.replace(title, false);
    } else {
      throw new RuntimeException("This title is already checked out!");
    }
  }

  /**
   * Method to return a book to the library's collection
   * @param title
   */
  public void returnBook(String title) {
    this.collection.replace(title, true);
  }

  /**
   * Method to check if a book is in the library's collection
   * @param title a string with the book's details, formatted as "Book by Author"
   * @return boolean whether the library has the title
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }

  /** Method to check if a book in the collection is currently checked out
   * @param title a string with the book's details, formatted as "Book by Author"
   * @return true if the title exists in the collection AND is available for checkout, false otherwise
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      return true;
      } else {
        return false;
      }
  }

  /**
   * Method to neatly format and print the list of books in the library
   */
  public void printCollection() {
    String collectionList = this.collection.toString();
    collectionList = collectionList.replace("{", "");
    collectionList = collectionList.replace("}", "");
    String[] formattedList = collectionList.split(", ");
    for (int i = 0; i < formattedList.length; i++) {
      System.out.println(formattedList[i]);
    }
  }
  
  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "7 Neilson Drive", 4);
  }
}