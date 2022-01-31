package com.salt.Game.Render.Scene;

import com.salt.Game.Battle.Battle;
import com.salt.Game.Render.Entity;

public class BattleScene {
    Battle battle;
    Entity enemyBar;
    Entity playerBar;
    Entity ActionBar;
    Entity HealBar;
    Entity Attack;
    Entity Defend;
    Entity Heal;
    Entity Run;

    public BattleScene(Battle battle) {
        this.battle = battle;
    }
    public void changeHpBar(int type) {
    }
}
