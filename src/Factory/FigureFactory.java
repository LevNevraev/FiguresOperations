package Factory;

import Figures.Coordinate;
import Figures.Figure;

import java.util.ArrayList;

public interface FigureFactory {
    Figure createFigure(ArrayList<Coordinate> coordinates);
}
