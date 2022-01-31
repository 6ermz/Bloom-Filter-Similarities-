package com.github.lovasoa.bloomfilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;    
//import java.lang.management.ThreadMXBean;
import com.google.common.collect.Sets; 
//import static org.simmetrics.metrics.Math.intersection;


public class Filters {
	/**
	 * 
	 */
	public static int elements = 900000; // m
	public static int elements2= 600000;
	public static double p = 0.001;
	public static int bitsize  = (int) Math.ceil((elements * Math.log(1/p)) / Math.pow(Math.log(2), 2));// n
	//public static int bitsize2  = (int) Math.ceil((elements2 * Math.log(1/p)) / Math.pow(Math.log(2), 2)); // n

	//public static int bitsize  = (int) Math.ceil(-1 * (elements * Math.log(p)) / Math.pow(Math.log(2), 2)); // n
	public static final int NUMBER_RANGE = 1000000; // random number range
    static BloomFilter filter1 = new BloomFilter(bitsize, elements); 
    static BloomFilter filter2 = new BloomFilter(bitsize, elements2);
    
	public static void main(String[] args) {
		Random random = new Random();
        HashSet<Integer> set1 = new HashSet<Integer>(elements);
        
        while(set1.size()< elements) {
            while (set1.add(random.nextInt(NUMBER_RANGE)) != true);
        }
        assert set1.size() == elements;
        
	    //System.out.println("Set 1 = "+ set1);
        filter1.addAll(set1);
        //System.out.println("filter "+ filter1);
        //System.out.println("Set 1 Bloom filter:" + filter1.bloom);
        System.out.println("k:" + filter1.k);
        System.out.println("k:" + filter2.k);  
        
        
        //*************************SET 2*************************************************
        HashSet<Integer> set2 = new HashSet<Integer>(elements2);
        while(set2.size()< elements2) {
            while (set2.add(random.nextInt(NUMBER_RANGE)) != true);
        }
        assert set2.size() == elements2;
        //System.out.println("\nSet 2 = "+ set2);
        
        filter2.addAll(set2);
        //System.out.println("Set 2 Bloom filter:" + filter2.bloom);
         
        //*****************************intersection and union**************************************************
        Set<Integer> intersection = Sets.intersection(set1, set2);
        
        //System.out.printf("\nIntersection of two Sets %s and %s in Java is %s %n", //PRINTS OUT THE INTERSECTION SET
          //      set1.toString(), set2.toString(), intersection.toString());
        
        Set<Integer> union = Sets.union(set1, set2);
        //System.out.printf("Union of two Sets        %s and %s in Java is %s %n", // PRINTS OUT THE UNION SET
          //              set1.toString(), set2.toString(), union.toString());
        System.out.println("intsize- "+ intersection.size());
        System.out.println("unionsize- "+ union.size());

        Double ActualJac= Double.valueOf(intersection.size()) / Double.valueOf(union.size());
        //System.out.println("Jaccard Coefficient:     " + Double.valueOf(intersection.size()) / Double.valueOf(union.size()));
        //System.out.println("Jaccard Coefficient of Plaintext:     " + ActualJac);

        filter1.bloom.trimToSize();
        System.out.println("\n bit1 size :                 " + filter1.bloom.size());
        System.out.println(" bit2 size :                 " + filter2.bloom.size() +"\n");
        
        
        int numzeros = 0;
        Object[] array1 = filter1.bloom.toArray();
        Object[] array2 = filter2.bloom.toArray();
        //*************************************************************************************************************************
        
        if (filter1.bloom.size() < filter2.bloom.size()) {
        	for(int i = 0; i < filter1.bloom.size(); i++ ) {
        		if (array1[i].equals(array2[i]) && array1[i].equals(0)) {
        			numzeros++;
        		}
        	}
        }
        else {
        	 for(int i = 0; i < filter2.bloom.size(); i++ ) {
     			if (array1[i].equals(array2[i]) && array1[i].equals(0)) {
             		numzeros++;
             	}
        	 }
        }
        float intervalue = 0;
        if (filter1.bloom.size() < filter2.bloom.size()) {
        	for(int j = 0; j < filter1.bloom.size(); j++ ) {
        		if (array2[j].equals(1) && array1[j].equals(1)) {
        			intervalue++;
        		}
        	}
        }
        else {
        	for(int j = 0; j < filter2.bloom.size(); j++ ) {
        		if (array2[j].equals(1) && array1[j].equals(1)) {
        			intervalue++;
        		}
        	}
        }
		float unionvalue = 0;
		if (filter1.bloom.size() < filter2.bloom.size()) {
			for(int u = 0; u < filter1.bloom.size(); u++ ) {
				if (array2[u].equals(1) || array1[u].equals(1)) {
					unionvalue++;
				}
			}
			for(int u = filter1.bloom.size(); u < filter2.bloom.size(); u++ ) {
				if(array2[u].equals(1)) {
					unionvalue++;
				}
			}
		}	
		else {
			for(int t = 0; t < filter2.bloom.size(); t++ ) {
				if (array2[t].equals(1) || array1[t].equals(1)) {
					unionvalue++;
			}
		}
			for(int t = filter2.bloom.size(); t < filter1.bloom.size(); t++ ) {
				if(array1[t].equals(1)) {
					unionvalue++;
				}
			}
		}
			
		float filter1size = 0;
		for(int x = 0; x < filter1.bloom.size(); x++ ) {
				if (array1[x].equals(1)) {
		        	filter1size++;
				}
		}
		float filter2size = 0;
		for(int y = 0; y < filter2.bloom.size(); y++ ) {
				if (array2[y].equals(1)) {
					filter2size++;
				}		
		}
		System.out.println("bloomfilter1 size:      "+ filter1size);
		System.out.println("bloomfilter2 size:      "+ filter2size);
		System.out.println("\nUnionvalue:      "+ unionvalue);
		System.out.println("Intervalue:      "+ intervalue);
		float Jac= (intervalue/unionvalue);
		System.out.println("Jaccard test using loop:      "+ Jac);
        System.out.println("number of zero pairs: "+ numzeros);
        
        final float ApproxUnion= filter2.bloom.size() - (numzeros); // |Bx U By| = Length - (# of zero pairs)
        final float ApproxInter= (filter1size + filter2size) - ApproxUnion; // |Bx|+|By|-|Bx U By| //NOT WORKING 
        
        // also |A U B| = |A| + |B| - |A n B|
        
        System.out.println("Approximate Union:        "+ ApproxUnion);
        System.out.println("Approximate Intersection: "+ ApproxInter);
        
        float ApproxJac= (ApproxInter/ApproxUnion);
        System.out.println("JAC test:                      "+ ApproxJac);
        System.out.println("Jaccard Coefficient of Plaintext:                  " + ActualJac);

        System.out.println("Jaccard Coefficient of BF using Algorithm          " + ApproxJac);
        
        /*if(ActualJac > Jac) {
        	double PE = ((ActualJac-Jac)/ActualJac) *100;
    		System.out.println("Percent Error:    "+ PE);

        	}
        else {
        	double PE = ((Jac-ActualJac)/ActualJac) *100;
    		System.out.println("Percent Error:    "+ PE);
        }*/
        double Percentdif = ((Math.abs(Jac-ActualJac) / ((Jac+ActualJac)/2)) *100);	
        System.out.println("\nPercent Difference: " + Percentdif);
        //System.out.println("Accuracy:  "+ (ActualJac/ApproxJac)*100);        
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
