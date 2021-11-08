package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int START = 1000;
	private static final int STOP = 2000;
	private static final int ELEMS = 100_000;
    private static final int TO_MS = 1_000_000;
    private static final int READS = 10_000;
	

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> al = new ArrayList<>();
    	
    	for (int i = START; i < STOP; i++) {
    		al.add(i);
    	}
    	System.out.println(al);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> ll = new LinkedList<>(al);
    	System.out.println(ll);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	final Integer temp = al.get(0); 
    	al.set(0, al.get(al.size() - 1));
    	al.set(al.size() - 1, temp);
    	System.out.println(al);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (final Integer e : al) {
    		System.out.print(e +"	");
    	}
    	System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long timeAL = System.nanoTime();
    	for (int i = 1; i <= ELEMS; i++) {
            al.add(0, i);
        }
    	timeAL = System.nanoTime() - timeAL;
    	
    	long timeLL = System.nanoTime();
    	for (int i = 1; i <= ELEMS; i++) {
            ll.add(0, i);
        }
    	timeLL = System.nanoTime() - timeLL;
    	
    	System.out.println("Inserting " + ELEMS
                + " int in a Array List took " + timeAL
                + "ns (" + timeAL / TO_MS + "ms)");
    	System.out.println("Inserting " + ELEMS
                + " int in a Linked List took " + timeLL
                + "ns (" + timeLL / TO_MS + "ms)");
        /*
         * 6) Measure the performance of reading 10000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	timeAL = System.nanoTime();
    	for (int i = 1; i <= READS; i++) {
            al.get(al.size() / 2);
        }
    	timeAL = System.nanoTime() - timeAL;
    	
    	timeLL = System.nanoTime();
    	for (int i = 1; i <= READS; i++) {
            ll.add(ll.size() / 2);
        }
    	timeLL = System.nanoTime() - timeLL;
    	
    	System.out.println("Reading " + READS
                + " elements in the middle of an Array List took " + timeAL
                + "ns (" + timeAL / TO_MS + "ms)");
    	System.out.println("Reading " + READS
                + " elements in the middle of a Linked List took " + timeLL
                + "ns (" + timeLL / TO_MS + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
