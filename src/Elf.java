public class Elf extends Warrior {

  private static final int STARTING_HEALTH = 70;
  private static final int ATTACK_POW = 4;
  private static final int ATTACK_PROB = 66;
  private static final int CRITICAL_PROB = 17;
  private static final int SHEILD_PROB = 0;

  public static final String type = "Elf";

  public Elf() {
    super("Generic Elf", 0, STARTING_HEALTH);
  }

  public Elf(int i) {
    super("Generic Elf", i, STARTING_HEALTH);
  }

  public Elf(int i, boolean isUser) {
    super("Generic Elf", i, STARTING_HEALTH, isUser);
  }

  public Elf(String name) {
    super(name, 0, STARTING_HEALTH);
  }

  public Elf(String name, boolean isUser) {
    super(name, 0, STARTING_HEALTH, isUser);
  }

  public Elf(String name, int i) {
    super(name, i, STARTING_HEALTH);
  }

  public Elf(String name, int i, boolean isUser) {
    super(name, i, STARTING_HEALTH, isUser);
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

  public String battleCry() {
    return "Tomorrow, a red moon rises!";
  }

}