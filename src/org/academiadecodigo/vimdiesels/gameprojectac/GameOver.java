package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

    private Rectangle gameOverBackground;
    private Picture gameOverPic;
    private Picture planet;
    private Picture gameOverText;

    public GameOver() {

        this.gameOverBackground = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.gameOverBackground.fill();

        this.planet =  new Picture(40, 30, "resources/planet.png");
        this.planet.draw();

        this.gameOverPic = new Picture(GameConfig.PADDING, GameConfig.PADDING, "resources/Stars Small_1v02.png");
        this.gameOverPic.draw();

        this.gameOverText = new Picture((GameConfig.CANVAS_WIDTH / 2) - 126 + GameConfig.PADDING, (GameConfig.CANVAS_HEIGHT / 2) - 137, "resources/game-over.png");
        this.gameOverText.draw();
    }

}
