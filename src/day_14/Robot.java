package day_14;

public class Robot {
    private int[] position;
    private int[] velocity;

    public Robot(String line) {
        CreateRobot(line);
    }

    public void CreateRobot(String line) {
        line = line.replace("p=", "").replace("v=", "");
        String[] split = line.split(" ");
        String[] pos = split[0].split(",");
        String[] vel = split[1].split(",");

        this.position = new int[]{Integer.parseInt(pos[0]), Integer.parseInt(pos[1])};
        this.velocity = new int[]{Integer.parseInt(vel[0]), Integer.parseInt(vel[1])};
    }

    public void update(int WIDTH, int HEIGHT) {
        nextPosition();

        if(!isOnMap(WIDTH, HEIGHT)) {
            if(getPosition()[0] >= WIDTH || getPosition()[0] < 0) {
                getPosition()[0] = (getPosition()[0] + WIDTH) % WIDTH;
            }
            if(getPosition()[1] >= HEIGHT || getPosition()[1] < 0) {
                getPosition()[1] = (getPosition()[1] + HEIGHT) % HEIGHT;
            }
        }

    }

    public boolean isOnMap(int WIDTH, int HEIGHT) {
        return getPosition()[0] >= 0 && getPosition()[0] < WIDTH && // possible mistake width and height
                getPosition()[1] >= 0 && getPosition()[1] < HEIGHT;
    }

    public void nextPosition() {
        this.getPosition()[0] += getVelocity()[0];
        this.getPosition()[1] += getVelocity()[1];
    }

    public int[] getPosition() {
        return position;
    }

    public int[] getVelocity() {
        return velocity;
    }
}
