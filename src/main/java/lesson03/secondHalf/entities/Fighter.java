package lesson03.secondHalf.entities;

import lombok.Getter;

@Getter
public class Fighter {
    private final long code;
    private final String name;
    private int health;
    private int attack;

    public Fighter(long code, String name, int health, int attack) {
        if (code < 0) {
            throw new IllegalArgumentException("Enter valid code for fighter");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Enter valid fighter name");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Enter valid health amount");
        }
        if (attack < 0) {
            throw new IllegalArgumentException("Enter valid attack amount");
        }

        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public String getFighterInfo() {
        return "Fighter{" + "code=" + code + ", name='" + name + '\'' + ", health=" + health + ", attack=" + attack + '}';
    }
}
