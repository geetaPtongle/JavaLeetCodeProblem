package daynamic_programin;

public class NoOfUniqueWays {
    public int countWays(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        int right =countWays(i, j+1, m,n);
        int down =countWays(i+1, j, m,n);

        return right + down;
    }

    public static void main(String[] args) {
        NoOfUniqueWays obj = new NoOfUniqueWays();

        System.out.println(obj.countWays(0,0,3,3 ));
    }
}
