package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.vimdiesels.gameprojectac.GameConfig;

public class EnemyFactory {

    public static Enemy getNewEnemy() {

        int random = (GameConfig.PADDING + 5) + (int) (Math.random() * (GameConfig.CANVAS_WIDTH - GameConfig.ENEMIES_SIZE) - GameConfig.PADDING + 1);
        return new Enemy(random);
    }
}





