import java.util.Random;

public class Warrior {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  private static final int STARTING_HEALTH = 55;
  private static final int ATTACK_POW = 6;
  private static final int ATTACK_PROB = 83;
  private static final int CRITICAL_PROB = 0;
  private static final int SHEILD_PROB = 0;

  private String name;
  private int health;
  private int index;
  private int finalIndex;
  private String color;
  private boolean isUser;

  private static final String type = "Warrior";

  public Warrior() {
    this.name = "Generic Warrior";
    this.health = STARTING_HEALTH;
    this.index = 0;
    this.color = ANSI_WHITE;
    this.isUser = true;

    this.finalIndex = this.index;
  }

  public Warrior(String name) {
    this.name = name;
    health = STARTING_HEALTH;
    index = 0;
    color = ANSI_WHITE;
    isUser = true;
    
    this.finalIndex = this.index;
  }

  public Warrior(String name, boolean isUser) {
    this.name = name;
    health = STARTING_HEALTH;
    index = 0;
    color = ANSI_WHITE;
    this.isUser = isUser;

    this.finalIndex = this.index;
  }

  public Warrior(String name, int i) {
    this.name = name;
    health = STARTING_HEALTH;
    index = i;
    color = ANSI_WHITE;
      
    this.finalIndex = this.index;
  }

  public Warrior(String name, int i, boolean isUser) {
    this.name = name;
    health = STARTING_HEALTH;
    index = i;
    color = ANSI_WHITE;
    this.isUser = isUser;
      
    this.finalIndex = this.index;
  }

  public Warrior(String name, int i, int h) {
    this.name = name;
    health = h;
    index = i;
    color = ANSI_WHITE;
      
    this.finalIndex = this.index;
  }

  public Warrior(String name, int i, int h, boolean isUser) {
    this.name = name;
    health = h;
    index = i;
    color = ANSI_WHITE;
    this.isUser = isUser;
      
    this.finalIndex = this.index;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return health;
  }

  public int getIndex() {
    return index;
  }

  public int getFinalIndex() {
    return this.finalIndex;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String name) {
    this.color = getColorCode(name);
  }

  public String printName() {
    return this.color + this.name + ANSI_RESET;
  }

  public int getAttackPow() {
    return ATTACK_POW;
  }

  public int getAttackProb() {
    return ATTACK_PROB;
  }

  public int getCriticalProb() {
    return CRITICAL_PROB;
  }

  public int getSheildProb() {
    return SHEILD_PROB;
  }

  public String getType() {
    return type;
  }

  public boolean getIsUser() {
    return isUser;
  }

  public String getHealthBar() {
    String bar = "";
    for (int i = 0; i < this.getHealth(); i++) {
      bar += "|";
    }
    bar += " - " + this.getHealth();
    return bar;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String battleCry() {
    return "From Middle Earth!!!";
  }

  public void attack(Warrior opponent, int delay, boolean verbose) {
    Random rand = new Random();
    int roll = rand.nextInt(100) + 1;

    if (verbose) System.out.println(this.printName() + " is attacking " + opponent.printName() + "!");

    delay(delay);

    String msg;
    int damage = 0;

    if (roll <= this.getCriticalProb()) {
      if (this instanceof Elf) {
        msg = this.printName() + " shoots an arrow and scores a CRITICAL HIT on " + opponent.printName() + "!";
      } else {
        msg = this.printName() + " throws an axe and scores a CRITICAL HIT on " + opponent.printName() + "!";
      }
      damage = this.getAttackPow() * 2;
    } else if (roll <= this.getAttackProb()) {
      int defense = rand.nextInt(100) + 1;

      if (defense <= opponent.getSheildProb()) {
        msg = this.printName() + " successfully attacks " + opponent.printName() + " but " + 
              opponent.printName() + " blocks it!";
      } else {
        msg = this.printName() + " successfully attacks " + opponent.printName() + "!";
        damage = this.getAttackPow();
      }
    } else {
      msg = this.printName() + "'s attack has failed.";
    }

    // print your message
    if (verbose) System.out.println(msg);
    // subtract damage from the opponent's health
    opponent.health -= damage;
    delay(delay);
  }

  public static void delay(int milli) {
    try {
      Thread.sleep(milli);
    } catch (Exception e) {
      e.printStackTrace();
    }
    ;
  }

  public static String getColorCode(String name) {
    if (name.equals("Black")) {
      return ANSI_BLACK;
    } else if (name.equals("Red")) {
      return ANSI_RED;
    } else if (name.equals("Green")) {
      return ANSI_GREEN;
    } else if (name.equals("Yellow")) {
      return ANSI_YELLOW;
    } else if (name.equals("Blue")) {
      return ANSI_BLUE;
    } else if (name.equals("Purple")) {
      return ANSI_PURPLE;
    } else if (name.equals("Cyan")) {
      return ANSI_CYAN;
    } else {
      return ANSI_WHITE;
    }
  }
}
