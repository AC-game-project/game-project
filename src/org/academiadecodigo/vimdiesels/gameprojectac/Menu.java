package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Rectangle rectangle;
    private Picture background;
    public Picture play;
    public Picture planet;

    private Text pressToEnter;

    private boolean spaceStart;
    private Game game;


    public Menu() {


        this.play = new Picture(175, 400, "resources/play_buttons_pressed_blue.png");
        this.pressToEnter = new Text(235, 650, "Press Space button to Start.");
        this.planet = new Picture(260, 50, "resources/planet sprite- purple- by alpha_rats copy.png");

        this.spaceStart = false;
    }


    public void start() {

        // Button Play
        play.draw();

        //Planet Image
        planet.draw();

        //Sentence press to start
        pressToEnter.setColor(Color.GREEN);
        pressToEnter.draw();
        pressToEnter.grow(20, 15);

    }

    public void hideMenu(){

        // Button Play
        this.play.delete();

        //Planet Image
        this.planet.delete();

        //Sentence press to start
        this.pressToEnter.delete();

    }

    public boolean isSpaceStart() {
        return this.spaceStart;
    }

}


