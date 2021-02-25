class Man extends Warrior {

  protected static readonly STARTING_HEALTH: number = 55;
  protected readonly ATTACK_POW: number = 6;
  protected readonly ATTACK_PROB: number = 67;
  protected readonly CRITICAL_PROB: number = 0;
  protected readonly SHEILD_PROB: number = 17;

  protected readonly type: string = "Man";

  constructor(name: string = "Generic Man", index: number = 0, health: number = Man.STARTING_HEALTH, color: string = "White") {
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
    return "Oh man...";
  }
}

class GondorMan extends Man {

  protected static readonly STARTING_HEALTH: number = 60;
  protected readonly ATTACK_POW: number = 5;
  protected readonly ATTACK_PROB: number = 67;
  protected readonly CRITICAL_PROB: number = 0;
  protected readonly SHEILD_PROB: number = 33;

  protected readonly type: string = "Gondor Man";

  constructor(name: string = "Generic Gondor Man", index: number = 0, health: number = GondorMan.STARTING_HEALTH, color: string = "White") {
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
    return "Oh man...";
  }
}

class RohanMan extends Man {

  protected static readonly STARTING_HEALTH: number = 75;
  protected readonly ATTACK_POW: number = 4;
  protected readonly ATTACK_PROB: number = 83;
  protected readonly CRITICAL_PROB: number = 0;
  protected readonly SHEILD_PROB: number = 17;

  protected readonly type: string = "Rohan Man";

  constructor(name: string = "Generic Rohan Man", index: number = 0, health: number = RohanMan.STARTING_HEALTH, color: string = "White") {
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
    return "In Rohan, we ride horses and fight!";
  }
}