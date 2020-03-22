import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VisualML {

    public String dataPath; //Public global data path variable.
    public List<String> lines; //Raw data values before conversion.

    //X and Y value arrays:
    public double[] xVals;
    public double[] yVals;
    public String[] categories;

    //Constructor, sets data path when class is initialized:
    public VisualML(String _dataPath) {
        dataPath = _dataPath;
    }

    //Loads raw values into a list:
    public void readRaw() {
        try {
            Path path = Paths.get(dataPath);
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Sets the X and Y array lengths to the same length of the raw value list:
    public void setArrays() {
        int length = lines.size();
        xVals = new double[length];
        yVals = new double[length];
    }

    //Sets the category array to the length of the raw value list:
    public void setCategoryArray() {
        categories = new String[lines.size()];
    }

    //Loads X double values into array:
    public void loadX() {

        int i = 0;

        while (i < lines.size()) {
            String rawLine = String.valueOf(lines.get(i));
            String[] rawX = rawLine.split(", ");
            double x = Double.valueOf(rawX[0]);
            xVals[i] = x;
            i++;
        }
    }

    //Loads Y double values into array:
    public void loadY() {

        int i = 0;

        while (i < lines.size()) {
            String rawLine = String.valueOf(lines.get(i));
            String[] rawY = rawLine.split(", ");
            double y = Double.valueOf(rawY[1]);
            yVals[i] = y;
            i++;
        }
    }

    //Loads categories into category array:
    public void loadCategories() {

        int i = 0;

        while (i < lines.size()) {
            String rawLine = String.valueOf(lines.get(i));
            String[] rawCategory = rawLine.split(", ");
            String category = rawCategory[2];
            categories[i] = category;
            i++;
        }
    }

    //Shows the distance between an experimental point and actual points:
    public void showDistances(double x, double y) {

        System.out.println("Calculating for: (" + x + ", " + y + ")");

        //Uses the distance formula to find the distance away from each point:
        int i = 0;

        while (i < xVals.length) {

            double differenceX = x - xVals[i];
            double differenceY = y - yVals[i];
            differenceX = Math.pow(differenceX, 2);
            differenceY = Math.pow(differenceY, 2);
            double sum = differenceX + differenceY;
            double distance = Math.sqrt(sum);

            System.out.print("Distance from (" + xVals[i] + ", " + yVals[i] + "): ");
            System.out.println(distance);

            i++;
        }
    }

    //Returns the predicted category of an experimental point:
    public String predict(double x, double y) {

        Double[] distances = new Double[xVals.length];

        //Uses the distance formula to find the distance away from each point:
        int i = 0;

        while (i < xVals.length) {

            double differenceX = x - xVals[i];
            double differenceY = y - yVals[i];
            differenceX = Math.pow(differenceX, 2);
            differenceY = Math.pow(differenceY, 2);
            double sum = differenceX + differenceY;
            double distance = Math.sqrt(sum);

            distances[i] = distance;

            i++;
        }

        //Finds the smallest distance value:
        double minDistance = Double.MAX_VALUE;
        int distancesPosition = 0;

        int j = 0;
        while (j < distances.length) {
            if (distances[j] < minDistance) {
                minDistance = distances[j];
                distancesPosition = j;
            }
            j++;
        }

        //Returns category value:
        return categories[distancesPosition];
    }
}