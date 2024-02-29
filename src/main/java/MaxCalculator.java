public class MaxCalculator<T extends Comparable<T>> {
  public T max(T[] list) {
    T max = list[0];
    for (T o: list) {
      if (o.compareTo(max) > 0) {
        max = o;
      }
    }
    return max;
  }
  public static void main(String[] args) {
    Integer[] numbers = new Integer[]{5, 20, 3, -5, 7};
    System.out.println("Max of array is ="
        + new MaxCalculator<Integer>().max(numbers));
  }
}

