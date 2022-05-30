public class QuikMaths {

    public static void multiplyBy3(int[] A) {
        for (int x : A) {
            x = x * 3;
        }
    }

    public static void multiplyBy2(int[] A) {
        int[] B = A;
        for (int i = 0; i < B.length; i += 1) {
            B[i] *= 2;
        }
    }

    public static void swap(int A, int B) {
        int temp = B;
        B = A;
        A = temp;
    }


    public static void main(String[] args) {
        System.out.printf("test");
        int[] arr;
        arr = new int[]{2, 3, 3, 4};

//        QuikMaths q;
        multiplyBy3(arr);

        /* Value of arr: {________________________} */

        arr = new int[]{2, 3, 3, 4};
        multiplyBy2(arr);

        /* Value of arr: {________________________} */

        int a = 6;
        int b = 7;
        swap(a, b);

        /* Value of a: _______ Value of b: _______ */
    }
}
