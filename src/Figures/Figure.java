package Figures;

import Interface.IChangeable;

import java.util.ArrayList;

public abstract class Figure implements IChangeable {
    ArrayList<Coordinate> coordinates;
    private double centerX;
    private double centerY;


    public Figure(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    // пользователем указывается дистанция перемещения
    public void move(double distanceX, double distanceY) {
        for (Coordinate coordinate : coordinates) {
            double x = coordinate.getX() + distanceX;
            double y = coordinate.getY() + distanceY;
            coordinate.setX(x);
            coordinate.setY(y);
        }
    }

    //вычисление площади любого многоугольника по координатам
    public double calculateArea() {
        double x = 0;
        double y = 0;
        for (int i = 0; i < coordinates.size() - 1; i++) {
            x = x + coordinates.get(i).getX() * coordinates.get(i + 1).getY();
            y = y + coordinates.get(i).getY() * coordinates.get(i + 1).getX();
        }
        return Math.abs(x - y) / 2;
    }

    //вычисление расстояния между координатами по формуле корень из суммы квадратов разностей
    public double calculateSide(Coordinate coordinate1, Coordinate coordinate2) {
        return (Math.pow(Math.pow(coordinate2.getX() - coordinate1.getX(), 2) + Math.pow(coordinate2.getY() - coordinate1.getY(), 2), 0.5));
    }
    // вычисление центра фигуры для многоугольников с четным кол-вом вершин -> координаты между противоположными вершинами
    // для многоугольников с нечетным кол-вом вершин -> точка пересечения медиан
    private double calculateCenterX() {
        if (coordinates.size() % 2 == 0) {
            centerX = (coordinates.get(0).getX() + coordinates.get((coordinates.size() + 1) / 2).getX()) / 2;
        }
        else {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                centerX = centerX + coordinates.get(i).getX();
            }
            centerX = centerX / coordinates.size();
        }
        return centerX;
    }
    private double calculateCenterY() {
        if (coordinates.size() % 2 == 0) {
            centerY = (coordinates.get(0).getY() + coordinates.get((coordinates.size() + 1) / 2).getY()) / 2;
        }
        else {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                centerY = centerY + coordinates.get(i).getY();
            }
            centerY = centerY / coordinates.size();
        }
        return centerY;
    }
    // поворот фигуры относительно её центра
    public void rotate(double angle) {
        double radians = Math.toRadians(angle);
        for (Coordinate coordinate : coordinates) {
            double x = (coordinate.getX() * Math.cos(radians) - coordinate.getY() * Math.sin(radians)) + centerX;
            double y = (coordinate.getX() * Math.sin(radians) + coordinate.getY() * Math.cos(radians)) + centerY;
            coordinate.setX(x);
            coordinate.setY(y);
        }
    }

    // увеличение/уменьшение фигуры в значение scale
    // границы фигуры раздвигаются от центра на столько, чтобы площадь фигуры изменилась в значении scale
    public void scaleChange(double scale){
        double x;
        double y;
        for (Coordinate coordinate : coordinates) {
            x = ((coordinate.getX() - calculateCenterX()) * Math.sqrt(scale)) - (coordinate.getX() - calculateCenterX());
            y = ((coordinate.getY() - calculateCenterY()) * Math.sqrt(scale)) - (coordinate.getY() - calculateCenterY());
            if (x < calculateCenterX()) {
                x = coordinate.getX() - x;
            }
            else {
                x = coordinate.getX() + x;
            }
            if (y < calculateCenterY()) {
                y = coordinate.getY() - y;
            }
            else {
                y = coordinate.getY() + y;
            }

            coordinate.setX(x);
            coordinate.setY(y);
        }
    }

}
