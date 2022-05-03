import java.util.Comparator;

public class AgeComparator implements Comparator<Animal> {

  @Override
  public int compare(Animal o1, Animal o2) {
    return o1.getAge() - o2.getAge();
  }

  @Override
  public Comparator<Animal> reversed() {
    return Comparator.super.reversed();
  }
}
