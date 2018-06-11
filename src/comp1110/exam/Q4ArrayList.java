package comp1110.exam;

import java.util.Arrays;
import java.util.Collections;

/**
 * COMP1110 Final Exam, Question 4
 */
public class Q4ArrayList<T> {
    private static final int INITIAL_SIZE = 2;
    private static final double GROWTH_FACTOR = 1.5;

    T[] values = (T[]) new Object[INITIAL_SIZE];
    int elements = 0;

    /**
     * Add a value to the tail of the list.
     *
     * @param value The value to be added.
     */
    public void add(T value) {
        /* Unimplemented.  Q4 i) [7 Marks] */
        if (elements+1 > INITIAL_SIZE) {
            values = Arrays.copyOf(values,elements+1);
            values[elements++] = value;
        } else {
            values[elements++] = value;
        }
    }

    /**
     * Remove the value at the specified index from the list.
     *
     * @param index
     */
    public void remove(int index) {
        /* Unimplemented. Q4 ii) [7 Marks] */
        T value = get(index);
        int moveSize = elements - index - 1;
        if (moveSize > 0){
            System.arraycopy(values,index + 1, values,index,elements - index - 1);
        }
        values[--elements] = null;
    }

    /**
     * @param index
     * @return The value at the specified index.
     */
    public T get(int index) {
        if (index >= elements || index < 0)
            throw new IndexOutOfBoundsException();
        return values[index];
    }

    /**
     * @return the current size of the list.
     */
    public int size() {
        return elements;
    }

    /**
     * Reverse the order of the elements of the list.
     */
    public void reverse() {
	    /* Unimplemented. Q4 iii) [6 Marks] */
        Collections.reverse(values);
    }

    /**
     * @return A string representation of the list.
     */
    public String toString() {
        String rtn = "";
        for (int i = 0; i < elements; i++) {
            rtn += ((i != 0) ? " " : "") + values[i];
        }
        return rtn;
    }
}
