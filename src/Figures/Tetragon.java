package Figures;

import java.util.ArrayList;

public class Tetragon extends Figure{
    private double length;
    private double height;

    public Tetragon(ArrayList<Coordinate> coordinates) {
        super(coordinates);
    }
/*
    public Tetragon(ArrayList<Coordinate> coordinates) {
        super(coordinates);
        //длина - расстояние между первой и второй заданной точкой, ширина - между второй и третьей
        this.length = calculateSide(coordinates.get(0), coordinates.get(1));
        this.height = calculateSide(coordinates.get(1), coordinates.get(2));
    }

    // вычисление площади перемножением длиены и высоты
    public double calculateArea(){
        return (length * height);
    }
*/
}
