package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private int points;
    Text score;

    public void init() {
        score = new Text(108, 98, "000");
        score.setColor(Color.GRAY);
        score.grow(20,20);
        score.draw();
    }

    public int getPoints() {
        return points;
    }

    public void setScore(int points) {

        score.setText( String.valueOf( this.points += points ) );
    }

}
