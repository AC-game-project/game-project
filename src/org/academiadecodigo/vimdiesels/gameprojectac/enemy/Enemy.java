package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.GameConfig;
import org.academiadecodigo.vimdiesels.gameprojectac.Score;

public class Enemy {


    private boolean destroyed;
    private Picture enemyPicture;


    public Enemy(int random) {

        this.destroyed = false;
        this.enemyPicture = new Picture(random, -GameConfig.ENEMIES_SIZE, "resources/asteroid01.png");
        enemyPicture.draw();

    }

    public void move(Score score) {

        //method to move down the enemy or asteroid
        if (!isDestroyed()) {
            enemyPicture.translate(0, 1);
            return;
        }

        enemyPicture.delete();

        if (isDestroyed() ) {
            score.setScore(10);
            System.out.println(score);
        }
        // set score
    }


    public Picture getEnemyPicture() {
        return enemyPicture;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    public void setDestroyed() {
        destroyed = true;
    }

}
