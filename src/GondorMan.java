public class GondorMan extends Man {

  private static final int STARTING_HEALTH = 60;
  private static final int ATTACK_POW = 5;
  private static final int ATTACK_PROB = 67;
  private static final int CRITICAL_PROB = 0;
  private static final int SHEILD_PROB = 17;

  public static final String type = "Gondor Man";

  public GondorMan() {
    super("Generic Gondor Man", 0, STARTING_HEALTH);
  }

  public GondorMan(int i) {
    super("Generic Gondor Man", i, STARTING_HEALTH);
  }

  public GondorMan(int i, boolean isUser) {
    super("Generic Gondor Man", i, STARTING_HEALTH, isUser);
  }

  public GondorMan(String name) {
    super(name, 0, STARTING_HEALTH);
  }

  public GondorMan(String name, boolean isUser) {
    super(name, 0, STARTING_HEALTH, isUser);
  }

  public GondorMan(String name, int i) {
    super(name, i, STARTING_HEALTH);
  }

  public GondorMan(String name, int i, boolean isUser) {
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
    return "I am from Gondor and I fight for my king!";
  }
}
