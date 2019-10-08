package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    public Menu menu;

    private Rectangle rectangle;
    private static final double PADDING = 10;

    //private Picture picture;
    private Picture background;
    private Picture play;
    private Picture exit;
    private Picture planet;


    public Menu(){

        this.rectangle = new Rectangle(PADDING, PADDING, 600, 900);
        this.background = new Picture(PADDING, PADDING, "resources/Stars Small_1v02.png");
        this.play = new Picture( 210, 120, "resources/play_buttons_pressed_blue.png");
        this.exit = new Picture( 210, 300, "resources/exit_buttons.png");
        this.planet = new Picture( 260, 50, "resources/planet sprite- purple- by alpha_rats copy.png");

    }

    public void start(){

        rectangle.setColor(Color.BLACK);
        rectangle.fill();

        //Background Image
        background.load("resources/Stars Small_1v02.png");
        background.draw();

        // Button Play
        play.load("resources/lay_buttons_pressed_blue.png");
        play.draw();

        //Button Exit
        exit.load("resources/exit_buttons.png");
        exit.draw();

        //Planet Image
        planet.load("resources/planet sprite- purple- by alpha_rats copy.png");
        planet.draw();

    }

}
