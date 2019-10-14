package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture picture;
    private Sound shipEngine;

    public Player() {

        this.picture = new Picture((GameConfig.CANVAS_WIDTH / 2), (GameConfig.CANVAS_HEIGHT - 100), "resources/spaceship.png");
        shipEngine = new Sound("/resources/sound/slow-travel.wav");
        shipEngine.play(false);
    }

    public void init() {

        picture.draw();
    }

    public Picture getPlayerPicture() {

        return picture;
    }


    public void moveLeft() {

        if (picture.getX() >= picture.getWidth()) {
            picture.translate(-10, 0);
        }
    }

    public void moveRight() {

        if (picture.getX() <= (GameConfig.CANVAS_WIDTH - picture.getWidth())) {
            picture.translate(10, 0);
        }
    }
}
