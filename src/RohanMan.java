public class RohanMan extends Man {

  private static final int STARTING_HEALTH = 70;
  private static final int ATTACK_POW = 4;
  private static final int ATTACK_PROB = 83;
  private static final int CRITICAL_PROB = 0;
  private static final int SHEILD_PROB = 0;

  public static final String type = "Rohan Man";

  public RohanMan() {
    super("Generic Rohan Man", 0, STARTING_HEALTH);
  }

  public RohanMan(int i) {
    super("Generic Rohan Man", i, STARTING_HEALTH);
  }

  public RohanMan(int i, boolean isUser) {
    super("Generic Rohan Man", i, STARTING_HEALTH, isUser);
  }

  public RohanMan(String name) {
    super(name, 0, STARTING_HEALTH);
  }

  public RohanMan(String name, boolean isUser) {
    super(name, 0, STARTING_HEALTH, isUser);
  }

  public RohanMan(String name, int i) {
    super(name, i, STARTING_HEALTH);
  }

  public RohanMan(String name, int i, boolean isUser) {
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
    return "In Rohan, we ride horses and fight!";
  }
}
