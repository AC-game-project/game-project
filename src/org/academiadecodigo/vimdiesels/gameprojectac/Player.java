package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private Picture picture;
    private Keyboard keyboard;

    Sound shipEngine;

    public Player(){

        this.picture = new Picture(300, 800, "resources/spaceship.png");
        this.keyboard = new Keyboard(this);
        //shipEngine = new Sound("resources/sound/slow-travel.wav");
        //shipEngine.play(false);
    }

    public void init(){
        picture.draw();

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
    }
    public Picture getPlayerPicture() {
        return picture;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (picture.getX() >= picture.getWidth()) {
                    picture.translate(-10, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (picture.getX() <= 600 - picture.getWidth()) {
                    picture.translate(10, 0);
                }
                break;
            default:
                System.out.println("PROBLEMMMMM!!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
