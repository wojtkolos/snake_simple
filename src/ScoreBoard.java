import java.awt.*;

public class ScoreBoard
{
    static int SCREEN_WIDTH;
    static  int SCREEN_HEIGHT;

    ScoreBoard(int width, int height){
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
    }
    public void drawScore(Graphics g, int apples){
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        g.drawString("Score: "+apples, (SCREEN_WIDTH - metrics.stringWidth("Score: "+apples))/2, g.getFont().getSize());
    }

    public void drawEnd(Graphics g, int apples){
        //Score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = g.getFontMetrics(g.getFont());
        g.drawString("Score: "+apples, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+apples))/2, g.getFont().getSize());

        //Game Over text

        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }
}
