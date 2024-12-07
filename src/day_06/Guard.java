package day_06;

public class Guard {
    int[] position;
    String direction;
    boolean isOnMap;

    public Guard(int[] position, String direction) {
        this.position = position;
        this.direction = direction;
        isOnMap = true;
    }

    public String getDirection() {
        return direction;
    }

    public int[] getPosition() {
        return position;
    }

    public void updatePosition(int[] newPosition) {
        this.position = newPosition;
    }

    public int[] nextPosition() {
        int[] newPos = position.clone();
        switch(direction) {
            case "up": newPos[0]--; break;
            case "down": newPos[0]++; break;
            case "right": newPos[1]++; break;
            case "left": newPos[1]--; break;
        }
        return newPos;
    }

    public void turnRight() {
        switch(direction) {
            case "up": direction = "right"; break;
            case "down": direction = "left"; break;
            case "right": direction = "down"; break;
            case "left": direction = "up"; break;
        }
    }
}
