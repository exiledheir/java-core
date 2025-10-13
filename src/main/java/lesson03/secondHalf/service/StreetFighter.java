package lesson03.secondHalf.service;

import lesson03.secondHalf.entities.Fighter;

import java.util.Random;

public class StreetFighter {
    private final Random random = new Random();

    private Fighter[] fighters = new Fighter[16];
    private int current = 0;

    public void fight(long firstFighterCode, long secondFighterCode) {

        Fighter fighter1 = findFighter(firstFighterCode);
        Fighter fighter2 = findFighter(secondFighterCode);

        if (fighter1 == null) throw new IllegalArgumentException("Fighter1 not found");
        if (fighter2 == null) throw new IllegalArgumentException("Fighter2 not found");

        int originalFighter1Health = fighter1.getHealth();
        int originalFighter2Health = fighter2.getHealth();

        int fighter1Health = fighter1.getHealth();
        int fighter2Health = fighter2.getHealth();

        int attacker = random.nextInt(2) + 1;
        int damage = 0;

        while (fighter1Health > 0 && fighter2Health > 0) {
            if (attacker == 1) {
                damage = random.nextInt(fighter1.getAttack()) + 1;
                fighter2Health -= damage;
                System.out.println(fighter1.getName() + " deals " + damage + " damage to " + fighter2.getName() + ". " + fighter2.getName() + " health: " + Math.max(0, fighter2Health));
                if (fighter2Health <= 0) {
                    System.out.println(fighter1.getName() + " wins!");
                    break;
                }
                attacker = 2;
            } else {
                damage = random.nextInt(fighter2.getAttack()) + 1;
                fighter1Health -= damage;
                System.out.println(fighter2.getName() + " deals " + damage + " damage to " + fighter1.getName() + ". " + fighter1.getName() + " health: " + Math.max(0, fighter1Health));
                if (fighter1Health <= 0) {
                    System.out.println(fighter2.getName() + " wins!");
                    break;
                }
                attacker = 1;
            }

        }

        fighter1.setHealth(originalFighter1Health);
        fighter2.setHealth(originalFighter2Health);
    }

    public void addFighter(Fighter fighter) {
        if (fighter == null) throw new IllegalArgumentException("Fighter cant be null");

        if (findFighter(fighter.getCode()) != null)
            throw new IllegalArgumentException("Fighter with code " + fighter.getCode() + " already exists");

        if (current >= fighters.length) {
            Fighter[] newFighter = new Fighter[fighters.length * 2];
            for (int i = 0; i < current; i++) {
                newFighter[i] = fighters[i];
            }
            fighters = newFighter;
        }
        fighters[current++] = fighter;
    }

    public Fighter[] getFighters() {
        Fighter[] valid = new Fighter[current];

        for (int i = 0; i < current; i++) {
            valid[i] = fighters[i];
        }
        return valid;
    }

    private Fighter findFighter(long code) {
        for (int i = 0; i < current; i++) {
            if (fighters[i].getCode() == code) return fighters[i];
        }
        return null;
    }

    public void printAllFighters() {
        for (int i = 0; i < current; i++) {
            System.out.println(fighters[i].getFighterInfo());
        }
        System.out.println();
    }
}
