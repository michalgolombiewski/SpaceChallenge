import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation=new Simulation();
        int u1Budget=0;
        int u2Budget=0;
        //PHASE1
        //load items
        ArrayList<Item> phase1= simulation.loadItems("phase-1.txt");

        //simulation of U1
        ArrayList<Rocket> u1FleetPhase1 = simulation.loadU1(phase1);
        u1Budget+=simulation.runSimulation(u1FleetPhase1);
        //simulation of U2
        ArrayList<Rocket> u2FleetPhase1 = simulation.loadU2(phase1);
        u2Budget+=simulation.runSimulation(u2FleetPhase1);

        //PHASE2
        //load items
        ArrayList<Item> phase2= simulation.loadItems("phase-2.txt");

        //simulation of U1
        ArrayList<Rocket> u1FleetPhase2 = simulation.loadU1(phase2);
        u1Budget+=simulation.runSimulation(u1FleetPhase2);
        //simulation of U2
        ArrayList<Rocket> u2FleetPhase2 = simulation.loadU2(phase2);
        u2Budget+=simulation.runSimulation(u2FleetPhase2);

        System.out.println("Budget required for sending U1 Rockets is: $" + u1Budget + " million.");
        System.out.println("Budget required for sending U2 Rockets is: $" + u2Budget + " million.");
        //Display which rocket type to use
        if (u1Budget < u2Budget) {
            System.out.println("\nRockets U1 is cheaper.");
        } else if (u2Budget < u1Budget) {
            System.out.println("\nRocket U2 is cheaper.");
        } else {
            System.out.println("Cost is the same.");
        }
    }
}