import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random randomGenerator = new Random();
    static Scanner myScan = new Scanner(System.in); // Ansvarar för att läsa av tangentbordet

    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");


        //Cointains the stats of the first character (HP, Mana, damage)
        ArrayList<Integer> stats1 = new ArrayList<>();
        stats1.add(100);
        stats1.add(randomGenerator.nextInt(20, 81));
        stats1.add(randomGenerator.nextInt(20, 81));

        //Cointains the stats of the first character (HP, Mana, damage)
        ArrayList<Integer> stats2 = new ArrayList<>();
        stats2.add(100);
        stats2.add(randomGenerator.nextInt(20, 81));
        stats2.add(randomGenerator.nextInt(20, 81));

        //Print character info to check it works
        System.out.println("Character 1 has " + stats1.get(0) + " hp and " + stats1.get(1) + " mana");
        System.out.println("Character 2 has " + stats2.get(0) + " hp and " + stats2.get(1) + " mana");

        int choice = chooseCharacter();

        //create the placeholders for the characters
        ArrayList<Integer> mainCharacter;
        ArrayList<Integer> enemy;
        if (choice == 1) {
            mainCharacter = stats1;
            enemy = stats2;
        } else {
            mainCharacter = stats2;
            enemy = stats1;
        }

        startGame(mainCharacter, enemy);

        /*
        //character 1 hits character 2 with standard attack
        int newHP = standardAttack(stats1.get(2), stats2.get(0));
        stats2.set(0, newHP); // Puts the new HP to current HP in stats2
        System.out.println("Fighter number 2 now has " + stats2.get(0) + " HP");

        //character 1 hits charcter 2  with special attack
        int[] hpMana = specialAttack(stats1.get(2), stats1.get(1), stats2.get(0));
        stats2.set(0, hpMana[0]); // Puts the new HP to current HP in stats2
        stats1.set(1, hpMana[1]); // Puts the new mana to current mana in stats1
        System.out.println("Fighter number 2 now has " + stats2.get(0) + " HP");
        System.out.println("fighter 1 now has " + stats1.get(1) + " mana");

         */

        //TODO: Fix game loop inseparate method
        //          Start with user interaction
        //          After let AI hit back with random choice
        //          IF time: Make Ai more clerver in attack coice
    }

    public static void startGame(ArrayList<Integer> mainCharacter, ArrayList<Integer> enemy) {
        System.out.println("FIGHT START!");

        while (mainCharacter.get(0) > 0 && enemy.get(0) > 0) {
            int newHP = standardAttack(mainCharacter.get(2), enemy.get(0));
            enemy.set(0, newHP); // Puts the new HP to current HP in stats2
            System.out.println("Enemy now has " + enemy.get(0) + " HP");

            newHP = standardAttack(enemy.get(2), mainCharacter.get(0));
            mainCharacter.set(0, newHP); // Puts the new HP to current HP in stats2
            System.out.println("You now has " + mainCharacter.get(0) + " HP");
        }

        if (mainCharacter.get(0) < 0) {
            System.out.println("OH NO! The enemy won!");
        } else {
            System.out.println("YES! YOU WON!");
        }
    }


    public static int chooseCharacter() {
        boolean correct = false;
        int choice;
        do {
            System.out.println("Do you want to play as character 1 or character 2? ");
            String answer = myScan.nextLine();
            try {
                choice = Integer.valueOf(answer);
                System.out.println("You chose character " + choice);
            } catch (Exception e) {
                System.out.println("that is not a number!");
                choice = -1;
            }
            switch (choice) {
                case 1:
                    correct = true;
                    break;
                case 2:
                    correct = true;
                    break;
                default:
                    System.out.println("That is not a valid choice try again");
            }
        } while (!correct);


        return choice;
    }

    //Method for standard attack
    public static int standardAttack(int damage, int hp) {
        int chance = randomGenerator.nextInt(100); //generates a number 0-99

        //Chance of crit is appx 1/3
        if (chance < 67) {
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        } else {
            hp = hp - damage;
            System.out.println("Critcal hit");
        }
        return hp;
    }

    //method for special attack
    public static int[] specialAttack(int damage, int mana, int hp) {
        //Specila attack is only available if there is enough mana
        if (mana - 20 < 0) {
            System.out.println("You are to low on mana. Special attack is not available");
        } else {
            System.out.println("special attack");
            hp = (int) (hp - 0.25 * damage);  //Calculates a double, (int) casts double to int
            mana -= 20; // mana = mana -20
        }
        int[] returnArray = {hp, mana};

        return returnArray; //contains Hp and mana
    }


}

// skriv sout + TAB för utskrift
//System.out.println("Första"); //Skriver ut och skapar ny rad
//System.out.print("andra");  //Skriver ut utan att avsluta med ny rad