import java.util.Random;
import java.util.Scanner;

public class WarriorInit {

  public static final String[] TYPES = {
    "Warrior",
    "Elf",
    "Dwarf",
    "Man",
    "GondorMan",
    "RohanMan"
  };
  private static final String[] COLORS = {
    // "Black",
    "Red",
    "Yellow",
    "Green",
    "Blue",
    "Cyan",
    "Purple",
    "White"
  };
  private static final String[] NAMES = {
    "Bilbo Bagans",
    "Frodo Bagans",
    "Legolas",
    "Gimli",
    "Faramir",
    "Eomer",
    "Gandolf",
    "Steve"
  };

  public String t;
  public String n;
  public String c;
  private boolean isUser;
  
  public WarriorInit(String type, String name, String color, boolean isUser) {
    this.t = type;
    this.n = name;
    this.c = color;
    this.isUser = isUser;

    if (this.t.isEmpty()) this.t = "Warrior";
    if (this.n.isEmpty()) this.n = "Generic " + this.t;
  }

  public static WarriorInit initFromUser(String format, Scanner reader) {

    System.out.printf(format, "What type of warrior do you want");
    String type = reader.next();
    System.out.printf(format, "What's the name of this " + type);
    String name = reader.next();
    System.out.printf(format, "What color should this " + type + " be");
    String color = reader.next();

    return new WarriorInit(type, name, color, true);
  }

  public static WarriorInit getRandomWarrior() {
    int typeIndex = new Random().nextInt(TYPES.length);
    String type = TYPES[typeIndex];
    int nameIndex = new Random().nextInt(NAMES.length);
    String name = NAMES[nameIndex];
    int colorIndex = new Random().nextInt(COLORS.length);
    String color = COLORS[colorIndex];

    return new WarriorInit(type, "", color, false);
  }

  public Warrior initWarrior(int i) {
    if (this.t.equals("Elf")) {
      return new Elf(this.n, i, this.isUser);
    } else if (this.t.equals("Dwarf")) {
      return new Dwarf(this.n, i, this.isUser);
    } else if (this.t.equals("Man")) {
      return new Man(this.n, i, this.isUser);
    } else if (this.t.equals("GondorMan")) {
      return new GondorMan(this.n, i, this.isUser);
    } else if (this.t.equals("RohanMan")) {
      return new RohanMan(this.n, i, this.isUser);
    } else {
      return new Warrior(this.n, i, this.isUser);
    }
  }
}