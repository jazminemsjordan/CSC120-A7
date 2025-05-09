/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /***
     * Constructor for building a cafe
     * @param name the name of the cafe
     * @param address the cafe address
     * @param nFloors number of floors in the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 256;
        this.nSugarPackets = 64;
        this.nCreams = 64;
        this.nCups = 16;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method to sell coffee and reduce inventory
     * @param size the integer size (in ounces) of the coffee
     * @param nSugarPackets the number of sugar packets in the coffee
     * @param nCreams the number of splashes of cream in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size <= this.nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && this.nCups >= 1) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        } else {
            restock(64, 16, 16, 8);
        }
    }

    /**
     * Method to restock the cafe's inventory
     * @param nCoffeeOunces ounces of coffee to restock
     * @param nSugarPackets number of sugar packets to restock
     * @param nCreams number of splashes of cream to restock
     * @param nCups number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        
    } 
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Center Cafe", "100 Elm Street", 1);
    }
    
}
