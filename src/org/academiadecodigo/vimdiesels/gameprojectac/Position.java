package org.academiadecodigo.vimdiesels.gameprojectac;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    private Player player;
    private Enemy enemy;
    private Rectangle canvas;

    public Position(){
        this.player = player;
    }

    public Position(Rectangle canvas){

        this.canvas = canvas;
        this.maxX = canvas.getWidth();
        this.maxY = canvas.getHeight();
    }

    public Position(Enemy enemy){
        this.enemy = enemy;
    }

    /*private void moveLeft(int dist) {
        minX = canvas.getX();
        int maxPixelsLeft = player.getX() - minX;
       player.

        moveTo(getCol() - maxRowsLeft, getRow());
    }

    private void moveRight(int dist) {
        int maxRowsRight = Math.min(getGrid().getCols() - (getCol() + 1), dist);
        moveTo(getCol() + maxRowsRight, getRow());
    }*/

}
