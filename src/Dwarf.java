public class Dwarf extends Warrior {

  private static final int STARTING_HEALTH = 60;
  private static final int ATTACK_POW = 7;
  private static final int ATTACK_PROB = 50;
  private static final int CRITICAL_PROB = 33;
  private static final int SHEILD_PROB = 0;

  private static final String type = "Dwarf";

  public Dwarf() {
    super("Generic Dwarf", 0, STARTING_HEALTH);
  }

  public Dwarf(int i) {
    super("Generic Dwarf", i, STARTING_HEALTH);
  }

  public Dwarf(int i, boolean isUser) {
    super("Generic Dwarf", i, STARTING_HEALTH, isUser);
  }

  public Dwarf(String name) {
    super(name, 0, STARTING_HEALTH);
  }

  public Dwarf(String name, boolean isUser) {
    super(name, 0, STARTING_HEALTH, isUser);
  }

  public Dwarf(String name, int i) {
    super(name, i, STARTING_HEALTH);
  }

  public Dwarf(String name, int i, boolean isUser) {
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
    return "For Moria!!";
  }
}
