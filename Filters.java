package com.github.lovasoa.bloomfilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;    
import java.lang.management.ThreadMXBean;
import com.google.common.collect.Sets; 
//import static org.simmetrics.metrics.Math.intersection;


public class Filters {
	/**
	 * 
	 */
	public static int elements = 4; // m
	public static double p = 0.001;
	//public static int bitsize  = (int) Math.ceil((elements * Math.log(1/p)) / Math.pow(Math.log(2), 2)); // n
	public static int bitsize  = (int) Math.ceil(-1 * (elements * Math.log(p)) / Math.pow(Math.log(2), 2)); // n
    //public static int bitsize = 100000000;
	public static final int NUMBER_RANGE = 10; // random number range
    static BloomFilter filter1 = new BloomFilter(bitsize, elements); 
    static BloomFilter filter2 = new BloomFilter(bitsize, elements);
    
	public static void main(String[] args) {
		Random random = new Random();
        HashSet<Integer> set1 = new HashSet<Integer>(elements);
        
        while(set1.size()< elements) {
            while (set1.add(random.nextInt(NUMBER_RANGE)) != true);
        }
        assert set1.size() == elements;
        
	    System.out.println("Set 1 = "+ set1);
        filter1.addAll(set1);
        //System.out.println("filter "+ filter1);
        System.out.println("Set 1 Bloom filter:" + filter1.bloom);
        System.out.println("k:" + filter1.k);
        
        
        
        //*************************SET 2*************************************************
        HashSet<Integer> set2 = new HashSet<Integer>(elements);
        while(set2.size()< elements) {
            while (set2.add(random.nextInt(NUMBER_RANGE)) != true);
        }
        assert set2.size() == elements;
        System.out.println("\nSet 2 = "+ set2);
        
        filter2.addAll(set2);
        System.out.println("Set 2 Bloom filter:" + filter2.bloom);
         
        //*****************************intersection and union**************************************************
        Set<Integer> intersection = Sets.intersection(set1, set2);
        
        //System.out.printf("\nIntersection of two Sets %s and %s in Java is %s %n",
          //      set1.toString(), set2.toString(), intersection.toString());
        
        Set<Integer> union = Sets.union(set1, set2);
        //System.out.printf("Union of two Sets        %s and %s in Java is %s %n",
          //              set1.toString(), set2.toString(), union.toString());
        System.out.println("  ");
        Double ActualJac= Double.valueOf(intersection.size()) / Double.valueOf(union.size());
        System.out.println("Jaccard Coefficient:     " + Double.valueOf(intersection.size()) / Double.valueOf(union.size()));
        filter1.bloom.trimToSize();
        System.out.println("\n filter 1 size :                 " + filter1.bloom.size());
        
        
        int numzeros = 0;
        Object[] array1 = filter1.bloom.toArray();
        Object[] array2 = filter2.bloom.toArray();
        //*************************************************************************************************************************
        
        for(int i = 0; i < filter1.bloom.size(); i++ ) {
			if (array1[i].equals(array2[i]) && array1[i].equals(0)) {
        		numzeros++;
        	}
        }
			
		float intervalue = 0;
		for(int j = 0; j < filter1.bloom.size(); j++ ) {
			if (array2[j].equals(1) && array1[j].equals(1)) {
	        	intervalue++;
			}
		}
		float unionvalue = 0;
		for(int u = 0; u < filter1.bloom.size(); u++ ) {
				if (array2[u].equals(1) || array1[u].equals(1)) {
		        	unionvalue++;
				}
		}
		
		System.out.println("Unionvalue:      "+ unionvalue);
		System.out.println("INtervalue:      "+ intervalue);
        System.out.println("number of zeros: "+ numzeros);
        
        final float ApproxUnion= filter1.bloom.size() - (numzeros); // |Bx U By| = Length - (# of zero pairs)
        final float ApproxInter= (filter1.bloom.size() + filter2.bloom.size()) - ApproxUnion; // |Set1|+|Set2|-|Bx U By|
        
        
        System.out.println("Approximate Union:        "+ ApproxUnion);
        System.out.println("Approximate Intersection: "+ ApproxInter);
        
        System.out.println("JAC:                      "+ (ApproxInter/ApproxUnion));
        float ApproxJac= (intervalue/ApproxUnion);
        System.out.println("Better JAC:               "+ (intervalue/ApproxUnion));
        
        System.out.println("Accuracy: "+ ActualJac/ApproxJac);
	}
	

	//        FASTER INTERSECTION ALGORITHM
	
	/*public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        // unnecessary; just an optimization to iterate over the smaller set
        if (set1.size() > set2.size()) {
            return intersection(set2, set1);
        }

        Set<Integer> results = new HashSet<>();
 
        for (Integer element : set1) {
            if (set2.contains(element)) {
                results.add(element);
            }
        }

        return results;
    }*/
        
}
