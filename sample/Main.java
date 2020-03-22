public class Main {

    public static void main(String[] args) {

        VisualML visualML = new VisualML("c:/users/bagal/desktop/data.txt"); //Initializes the object with desired data path.

        visualML.readRaw(); //Loads each line of the data file into VisualML raw value list.
        visualML.setArrays(); //Sets the X and Y array lengths to the same length of the raw value list.
        visualML.setCategoryArray(); //Sets the category length to the same length of the raw value list.

        //Loads x, y, and categories:
        visualML.loadX();
        visualML.loadY();
        visualML.loadCategories();

        visualML.showDistances(1, 2); //Shows the distances between experimental point and actual points.
        String category = visualML.predict(1, 2);

        System.out.println("Predicted category: " + category); //Displays predicted category:
    }
}