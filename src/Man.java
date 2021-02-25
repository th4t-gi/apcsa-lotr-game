public class Man extends Warrior {

  private static final int STARTING_HEALTH = 55;
  private static final int ATTACK_POW = 6;
  private static final int ATTACK_PROB = 67;
  private static final int CRITICAL_PROB = 0;
  private static final int SHEILD_PROB = 17;

  public static final String type = "Man";

  public Man() {
    super("Generic Man", 0, STARTING_HEALTH);
  }

  public Man(int i) {
    super("Generic Man", i, STARTING_HEALTH);
  }

  public Man(int i, boolean isUser) {
    super("Generic Man", i, STARTING_HEALTH, isUser);
  }

  public Man(String name) {
    super(name, 0, STARTING_HEALTH);
  }

  public Man(String name, boolean isUser) {
    super(name, 0, STARTING_HEALTH, isUser);
  }

  public Man(String name, int i) {
    super(name, i, STARTING_HEALTH);
  }

  public Man(String name, int i, boolean isUser) {
    super(name, i, STARTING_HEALTH, isUser);
  }

  public Man(String name, int i, int health) {
    super(name, i, health);
  }

  public Man(String name, int i, int health, boolean isUser) {
    super(name, i, health, isUser);
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
    return "Oh man...";
  }

}
