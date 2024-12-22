package day_15;

import shared.DataSet;

import java.util.ArrayList;

public class Warehouse {
    ArrayList<String> map;
    ArrayList<Box> boxes;

    Robot robot;
    ArrayList<String> moves;

    public Warehouse(DataSet file) {
        createMap(file);
        setRobot();
        setBoxes();
    }

    public void moveBoxes(int[] startPos, char dir) {
        ArrayList<int[]> boxPositions = new ArrayList<>();
        int[] currentPos = startPos;

        while(CharAt(currentPos) == 'O') {
            boxPositions.add(currentPos);
            currentPos = nextPos(currentPos, dir);

            for(int i = boxPositions.size() - 1; i >= 0; i--) {
                int[] boxPos = boxPositions.get(i);
                int[] newPos = nextPos(boxPos, dir);
                updateMap(boxPos, newPos, 'O');
            }
        }
    }

    public void updateMap(int[] currentPos, int[] newPos, char sym) {
        setCharAt(currentPos, '.');
        setCharAt(newPos, sym);
    }

    public void moveRobot() {
        for(String s : moves) {
            for(Character c : s.toCharArray()) {

                System.out.println("move: " + c);
                while(true) {
                    int[] newPos = nextPos(new int[]{robot.getX(), robot.getY()}, c);
                    char field = CharAt(newPos);
                    System.out.println("Char at new pos: " + field);
                    if(field == '#') {
                        System.out.println("Robot: " + robot.getX() + ", " + robot.getY());
                        break;
                    } else if (field == 'O') {
                        if(!canMoveBox(newPos, c)) {
                            break;
                        }
                        moveBoxes(newPos, c);
                        updateMap(new int[]{robot.getX(), robot.getY()}, newPos, '@');
                        robot.setX(newPos[0]);
                        robot.setY(newPos[1]);
                        break;
                    } else if(field == '.'){
//                        robot.setX(newPos[0]);
//                        robot.setY(newPos[1]);
                        updateMap(new int[]{robot.getX(), robot.getY()}, newPos, '@');
                        robot.setX(newPos[0]);
                        robot.setY(newPos[1]);
                        System.out.println("zmienione: " + robot.getX() + ", " + robot.getY());
//                        updateMap(current, newPos, '@');
                        break;
                    }
                }

                printMap();
            }
        }
    }

    public boolean canMoveBox(int[] startPos, char dir) {
        int[] currentPos = startPos;
        while(true) {
            int[] nextPos = nextPos(currentPos, dir);
            char field = CharAt(nextPos);
            if(field == '#') {
                return false;
            } else if (field == '.') {
                return true;
            } else if (field != 'O') {
                return false;
            }
            currentPos = nextPos;
        }
    }

    public int[] nextPos(int[] pos, char dir) {
        switch (dir) {
            case 'v': pos[1]++; // down
                break;
            case '^': pos[1]--; // up
                break;
            case '<': pos[0]--; // left
                break;
            case '>': pos[0]++; // right
                break;
            default:
                break;
        }
        return pos;
    }

    public void setBoxes() {
        this.boxes = new ArrayList<>();
        for(int row = 0; row < map.size(); row++) {
            for(int col = 0; col < map.get(row).length(); col++) {
                if(map.get(row).charAt(col) == 'O') {
                    Box box = new Box(col, row); // x - col, y - row
                    System.out.println("Box: " + box.getX() + ", " + box.getY());
                    boxes.add(box);
                }
            }
        }
    }

    public void setRobot() {
        for(int row = 0; row < map.size(); row++) {
            for(int col = 0; col < map.get(row).length(); col++) {
                if(map.get(row).charAt(col) == '@') {
                    this.robot = new Robot(col, row); // x - col, y - row
                    System.out.println("Robot: " + robot.getX() + ", " + robot.getY());
                    return;
                }
            }
        }
    }

    public char CharAt(int[] pos) {
        return map.get(pos[1]).charAt(pos[0]);
    }

    public void setCharAt(int[] pos, char c) {
        StringBuilder row = new StringBuilder(map.get(pos[1]));
        row.setCharAt(pos[0], c);
        map.set(pos[1], row.toString());
    }

    public void printMap(){
        for(String s : map) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void createMap(DataSet file) {
        this.map = new ArrayList<>();
        this.moves = new ArrayList<>();
        for(String s : file.getLines()) {
            if(s.isEmpty()) {
                continue;
            }
            if(s.matches("[<^>v]+")) {
                moves.add(s);
                System.out.println("Moves" + s);
            } else {
                map.add(s);
                System.out.println(s);
            }
        }
    }
}
