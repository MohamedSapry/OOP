/*
Mohamed Sabry
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // method to load all items in an arraylist that carries items.
    ArrayList<Item> loadItems(File f) throws FileNotFoundException {
        Scanner in = new Scanner(f);
        ArrayList<Item> items = new ArrayList<>();

        while (in.hasNextLine()){
            String[] x = in.nextLine().split("=");
            items.add(new Item(x[0], Integer.parseInt(x[1])));
        }
        // here i Preferred to sort all items to guarantee that the rocket will take as mush items as can.
        return sortItems(items);
    }
    // this is the method where i sorted the items (modified bubble sort).
    ArrayList<Item> sortItems(ArrayList<Item> items){
        Item temp;
        for(int i = 0; i < items.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < items.size() - i - 1; j++){
                if(items.get(j).weight > items.get(j + 1).weight){
                    temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set((j + 1), temp);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return items;
    }

    /*
        this method takes arraylist of items and load them in several (one or more) Rockets of type U1...
        then return those rockets.
    */
    ArrayList<Rocket> loadU1(ArrayList<Item> items){
        ArrayList<Rocket> rockets = new ArrayList<>();
        Rocket u1 = new U1();

        for(Item i : items){
            if(u1.canCarry(i)){
                u1.carry(i);
            }else{
                rockets.add(u1);
                u1 = new U1();
            }

        }
        rockets.add(u1);
        return rockets;
    }
    /*
        this method like loadU1 but on Rockets of  type U2.
     */
    ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> rockets = new ArrayList<>();
        Rocket u2 = new U2();

        for(Item i : items){
            if(u2.canCarry(i)){
                u2.carry(i);
            }else{
                rockets.add(u2);
                u2 = new U2();
            }
        }
        rockets.add(u2);
        return rockets;
    }

    /*
        in this method we run our simulation and return the cost of this simulation.
     */
    int runSimulation (ArrayList<Rocket> rockets){
        int numberOfRockets = rockets.size();
        for (Rocket i : rockets){
            while (!i.launch()){
                i.launch();
                numberOfRockets++;
            }

            while (!i.land()){
                i.land();
                numberOfRockets++;
            }
        }
        return rockets.get(0).cost * numberOfRockets;
    }
}
