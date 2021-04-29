public class ColisionCheck {
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    ColisionCheck(int width, int height)
    {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
    }
    public boolean checkCollisions(int bodyParts, int x[], int y[]) {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                return false;
            }
        }

        //check if head touches left border
        if(x[0] < 0) {
            return false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            return false;
        }

        //check if head touches top border
        if(y[0] < 0) {
            return false;
        }

        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            return false;
        }
        return true;
    }


}
