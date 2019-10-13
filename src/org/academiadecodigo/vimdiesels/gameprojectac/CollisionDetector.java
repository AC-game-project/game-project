package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class CollisionDetector {

    private Player player;

    public CollisionDetector(Player player) {

        this.player = player;
    }

    public boolean doOverlap(Enemy enemy) {
        // TODO: 13/10/2019 check reverse places between player and enemy pictures
        if (!enemy.isDestroyed() && player.getPlayerPicture().getX() < (enemy.getEnemyPicture().getX() + enemy.getEnemyPicture().getWidth()) &&
                (player.getPlayerPicture().getX() + player.getPlayerPicture().getWidth()) > enemy.getEnemyPicture().getX() &&
                player.getPlayerPicture().getY() < (enemy.getEnemyPicture().getY() + enemy.getEnemyPicture().getHeight()) &&
                (player.getPlayerPicture().getY() + player.getPlayerPicture().getHeight()) > enemy.getEnemyPicture().getY()) {

            enemy.setDestroyed();
            return true;
        }
        return false;
    }
}
