import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {

  SortDirection sortDirection;

  public WeightComparator(SortDirection sortDirection){
    this.sortDirection = sortDirection;
  }

  @Override
  public int compare(Animal o1, Animal o2) {

    if (sortDirection == SortDirection.ASC){
      return (int) (o1.getWeight() - o2.getWeight());
    }
    else if (sortDirection == SortDirection.DESC){
      return (int) (o2.getWeight() - o1.getWeight());
    }
    else if ((sortDirection == SortDirection.TOGGLE)){
      // skal huske om sidste sortering var asc eller desc?
    }
    return 0;
  }
}

    //return Double.compare(o1.getWeight(), o2.getWeight());

    /*
      public int compare(Animal o1, Animal o2) {
    double delta = o1.getWeight() - o2.getWeight();

    if (delta > 0.00001) return 1;
    if (delta < 0.00001) return -1;
    return 0;

     */
