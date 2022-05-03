import java.util.Comparator;

public class NameComparator implements Comparator<Animal> {
  @Override
  public int compare(Animal o1, Animal o2) {
    return o1.getName().compareTo(o2.getName());
  }

  @Override
  public Comparator<Animal> reversed() {
    return Comparator.super.reversed();
  }
}
