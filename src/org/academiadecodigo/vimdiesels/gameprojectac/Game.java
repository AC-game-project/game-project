package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class Game {

    private static final double PADDING = 10;
    private int score;

    private Rectangle canvasSize;
    private Picture background;
    private Position canvasPosition;

    private Menu menu;
    private Player player;
    private Enemy enemy;


    public Game(){

        this.score = 0;
        this.player = new Player();
        this.canvasSize = new Rectangle(PADDING, PADDING, 600, 900);
        this.background = new Picture(PADDING, PADDING, "resources/Stars Small_1v02.png");

    }

    public void init(){

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();
        this.canvasPosition = new Position(canvasSize);
        //create menu

    }


    public void start(){



        background.load("resources/Stars Small_1v02.png");
        background.draw();

        //player.init();
        menu = new Menu();
        menu.start();
        //iniciate enemies

    }

    public Menu createMenu(){

        //inicialize a new StartMenu;
        // menu show();
        return null;
    }

    public Enemy createEnemy(){

        //asks EnemyFactory for new enemy;
        //this.enemy = EnemyFactory.getNewEnemy();
        // enemy.show();
        return null;
    }

    public void enemyTracker(){

        //when enemy passes our max y , it hides and score increseases;
        //enemy.hide();
        //score += 10;

    }

    public void changeLevel(){

        //makes enemies move faster
        //creates more enemies?

    }

    public void gameOver(){

        // relate with score control
        // go back no start menu
    }

    public void gameExit(){

        // is it needed?
        //hides everything
        // maybe funny see ya later background
    }

}
