package Factory;

import Figures.Coordinate;
import Figures.Figure;
import Figures.Polygon;

import java.util.ArrayList;

public class PolygonFactory implements FigureFactory{
    @Override
    public Figure createFigure(ArrayList<Coordinate> coordinates) {
        return new Polygon(coordinates);
    }
}
