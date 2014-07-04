package geek.livingstone.problems.arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * 
 * @author emmanuel
 *
 */
public class CircularTour {
  public static int find(PetrolPump[] arr) {
    int i=0, j=1;
    int cur_petrol = arr[i].petrol - arr[i].distToNextPump;
    while (i != j || cur_petrol < 0) {
      while (cur_petrol < 0 && i != j) {
        cur_petrol -= (arr[i].petrol - arr[i].distToNextPump);
        i = (i+1) % arr.length;
        if (i == 0)
          return -1;
      }
      cur_petrol += (arr[j].petrol - arr[j].distToNextPump);
      j = (j+1) % arr.length;
    }
    return i;
  }

  public static void main(String[] args) {
    PetrolPump[] arr = new PetrolPump[] {new PetrolPump(6,4), new PetrolPump(3,6), new PetrolPump(7,3)};
    System.out.println(find(arr));
  }

  private static class PetrolPump {
    int petrol;
    int distToNextPump;
    public PetrolPump(int petrol, int distToNextPump) {
      super();
      this.petrol = petrol;
      this.distToNextPump = distToNextPump;
    }
  }
}
