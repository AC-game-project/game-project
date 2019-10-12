package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private static final int PADDING = 10;
    private boolean destroyed;
    private Picture enemyPicture;


    public Enemy (int random) {

        this.enemyPicture = new Picture(random, -64, "resources/design/Asteroids/Asteroid-A-10-00.png");
        //enemyPicture.load("resources/design/Asteroids/Asteroid-A-10-00.png");
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
