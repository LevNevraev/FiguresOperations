import Figures.Figure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileWithFigures {
    private static final Path FILE_WITH_FIGURES;
    private final static String NAME_OF_FILE_WITH_FIGURES = "FileWithFigures.txt";
    private static ArrayList<String> lines;

    static {
        FILE_WITH_FIGURES = Paths.get(FileWithFigures.NAME_OF_FILE_WITH_FIGURES);
        try {
            lines = (ArrayList<String>) Files.readAllLines(FILE_WITH_FIGURES);
        } catch (IOException e) {
            System.out.println("File with figures not found");
        }
    }

    public static void addFigureToFile(Figure figure) {
        lines.add(figure.getCoordinatesToString());
        try {
            Files.write(FILE_WITH_FIGURES, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
