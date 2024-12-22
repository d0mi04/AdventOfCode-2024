package day_14;

import shared.DataSet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Bathroom {
    private final static int WIDTH = 101; // input: 101, test: 11
    private final static int HEIGHT = 103; // input: 103, test: 7

    int[][] map;
    int[][] imageMap;
    ArrayList<Robot> robots;

    public Bathroom(DataSet file) {
        CreateRobotList(file);
        map = new int[WIDTH][HEIGHT];
        imageMap = new int[WIDTH][HEIGHT];
    }

    public void CreateImage(String filePath) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        for(int row = 0; row < HEIGHT; row++) {
            for(int col = 0; col < WIDTH; col++) {
                int color = (imageMap[col][row] == 0) ? Color.WHITE.getRGB() : Color.GREEN.getRGB();
                image.setRGB(col, row, color);
            }
        }

        try {
            File outputFile = new File(filePath);
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Obraz zapisany: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int SafetyFactor() {
        int[][] starts = {
                {0, 0},
                {0, WIDTH / 2 + 1},
                {HEIGHT / 2 + 1, WIDTH / 2 + 1},
                {HEIGHT / 2 + 1, 0}
        };

        int[][] ends = {
                {HEIGHT / 2, WIDTH / 2},
                {HEIGHT / 2, WIDTH},
                {HEIGHT, WIDTH},
                {HEIGHT, WIDTH / 2}
        };

        int safetyfactor = 1;
        for(int i = 0; i < starts.length; i++) {
            safetyfactor *= CountQuadrant(starts[i][0], ends[i][0], starts[i][1],  ends[i][1]);
        }

        return safetyfactor;
    }

    public int CountQuadrant(int startRow, int endRow, int startCol, int endCol) {
        int count = 0;

        for(int row = startRow; row < endRow; row++) {
            for(int col = startCol; col < endCol; col++) {
                count += map[col][row];
            }
        }
//        System.out.println("count: " + count);
        return count;
    }

    public void Calculate() {
        for (Robot r : robots) {
//            for(int i = 0; i < 100; i++) {
                r.update(WIDTH, HEIGHT);
//            }
        }
    }

    public void ProduceImage() {
        CreateMap();
        for(Robot r : robots) {
            imageMap[r.getPosition()[0]][r.getPosition()[1]] = 1;
        }
    }

    public void PlaceRobots() {
        CreateMap();
        for(Robot r : robots) {
            map[r.getPosition()[0]][r.getPosition()[1]]++;
        }
    }

//    public void printMap(){
//        for(int row = 0; row < HEIGHT; row++) {
//            for(int col = 0; col < WIDTH; col++) {
//                System.out.print(map[col][row] + " ");
//            }
//            System.out.println();
//        }
//    }

    public void CreateMap() {
        for(int row = 0; row < HEIGHT; row++) {
            for(int col = 0; col < WIDTH; col++) {
                map[col][row] = 0;
                imageMap[col][row] = 0;
            }
        }
//        System.out.println("Map created");
    }

    public void CreateRobotList(DataSet file) {
        robots = new ArrayList<>();
        for(String s : file.getLines()) {
            robots.add(new Robot(s));
        }
    }
}
