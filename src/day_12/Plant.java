package day_12;

import java.util.Objects;

public class Plant {
    char plant;
    int x;
    int y;

    public Plant(char plant, int x, int y) {
        this.plant = plant;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Plant plant = (Plant) o;
            return x == plant.x && y == plant.y;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
