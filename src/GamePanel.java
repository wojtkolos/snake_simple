import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{
    static int SCREEN_WIDTH;
    static  int SCREEN_HEIGHT;
    static int UNIT_SIZE;

    static int GAME_UNITS;

    static final int DELAY = 175;

    int x[];
    int y[];

    int bodyParts = 6;

    int applesEaten;

    char direction = 'R';

    boolean running = false;

    Timer timer;

    Apple apple;

    ColisionCheck colisionCheck;

    ScoreBoard scoreBoard;

    GamePanel(int width, int height, int unit_size){

        apple = new Apple(width, height, unit_size);
        colisionCheck = new ColisionCheck(width, height);
        scoreBoard = new ScoreBoard(width, height);

        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
        UNIT_SIZE = unit_size;

        GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);

        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();

    }

    public void startGame() {
        apple.newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if(running) {

            //remove after
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}



            g.setColor(Color.red);
            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< bodyParts;i++) {

                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            scoreBoard.drawScore(g, applesEaten);

        }
        else {
            gameOver(g);
        }
    }

    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;

            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;

            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;

            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if((x[0] == apple.getAppleX()) && (y[0] == apple.getAppleY())) {
            bodyParts++;
            applesEaten++;
            apple.newApple();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkApple();
            if(!colisionCheck.checkCollisions(bodyParts, x, y))
                timer.stop();
        }
        repaint();
    }



    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;

                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                case KeyEvent.VK_SPACE:
                    if(!running)
                        startGame();
                    break;
            }
        }
    }


    public void gameOver(Graphics g) {
        scoreBoard.drawEnd(g, applesEaten);
    }
}
