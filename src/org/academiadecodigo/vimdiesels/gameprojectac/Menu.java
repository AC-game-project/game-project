package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {


    private static final double PADDING = 10;

    private Rectangle rectangle;
    private Picture background;
    private Picture play;
    private Picture planet;
    private Keyboard keyboard;
    private Text pressToEnter;


    public Menu(){

        this.rectangle = new Rectangle(PADDING, PADDING, 600, 900);
        this.background = new Picture(PADDING, PADDING, "resources/Stars Small_1v02.png");
        this.play = new Picture( 175, 400, "resources/play_buttons_pressed_blue.png");
        this.pressToEnter = new Text(235, 650, "Press Space button to Start.");
        this.planet = new Picture( 260, 50, "resources/planet sprite- purple- by alpha_rats copy.png");
        this.keyboard = new Keyboard(this);
    }


    public void start(){

        //Background color
        rectangle.setColor(Color.BLACK);
        rectangle.fill();

        //Background Image
        background.load("resources/Stars Small_1v02.png");
        background.draw();

        // Button Play
        play.load("resources/play_buttons_pressed_2.png");
        play.draw();

        //Planet Image
        planet.load("resources/planet sprite- purple- by alpha_rats copy.png");
        planet.draw();

        //Sentence press to start
        pressToEnter.setColor(Color.GREEN);
        pressToEnter.draw();
        pressToEnter.grow(20, 15);

        //Keyboard com
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);


    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            //game.start();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent var1){

    }
}


