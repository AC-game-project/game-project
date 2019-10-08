package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyFactory {

    private Position pos;
    private Picture picture;

    public Enemy getNewEnemy() {

        this.picture = new Picture(50, 10, "resources/Asteroid-A-10-00.png");
        return new Enemy();
    }
}





