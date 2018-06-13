package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 5ii
 */
public class Q5Hash {
    /**
     * Return a hash of the given value as an integer in the range 0 ... buckets - 1.
     *
     * @param value  The value to be hashed
     * @param buckets The number of buckets into which the hash should be made (defining its range)
     * @return An integer hash of value in the range 0 ... buckets - 1.
     */
    public static int hash(int value, int buckets) {
//        String s = Integer.toString(Math.abs(value));
//        int result = 0;
//        for (int i = s.length() - 1; i >= 0; i--){
//            result = result + (Character.compare(s.charAt(i),'0'));
//        }
        return value % buckets;
         // FIXME Question 5iv: complete this function
    }
}
