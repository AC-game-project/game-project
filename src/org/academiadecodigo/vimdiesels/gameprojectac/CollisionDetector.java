package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class CollisionDetector {

    private Player player;

    private boolean alreadyCollided;

    public CollisionDetector(Player player) {

        this.player = player;
        this.alreadyCollided = false;
    }

    public boolean doOverlap(Enemy enemy) {

        if (!enemy.isDestroyed() && player.getPlayerPicture().getX() < (enemy.getEnemyPicture().getX() + enemy.getEnemyPicture().getWidth()) &&
                (player.getPlayerPicture().getX() + player.getPlayerPicture().getWidth()) > enemy.getEnemyPicture().getX() &&
                player.getPlayerPicture().getY() < (enemy.getEnemyPicture().getY() + enemy.getEnemyPicture().getHeight()) &&
                (player.getPlayerPicture().getY() + player.getPlayerPicture().getHeight()) > enemy.getEnemyPicture().getY()) {
            System.out.println("collision");
            //enemy.getEnemyPicture().delete();
            enemy.setDestroyed();

            return true;
        }

        return false;
    }

    public boolean isAlreadyCollided() {
        return alreadyCollided;
    }
}
