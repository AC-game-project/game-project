package org.academiadecodigo.vimdiesels.gameprojectac.enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.Position;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class EnemyFactory {

    private Position pos;
    private Picture picture;

    public Enemy getNewEnemy() {

        this.picture = new Picture(50, 10, "resources/Asteroid-A-10-00.png");
        return new Enemy();
    }
}





