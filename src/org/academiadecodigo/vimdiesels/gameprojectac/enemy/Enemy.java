package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.GameConfig;

public class Enemy {


    private boolean destroyed;
    private Picture enemyPicture;


    public Enemy (int random) {

        this.enemyPicture = new Picture( random, -GameConfig.ENEMIES_SIZE, "resources/asteroid01.png");
        enemyPicture.draw();
    }

    public void move() {

        //method to move down the enemy or asteroid
        enemyPicture.translate(0, 1);
    }


    public Picture getEnemyPicture() {
        return enemyPicture;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void hit () {
        destroyed = true;
        return;
    }

}
