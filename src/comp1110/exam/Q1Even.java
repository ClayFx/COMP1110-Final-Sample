package comp1110.exam;


/**
 * COMP1110 Final Exam, Question 1i
 */
public class Q1Even {
    /**
     * This function takes a positive integer, n,  and returns an array
     * of ints containing all even integers between 1 and n, inclusive of n.
     *
     * for example:
     *    n = 5
     * the result will be
     *        {2, 4}
     */
    public static int[] even(int n) {
        int[] result = new int[n/2];
        if (n==1) {
            return new int[]{};
        } else {
            for (int i = 0; 2*(i+1) <= n; i++){
                result[i] = 2*(i+1);
            }
            return result;
        }
    }
}
