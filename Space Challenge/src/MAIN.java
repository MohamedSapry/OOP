/*
Mohamed Sabry
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MAIN {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();
        ArrayList<Item> phase1 = sim.loadItems(new File("phase1.txt"));
        ArrayList<Item> phase2 = sim.loadItems(new File("phase2.txt"));

        ArrayList<Rocket> u1RocketsPhase1 = sim.loadU1(phase1);
        ArrayList<Rocket> u1RocketsPhase2 = sim.loadU1(phase2);
        int phase1U1 = sim.runSimulation(u1RocketsPhase1);
        int phase2U1 = sim.runSimulation(u1RocketsPhase2);
        System.out.println("THE COST OF USING U1 ROCKETS IN PHASE 1 = " + phase1U1 + " MILLIONS");
        System.out.println("THE COST OF USING U1 ROCKETS IN PHASE 2 = " + phase2U1 + " MILLIONS");
        System.out.println("THE TOTAL COST OF USING U1 ROCKETS = " + (phase1U1 + phase2U1) + " MILLIONS");

        ArrayList<Rocket> u2RocketsPhase1 = sim.loadU2(phase1);
        ArrayList<Rocket> u2RocketsPhase2 = sim.loadU2(phase2);
        int phase1U2 = sim.runSimulation(u2RocketsPhase1);
        int phase2U2 = sim.runSimulation(u2RocketsPhase2);
        System.out.println("THE COST OF USING U2 ROCKETS IN PHASE 1 = " + phase1U2 + " MILLIONS");
        System.out.println("THE COST OF USING U2 ROCKETS IN PHASE 2 = " + phase2U2 + " MILLIONS");
        System.out.println("THE TOTAL COST OF USING U2 ROCKETS = " + (phase1U2 + phase2U2) + " MILLIONS");
    }
}
