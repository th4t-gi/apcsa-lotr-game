import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class App {

  public static Scanner reader = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    WarriorInit[] init = {
      new WarriorInit("Warrior", "Frodo", "Red", false),
      new WarriorInit("Elf", "Legolas", "Green", false),
      new WarriorInit("Dwarf", "Gimli", "Cyan", false),
      new WarriorInit("Man", "Steve", "Purple", false),
      new WarriorInit("GondorMan", "Faramir", "Yellow", false),
      new WarriorInit("RohanMan", "Eomer", "", false)
    };

    // Asks input questions including what type of game, and number of warriors
    // System.out.print("Would you like to play a game or simulate one [game/sim]?: ");
    // String game = reader.next("game|sim");
    String game = "sim";

    // System.out.print("How many total warriors do you want?: ");
    // int t = reader.nextInt();
    // System.out.print("How many warriors do you want to customize?: ");
    // int n = reader.nextInt();

    // // Generates WarriorInit objects
    // WarriorInit[] init = new WarriorInit[t];
    // for (int i = 0; i < n; i++) {
    //   init[i] = WarriorInit.initFromUser("Warrior " + (i + 1) + " - %s?: ", reader);
    // }
    // for (int i = n; i < t; i++) {
    //   init[i] = WarriorInit.getRandomWarrior();
    // }

    ArrayList<Warrior> warriors = getCombatants(init);

    if (game.equals("sim")) {
      // System.out.print("How many iterations should this simulation be?: ");
      // int iter = reader.nextInt();
      simulate(init, 1000);
    } else {
      System.out.print("What should the delay be for the program (in milliseconds)?: ");
      int delay = reader.nextInt();
      battle(warriors, delay, true, true);
    }

    // printHealths(warriors);
    // battle(warriors, 100, true);
    reader.close();
  }

  public static void printHealths(ArrayList<Warrior> combatants) {
    // Counts the max number of tabs
    int max = 0;
    for (Warrior w : combatants) {
      String h = w.getIndex() + " - " + w.getName() + " (" + w.getType() + ")";
      int numTabs = h.length() / 8 + 1;
      if (numTabs > max)
        max = numTabs;
    }

    System.out.println("***HEALTHBOARD*** " + max);
    String msg = "";
    for (Warrior w : combatants) {
      String h = w.getIndex() + " - %s (" + w.getType() + ")";
      int length = String.format(h, w.getName()).length() / 8;

      // adds the difference between the max number of tabs and actual number for this
      // line
      msg += String.format(h, w.printName()) + "\t".repeat(max - length) + w.getHealthBar() + "\n";
    }
    System.out.println(msg);
  }

  public static Warrior battle(ArrayList<Warrior> combatants, int delay, boolean verbose, boolean withUsers) {
    Random rand = new Random();

    Warrior attacker = combatants.get(0);
    Warrior defender = combatants.get(0);

    while (combatants.size() > 1) {
      // 'Refreshes' screen and prints healths
      if (verbose) {
        clearScreen();
        printHealths(combatants);
        System.out.println("-".repeat(30) + "");
      }

      Warrior.delay(delay);

      // Gets the defender
      do {
        int i = rand.nextInt(combatants.size());
        if (attacker.getIsUser() && withUsers) {
          System.out.print("Who is " + attacker.printName() + " going to attack (Index please)?: ");
          i = reader.nextInt();
        }
        defender = combatants.get(i);
      } while (attacker.getIndex() == defender.getIndex());

      // Attacks the defender
      attacker.attack(defender, delay, verbose);

      // If the defender is dead
      if (defender.getHealth() <= 0) {
        if (verbose)
          System.out.println(attacker.printName() + " has killed " + defender.printName() + "!!");

        combatants.remove(defender.getIndex());

        // Shifts the indecies down in the warrior objects
        for (int i = defender.getIndex(); i < combatants.size(); i++) {
          combatants.get(i).setIndex(i);
        }
      }

      // Gets new attacker
      if (attacker.getIndex() < combatants.size() - 1) {
        attacker = combatants.get(attacker.getIndex() + 1);
      } else {
        attacker = combatants.get(0);
      }
    }

    if (verbose)
      System.out.println(attacker.printName() + " won and now is the ruler of Middle Earth!!!");

    return attacker;
  }

  public static void simulate(WarriorInit[] init, double n) {
    ArrayList<Integer> winners = new ArrayList<Integer>();
    ArrayList<Warrior> warriors = getCombatants(init);

    for (int i = 0; i < n; i++) {
      ArrayList<Warrior> combatants = getCombatants(init);



      Warrior winner = battle(combatants, 0, false, false);

      //Adds the immutable index for the winner bc the winners index always ends up as zero in the end
      winners.add(winner.getFinalIndex());
    }

    // Count the number of individual wins
    for (Warrior w : warriors) {
      int count = 0;
      for (int i : winners) {
        if (w.getIndex() == i)
          count++;
      }
      double percent = count / n * 100;
      System.out.println(w.printName() + " (" + w.getType().charAt(0) + ") - " + String.format("%.2f", percent) + "% (" + count + ")");
    }

  }

  // Turns an array of WarriorInit objects into actual Warrior objects
  public static ArrayList<Warrior> getCombatants(WarriorInit[] init) {
    ArrayList<Warrior> combatants = new ArrayList<Warrior>();
    for (int i = 0; i < init.length; i++) {
      Warrior w = init[i].initWarrior(i);
      w.setColor(init[i].c);
      combatants.add(w);
    }
    return combatants;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
