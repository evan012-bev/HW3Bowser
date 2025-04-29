/*
 * *** Evan Bowser/002 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

 import java.util.*;

 public class TreeProblems {
 
   /**
    * Method different()
    *
    * Given two TreeSets of integers, return a TreeSet containing all elements 
    * that are NOT in both sets. In other words, return a TreeSet of all the
    * elements that are in one set but not the other.
    */
   
    public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
        // Create a temporary TreeSet for the result
        Set<Integer> tempSet1 = new TreeSet<Integer>(setA);
        
        // Create a temporary set containing all elements from setB
        Set<Integer> tempSet2 = new TreeSet<Integer>(setB);
        
        // Calculate symmetric difference directly using removeAll and addAll
        // Elements in setA but not in setB
        tempSet1.removeAll(setB);
        
        // Elements in setB but not in setA
        tempSet2.removeAll(setA);
        
        // Combine both differences
        tempSet1.addAll(tempSet2);
        
        return tempSet1;
    }
 
 
   /**
    * Method removeEven()
    *
    * Given a treeMap with the key as an integer, and the value as a String,
    * remove all <key, value> pairs where the key is even. 
    */
 
    public static void removeEven(Map<Integer, String> treeMap) {
        // Create an iterator for the map keys
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        
        // Iterate through keys and remove even ones
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            if (key % 2 == 0) {
                iterator.remove();
            }
        }
    }
 
 
   /**
    * Method treesEqual()
    *
    * Given two treeMaps, each with the key as an integer, and the value as a String,
    * return a boolean value indicating if the two trees are equal or not.
    */
 
    public boolean treesEqual(Map<Integer, String> tree1, Map<Integer, String> tree2) {
        // First check if sizes are different
        if (tree1.size() != tree2.size()) {
            return false;
        }
        
        // Compare each key-value pair
        for (Integer key : tree1.keySet()) {
            // Check if key exists in tree2
            if (!tree2.containsKey(key)) {
                return false;
            }
            
            // Check if values match for the same key
            String value1 = tree1.get(key);
            String value2 = tree2.get(key);
            if (!value1.equals(value2)) {
                return false;
            }
        }
        
        // If we reach here, maps are equal
        return true;
    }
 } // end treeProblems class
