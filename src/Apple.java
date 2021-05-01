import java.util.Random;

public class Apple {
    int appleX;
    int appleY;
    Random random;

    //screen size
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    static int UNIT_SIZE;

    Apple(int width, int height, int unit_size){
        random = new Random();
        appleX = 0;
        appleY = 0;

        this.SCREEN_WIDTH = width;
        this.SCREEN_HEIGHT = height;
        this.UNIT_SIZE = unit_size;
    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }
}
