import java.util.Arrays;

public class LengthComparator implements NullSafeStringComparator {

    public static String[][] step(String[][] arr) {
        /* Recall: All String references in stepped are null by
            default, so the edges are correct on initialization.
         */
        String[][] stepped = new String[arr.length][arr[0].length];
        LengthComparator comparator = new LengthComparator();
        for (int i = 1; i < arr.length - 1; i += 1) {
            for (int j = 1; j < arr[0].length - 1; j += 1) {
                String[] temp = new String[9];
                for (int k = -1; k <= 1; k += 1) {
                    for (int m = -1; m <= 1; m += 1) {
                        temp[(k + 2) + 3 * (m + 1) - 1] = arr[i + k][j + m];
                    }
                }
                String largest = max(temp, comparator);
                stepped[i][j] = largest;
            }
        }
        return stepped;
    }

    public static String max(String[] a, NullSafeStringComparator sc) {
        String maxStr = a[0];
        for (int i = 1; i < a.length; i += 1) {
            if (sc.compare(a[i], maxStr) > 0) {
                maxStr = a[i];
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        String arr[][] = new String[5][6];
        arr[1] = new String[]{null, "a", "cat", "cat", "dogs", null};
        arr[2] = new String[]{null, "a", null, "cat", "a", null};
        arr[3] = new String[]{null, "a", "ca", "", "ca", null};
        System.out.println(Arrays.deepToString(arr));
        String[][] stepped = step(arr);
        System.out.println(Arrays.deepToString(stepped));

    }

    @Override
    public int compare(String s1, String s2) {
        int result;
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s2 == null) {
            return 1;
        } else if (s1 == null) {
            return -1;
        } else {
            result = s1.length() - s2.length();
        }
        return result;
    }

}
