package day_06;

import shared.DataSet;

public class Navigator {
    Map map;
    Guard guard;

    public Navigator(DataSet file) {
        this.map = new Map(file.getLines());
//        printMap();
        this.guard = new Guard(findStartingPosition(file), "up");
//        printGuardPosition();
    }

    public void countX() {
        int count = 0;
        for(String line : map.map) {
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == 'X') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public void move() {
        while(isGuardOnMp()) {
            map.drawX(guard.getPosition());
            if(!map.isObstruction(guard.nextPosition())) {
                guard.updatePosition(guard.nextPosition());

            } else {
                guard.turnRight();
            }

        }
        map.drawX(guard.getPosition());
    }

    public boolean isGuardOnMp(){
        if(guard.position[0] > 0 && guard.position[0] < map.getColumns() - 1 &&
            guard.position[1] > 0 && guard.position[1] < map.getRows() - 1) {
            return true;
        }
        return false;
    }

    public int[] findStartingPosition(DataSet file) {
        for(int row = 0; row < file.getLines().size(); row++) {
            for(int col = 0; col < file.getLines().get(row).length(); col++) {
                if(file.getLines().get(row).charAt(col) == '^') {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public void printGuardPosition() {
        System.out.println(guard.position[0] + " " + guard.position[1]);
    }

    public void printMap() {
        for(String line : map.map) {
            System.out.println(line);
        }
    }
}
