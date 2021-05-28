package Figures;

import Interface.Movable;

import java.util.ArrayList;

public abstract class Figure implements Movable {
    ArrayList<Coordinate> coordinates;

    public Figure(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinate> getCoordinates() { return coordinates; }

    // пользователем указывается дистанция перемещения
    public void move(double distanceX, double distanceY){
        for (Coordinate coordinate: coordinates) {
            double x = coordinate.getX() + distanceX;
            double y = coordinate.getY() + distanceY;
            coordinate.setX(x);
            coordinate.setY(y);
        }
    }

    //вычисление площади любого многоугольника по координатам
    public double calculateArea(){
        double x = 0;
        double y = 0;
        for (int i = 0; i < coordinates.size() - 1; i++){
            x = x + coordinates.get(i).getX() * coordinates.get(i+1).getY();
            y = y + coordinates.get(i).getY() * coordinates.get(i+1).getX();
        }
        return Math.abs(x - y)/2;
    }

    //вычисление расстояния между координатами по формуле корень из суммы квадратов разностей
    public double calculateSide(Coordinate coordinate1, Coordinate coordinate2){
        return (Math.pow(Math.pow(coordinate2.getX() - coordinate1.getX(), 2) + Math.pow(coordinate2.getY() - coordinate1.getY(), 2), 0.5));
    }

}
