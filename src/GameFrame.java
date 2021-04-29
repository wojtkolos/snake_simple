import javax.swing.JFrame;

public class GameFrame extends JFrame
{
    GameFrame(int width, int height, int unit_size) {

        this.add(new GamePanel(width, height, unit_size));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
