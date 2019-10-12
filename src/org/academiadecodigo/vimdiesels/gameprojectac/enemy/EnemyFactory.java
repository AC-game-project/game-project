package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.GameConfig;
import org.academiadecodigo.vimdiesels.gameprojectac.Position;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class EnemyFactory {

    private static final int PADDING = 10;

    public static Enemy getNewEnemy() {

        //creates enemy and passes random int for x value
        int random = (PADDING) + (int)(Math.random() * (GameConfig.CANVAS_WIDTH - GameConfig.ENEMIES_SIZE) - PADDING + 1);
        return new Enemy(random);
    }
}





