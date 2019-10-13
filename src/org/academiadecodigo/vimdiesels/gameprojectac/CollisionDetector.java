package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;

public class CollisionDetector {

    private Picture picture;
    private Player player;
    private Enemy enemy;
    private boolean crashed;
    private Rectangle bumper;


    public CollisionDetector (Player player) {

      this.player = player;
      //  this.bumper = new Rectangle(player.getPlayerPicture().getX(), player.getPlayerPicture().getY(), player.getPlayerPicture().getWidth(), player.getPlayerPicture().getHeight());
        this.crashed = false;

       // this.enemy = enemy;
      //  bumper.setColor(Color.GREEN);
        //bumper.draw();
    }



    public boolean doOverlap(Enemy enemy) {


        if (player.getPlayerPicture().getX() < (enemy.getEnemyPicture().getX() + enemy.getEnemyPicture().getWidth()) &&
                (player.getPlayerPicture().getX() + player.getPlayerPicture().getWidth()) > enemy.getEnemyPicture().getX() &&
                player.getPlayerPicture().getY() < (enemy.getEnemyPicture().getY() + enemy.getEnemyPicture().getHeight()) &&
                (player.getPlayerPicture().getY() + player.getPlayerPicture().getHeight()) > enemy.getEnemyPicture().getY()) {

            return true;
        }


        return false;
    }


}
