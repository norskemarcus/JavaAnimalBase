import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {
  @Override
  public int compare(Animal o1, Animal o2) {
    return (int) (o1.getWeight() - o2.getWeight());

  }

  @Override
  public Comparator<Animal> reversed() {
    return Comparator.super.reversed();
  }


}
