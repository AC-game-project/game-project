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

    private Rectangle rectangle;
    private Picture background;
    private Picture play;
    private Picture planet;
    private Keyboard keyboard;
    private Text pressToEnter;

    private boolean spaceStart;
    private Game game;


    public Menu(Game game) {

        this.rectangle = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.background = new Picture(GameConfig.PADDING, GameConfig.PADDING, "resources/Stars Small_1v02.png");
        this.play = new Picture(175, 400, "resources/play_buttons_pressed_blue.png");
        this.pressToEnter = new Text(235, 650, "Press Space button to Start.");
        this.planet = new Picture(260, 50, "resources/planet sprite- purple- by alpha_rats copy.png");
        this.keyboard = new Keyboard(this);

        this.game = game;
        this.spaceStart = false;
    }


    public void start() {

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

    public void hideMenu(){

        //Background color
        this.rectangle.delete();

        //Background Image
        this.background.delete();

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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                try {
                hideMenu();
                    System.out.println("try");
                    spaceStart = true;
                    game.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;

            default:
                System.out.println("no energy!!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent var1) {

    }
}


