package Factory;

import Figures.Coordinate;
import Figures.Polygon;

import java.util.ArrayList;

public class PolygonFactory {
    public Polygon createPolygon(ArrayList<Coordinate> coordinates){
        return new Polygon(coordinates);
    }
}
