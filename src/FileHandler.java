import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {

  private AnimalBase animalBase;

  public FileHandler() {
    animalBase = new AnimalBase();
  }


  public ArrayList<Animal> loadAnimalsFromFile() {

    ArrayList<Animal> animals = new ArrayList<>();

    try{
      // Åbn en Scanner der læser fra csv-filen
      Scanner fileScanner = new Scanner(new File("animals.csv"));

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        Animal animal = readAnimal(line);
        animals.add(animal);
      }
    } catch (FileNotFoundException exception){
      DatabaseException databaseException = new DatabaseException();
      throw databaseException;
    }
    return animals;
  }


  public void saveAnimalsToFile(ArrayList<Animal> animals)  {

    try{
      PrintStream outputFile = new PrintStream("animals.csv");

      // Animal(String name, String desc, String type, int age, double weight)
      for (Animal animal : animals) {
        writeAnimal(outputFile, animal);
      }
      outputFile.close(); // lukke filen

    } catch (FileNotFoundException exception){
      DatabaseException databaseException = new DatabaseException();
      throw databaseException;
    }

  }

  private Animal readAnimal(String line){
    // Scan nu linjen igennem for hvert ;
    Scanner lineScanner = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);
   //System.out.println("TEST" + line);
    // og træk variablerne ud, i den rækkefølge de var skrevet
    String name = lineScanner.next();
    // evt: animal.setName(lineScanner.next());
    String description = lineScanner.next();
    String type = lineScanner.next();
    int age = lineScanner.nextInt();
    double weight = lineScanner.nextDouble();

    // Opret nyt objekt med de variabler
    Animal animal = new Animal(name, description, type, age, weight);

    return animal;
  }



  private void writeAnimal(PrintStream outputFile, Animal animal) {
    outputFile.print(animal.getName());
    outputFile.print(";");
    outputFile.print(animal.getDesc());
    outputFile.print(";");
    outputFile.print(animal.getType());
    outputFile.print(";");
    outputFile.print(animal.getAge());
    outputFile.print(";");
    outputFile.print(animal.getWeight());
    outputFile.print("\n");
  }
}