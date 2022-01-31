package com.salt.Game.Battle;

import com.salt.Game.Enemy.Enemy;
import com.salt.Game.Player.Player;

import java.util.Scanner;

public class Battle {
    boolean playerTurn;
    boolean enemyTurn;
    boolean isDuel;
    public Enemy enemy;
    private int choice;

    public Battle(String race, int base, int lvl, boolean isDuel) {
        this.enemy = new Enemy(race, base, lvl);
        if (Player.stats.getSpd() > enemy.stat.getSpd()) {
            playerTurn = true;
        } else {
            enemyTurn = true;
        }
        this.isDuel = isDuel;
    }

    private int playerTurn() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What would you like to do? (1 - attack; 2 - defend; 3 - heal; 4 - run): ");
        return scan.nextInt();
    }


    public void battleScene() {
        String r1 = "You attack the " + enemy.race + " for " + (Player.stats.getAtk() - enemy.stat.getDef()) + " dmg!";
        String r2 = "The " + enemy.race + " attacks you for " + (enemy.stat.getAtk() - Player.stats.getDef()) + " dmg!";
        String r3 = "The " + enemy.race + "dealt no damage!";
        String r4 = "Your attack was too weak!";
        String r5 = "You successfully defend the " + enemy.race + "'s attack!";
        String r6 = "You fail to defend against the " + enemy.race + "'s attack!";
        String r7 = "The " + enemy.race + " attacks you for " + (enemy.stat.getAtk() - Player.stats.getDef()) + " dmg!";
        String r8 = "The " + enemy.race + " dealt no damage!";
        choice = playerTurn();
        while (!isDead()) {
            if (choice == 1) {
                if (Player.stats.getAtk() >= enemy.stat.getDef()) {
                    enemy.stat.HP -= (Player.stats.getAtk() - enemy.stat.getDef());
                    System.out.println(r1);
                    if (isDead()) { break; }
                    if (enemy.stat.getAtk() >= Player.stats.getDef()) {
                        System.out.println(r2);
                        if (isDead()) { break; }
                    } else {
                        System.out.println(r3);
                    }
                } else {
                    System.out.println(r4);
                }
            } if (choice == 2) {
                if (Chance.oneInTen()) {
                    System.out.println(r5);
                } else {
                    System.out.println(r6);
                    if (enemy.stat.getAtk() >= Player.stats.getDef()) {
                        System.out.println(r7);
                        if (isDead()) { break; }
                    } else {
                        System.out.println(r8);
                    }
                }
            } if (choice == 3) {
                System.out.println("You open your inventory");
            } if (choice == 4 && !isDuel) {
                if (Player.stats.getSpd() > enemy.stat.getSpd() && Chance.oneInTwenty()) {
                    System.out.println("You ran away!");
                    break;
                } else {
                    System.out.println("You failed to run away!");
                }
            } if (choice == 4 && isDuel) {
                System.out.println("You cannot run away from a duel!");
            }
            choice = playerTurn();
        }
    }

    public boolean isDead() {
        if (enemy.stat.HP <= 0) {
            return true;
        } else if (Player.stats.HP <= 0) {
            return true;
        }
        return false;
    }
}
