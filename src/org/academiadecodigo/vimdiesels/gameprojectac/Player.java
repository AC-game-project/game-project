package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private int x;
    private int y;

    private Picture picture;
    private Keyboard keyboard;

    private Position position;


    public Player(){

        this.picture = new Picture(300, 850, "resources/f1.png");
        this.keyboard = new Keyboard(this);
        this.position = new Position();

        this.x = picture.getX();
        this.y = picture.getY();
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void init(){

        picture.load("resources/f1.png");
        picture.draw();


        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        /*KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED); */


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        //keyboard.addEventListener(up);
        //keyboard.addEventListener(down);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        //if condition to verify canvas limits and if ship can still move that way
        //red square over scrollbar example
        /*if (redSquare.getX() == 160){

            this.redSquare.translate(-10, 0);

            if(redSquare.getX() == 0){

                return;
            }*/

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                // if (this.redSquare.getX() <= this.scrollbar.getWidth() - this.redSquare.getWidth()) {
                this.picture.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:

                this.picture.translate(10, 0);
                break;
            case KeyboardEvent.KEY_UP:

                break;
            case KeyboardEvent.KEY_DOWN:

                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent var1){

    }
}
