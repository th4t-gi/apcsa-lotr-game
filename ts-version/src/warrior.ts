class Warrior {

  static readonly ANSI_RESET = "\u001B[0m";
  static readonly ANSI_BLACK = "\u001B[30m";
  static readonly ANSI_RED = "\u001B[31m";
  static readonly ANSI_GREEN = "\u001B[32m";
  static readonly ANSI_YELLOW = "\u001B[33m";
  static readonly ANSI_BLUE = "\u001B[34m";
  static readonly ANSI_PURPLE = "\u001B[35m";
  static readonly ANSI_CYAN = "\u001B[36m";
  static readonly ANSI_WHITE = "\u001B[37m";

  protected static readonly STARTING_HEALTH: number = 55;
  protected readonly ATTACK_POW: number = 6;
  protected readonly ATTACK_PROB: number = 67;
  protected readonly CRITICAL_PROB: number = 0;
  protected readonly SHEILD_PROB: number = 0;

  private name: string;
  private health: number;
  private index: number;
  private color: string;

  protected readonly type: string = "Warrior";

  constructor(name: string = "Generic Warrior", index: number = 0, health: number = Warrior.STARTING_HEALTH, color: string = "White") {
    this.name = name
    this.health = health
    this.index = index;
    this.color = Warrior.getColorCode(color);
  }

  getName(): string {
    return this.name;
  }

  getHealth(): number {
    return this.health;
  }

  getIndex(): number {
    return this.index;
  }

  getColor(): string {
    return this.color;
  }

  printName(): string {
    return this.color + this.name + Warrior.ANSI_RESET
  }

  getAttackPow(): number {
    return this.ATTACK_POW;
  }

  getAttackProb(): number {
    return this.ATTACK_PROB;
  }

  getCriticalProb(): number {
    return this.CRITICAL_PROB;
  }

  getSheildProb(): number {
    return this.SHEILD_PROB;
  }

  getType(): string {
    return this.type
  }

  getHealthBar(): string {
    return "|".repeat(this.health)
  }

  set setIndex(i: number) {
    this.index = i;
  }

  battleCry(): string {
    return "From Middle Earth!!!";
  }

  async attack(opponent: Warrior, delay = 1000, verbose = true) {
    let roll: number = Math.floor(Math.random() * 100) + 1;

    if (verbose) console.log(`${this.printName()} is attacking ${opponent.printName()}!`)

    await Warrior.sleep(delay)

    let msg: string;
    let damage: number = 0;

    if (roll <= this.getCriticalProb()) {
      msg = `${this.printName()} ${this instanceof Elf ? "shoots an arrow" : "throws an axe"} and scores a CRITICAL HIT on ${opponent.printName()}!`

      damage = this.getAttackPow() * 2
    } else if (roll <= this.getAttackProb()) {
      let defense: number = Math.floor(Math.random() * 100) + 1;

      if (defense <= opponent.getSheildProb()) {
        msg = `${this.printName()} blocks ${opponent.printName()}'s attack!`
      } else {
        msg = `${this.printName()} successfully attacks ${opponent.printName()}!`
        damage = this.getAttackPow();
      }
    } else {
      msg = `${this.printName()}'s attack has failed.`;
    }

    if (verbose) console.log(msg);
    opponent.health -= damage;
    Warrior.sleep(delay)
  }

  static async sleep(milli: number) {
    return new Promise((resolve) => setTimeout(resolve, milli));
  }

  static getColorCode(name: string) {
    const map = {
      "Black": Warrior.ANSI_BLACK,
      "White": Warrior.ANSI_WHITE,
      "Red": Warrior.ANSI_RED,
      "Yellow": Warrior.ANSI_YELLOW,
      "Green": Warrior.ANSI_GREEN,
      "Blue": Warrior.ANSI_BLUE,
      "Purple": Warrior.ANSI_PURPLE,
      "Cyan": Warrior.ANSI_CYAN,
    }
    if (!map[name]) return map["White"]
    return map[name];
  }

  initWarrior(type: string = "Warrior", name: string = "", index: number = 0) {
    const map = {
      "Warrior": new Warrior(name, index),
      "Elf": new Elf(name, index),
      "Dwarf": new Dwarf(name, index),
      "Man": new Man(name, index),
      "GondorMan": new GondorMan(name, index),
      "RohanMan": new RohanMan(name, index),
    }
    if (!map[type]) return map["Warrior"]
    return map[type]
  }
}

class Elf extends Warrior {

  protected static readonly STARTING_HEALTH: number = 70;
  protected readonly ATTACK_POW: number = 4;
  protected readonly ATTACK_PROB: number = 83;
  protected readonly CRITICAL_PROB: number = 17;
  protected readonly SHEILD_PROB: number = 0;

  protected readonly type: string = "Elf";

  constructor(name: string = "Generic Elf", index: number = 0, health: number = Elf.STARTING_HEALTH, color: string = "White") {
    super(name, index, health, color)
  }

  getAttackPow(): number {
    return this.ATTACK_POW;
  }

  getAttackProb(): number {
    return this.ATTACK_PROB;
  }

  getCriticalProb(): number {
    return this.CRITICAL_PROB;
  }

  getSheildProb(): number {
    return this.SHEILD_PROB;
  }

  getType(): string {
    return this.type
  }

  battleCry(): string {
    return "Tomorrow, a red moon rises!";
  }
}

class Dwarf extends Warrior {

  protected static readonly STARTING_HEALTH: number = 60;
  protected readonly ATTACK_POW: number = 7;
  protected readonly ATTACK_PROB: number = 50;
  protected readonly CRITICAL_PROB: number = 33;
  protected readonly SHEILD_PROB: number = 0;

  protected readonly type: string = "Dwarf";

  constructor(name: string = "Generic Dwarf", index: number = 0, health: number = Dwarf.STARTING_HEALTH, color: string = "White") {
    super(name, index, health, color)
  }

  getAttackPow(): number {
    return this.ATTACK_POW;
  }

  getAttackProb(): number {
    return this.ATTACK_PROB;
  }

  getCriticalProb(): number {
    return this.CRITICAL_PROB;
  }

  getSheildProb(): number {
    return this.SHEILD_PROB;
  }

  getType(): string {
    return this.type
  }

  battleCry(): string {
    return "For Moria!!";
  }
}