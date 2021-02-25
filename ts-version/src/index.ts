




function printHealths(combatants: Warrior[]): void {
  let maxs: number[] = combatants.map(w => {
    let numTabs: number = `${w.getName()} (${w.getType()})`.length / 8
    return Math.floor(numTabs) + 1
  })
  let maxTabs = maxs.reduce((prev, curr) => (prev > curr) ? prev : curr)

  let healthboard = combatants.map((w, i) => {
    return `${w.getIndex()} - ${w.printName()} (${w.getType()})${"\t".repeat(maxTabs - maxs[i])}${w.getHealthBar()}`
  })

  console.log("***HEALTHBOARD***\n", healthboard.join("\n"));
}