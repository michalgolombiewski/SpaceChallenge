//class  is responsible for reading item data and filling up the rockets.

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //loads all items from a text file and returns an ArrayList of Items
    ArrayList<Item> loadItems(String filename) {
        String line;
        File file = new File(filename);
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String [] oneItem=line.split("=");
                items.add(new Item(oneItem[0],Integer.valueOf(oneItem[1])));

            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
        }
        return items;
    }
    /* This methods takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     * and filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.
     */
    ArrayList<Rocket> loadU1(ArrayList<Item> list) {

        Rocket ship = new U1();
        ArrayList<Rocket> fleet = new ArrayList<>();

        for (Item i : list) {

            while(!ship.canCarry(i)) {

                fleet.add(ship);
                ship = new U1();
            }
            ship.carry(i);

        }
    return fleet;
    }
    //The method then returns the ArrayList of those U2 rockets that are fully loaded.
    ArrayList<Rocket> loadU2(ArrayList<Item> list){

        Rocket ship = new U2();
        ArrayList<Rocket> fleet = new ArrayList<>();

        for (Item i : list){

            while (!ship.canCarry(i)){

                fleet.add(ship);
                ship = new U2();
            }
            ship.carry(i);
        }
        return fleet;
    }
    /*
     *this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     *Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     *All while keeping track of the total budget required to send each rocket safely to Mars.
     *runSimulation then returns the total budget required to send all rockets (including the crashed ones).
     */
    int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
        for (Rocket rocket : rockets) {
            do {
                totalBudget += rocket.cost;
            } while (!(rocket.launch() && rocket.land()));
        }
        return totalBudget;
    }

}