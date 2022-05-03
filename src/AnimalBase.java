import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class AnimalBase {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);
        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }


    public int getAnimalCount() {
        return animals.size();
    }

    public void sortBy(String sortBy, SortDirection sortDirection) {

        Comparator<Animal> comparator;

        switch (sortBy) {
            case "age" -> {
                comparator = new AgeComparator();
                animals.sort(comparator);
            }
            case "type" -> {
                comparator = new TypeComparator();
                animals.sort(comparator);
            }
            case "weight" -> {
                comparator = new WeightComparator();
                animals.sort(comparator);
            }
            default -> {
                comparator = new NameComparator();
                animals.sort(comparator);
            }
        }

          if (sortDirection == SortDirection.DESC) {
              Collections.reverse(animals);

          } else if (sortDirection == SortDirection.TOGGLE){
              // skal huske om sidste sortering var asc eller desc?
              Collections.reverse(animals);
          }

        System.out.println("Sort the list of animals by: " + sortBy);
    }

    public void createNewAnimal(String name, String description, String type, int age, double weight) {
        Animal animal = new Animal(name,description,type,age,weight);
        animals.add(animal);
    }

    public boolean deleteAnimal(String name) {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            return false;
        } else {
            animals.remove(animal);
            return true;
        }
    }

    private Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public void saveDatabase() {

    try{
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveAnimalsToFile(animals);
    } catch (DatabaseException exception ){
        System.err.println("Could not save to file");
    }

    }

    public void loadDatabase() {
        FileHandler fileHandler = new FileHandler();
        // animals.addAll(fileHandler.loadAnimalsFromFile()); // hver gang vi loader bliver listen længere og længere!
        animals = fileHandler.loadAnimalsFromFile(); // kan slette dyr vi har lavet manuelt
    }
}
