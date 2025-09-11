import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");


        //Cointains the stats of the first character (HP, Mana, damage)
        ArrayList<Integer> stats1 = new ArrayList<>();
        stats1.add(100);
        stats1.add(randomGenerator.nextInt(20,81));
        stats1.add(randomGenerator.nextInt(20,81));

        //Cointains the stats of the first character (HP, Mana, damage)
        ArrayList<Integer> stats2 = new ArrayList<>();
        stats2.add(100);
        stats2.add(randomGenerator.nextInt(20,81));
        stats2.add(randomGenerator.nextInt(20,81));

        //Print character info to check it works
        System.out.println("Character 1 has "+ stats1.get(1) + " mana");

        int newHP= standardAttack(stats1.get(2), stats2.get(0));
        stats2.set(0,newHP); // Puuts the new HP to current HP in stats2
        System.out.println("Fighter number 2 now has "+ stats2.get(0) + " HP");

    }

    //Method for standard attack
    public static int standardAttack(int damage, int hp){
        int chance= randomGenerator.nextInt(100); //generates a number 0-99

        //Chance of crit is appx 1/3
        if (chance<67) {
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        }else{
            hp= hp-damage;
            System.out.println("Critcal hit");
        }
        return hp;


    }

}

// skriv sout + TAB för utskrift
//System.out.println("Första"); //Skriver ut och skapar ny rad
//System.out.print("andra");  //Skriver ut utan att avsluta med ny rad