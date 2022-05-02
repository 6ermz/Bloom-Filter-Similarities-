package com.github.lovasoa.bloomfilter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import com.google.common.collect.Sets;
//import static org.simmetrics.metrics.Math.intersection;


public class MatrixFilters{
	/**
	 *
	 */
	public static final int NUMBER_RANGE = 100000; // random number range
	public static int fixed_bitsize  = (int) (NUMBER_RANGE);

	static int min = 1000;
    static int max = NUMBER_RANGE;
    static Random random1 = new Random();
    
    
    //public static int[] rngelements = {rngelements1, rngelements2};
    
	public static int rngelements1 = random1.nextInt((max - min)+1) + min;
	public static int rngelements2 = random1.nextInt((max - min)+1) + min;
	public static int rngelements3 = random1.nextInt((max - min)+1) + min;
	public static int rngelements4 = random1.nextInt((max - min)+1) + min;
	public static int rngelements5 = random1.nextInt((max - min)+1) + min;
	public static int rngelements6 = random1.nextInt((max - min)+1) + min;
	public static int rngelements7 = random1.nextInt((max - min)+1) + min;
	public static int rngelements8 = random1.nextInt((max - min)+1) + min;
	public static int rngelements9 = random1.nextInt((max - min)+1) + min;
	public static int rngelements10 = random1.nextInt((max - min)+1) + min;
	public static int rngelements11 = random1.nextInt((max - min)+1) + min;
	public static int rngelements12 = random1.nextInt((max - min)+1) + min;
	public static int rngelements13= random1.nextInt((max - min)+1) + min;
	public static int rngelements14= random1.nextInt((max - min)+1) + min;
	public static int rngelements15= random1.nextInt((max - min)+1) + min;
	public static int rngelements16= random1.nextInt((max - min)+1) + min;
	public static int rngelements17= random1.nextInt((max - min)+1) + min;
	public static int rngelements18= random1.nextInt((max - min)+1) + min;
	public static int rngelements19= random1.nextInt((max - min)+1) + min;
	public static int rngelements20= random1.nextInt((max - min)+1) + min;
	public static int rngelements21 = random1.nextInt((max - min)+1) + min;

	
	
    public static BloomFilter filter1 = new BloomFilter(fixed_bitsize, rngelements1);
    public static BloomFilter filter2 = new BloomFilter(fixed_bitsize, rngelements2);
    public static BloomFilter filter3 = new BloomFilter(fixed_bitsize, rngelements3);
    public static BloomFilter filter4 = new BloomFilter(fixed_bitsize, rngelements4);
    public static BloomFilter filter5 = new BloomFilter(fixed_bitsize, rngelements5);
    public static BloomFilter filter6 = new BloomFilter(fixed_bitsize, rngelements6);
    public static BloomFilter filter7 = new BloomFilter(fixed_bitsize, rngelements7);
    public static BloomFilter filter8 = new BloomFilter(fixed_bitsize, rngelements8);
    public static BloomFilter filter9 = new BloomFilter(fixed_bitsize, rngelements9);
    public static BloomFilter filter10 = new BloomFilter(fixed_bitsize, rngelements10); 
    public static BloomFilter filter11 = new BloomFilter(fixed_bitsize, rngelements11);
    public static BloomFilter filter12 = new BloomFilter(fixed_bitsize, rngelements12);
    public static BloomFilter filter13 = new BloomFilter(fixed_bitsize, rngelements13);
    public static BloomFilter filter14 = new BloomFilter(fixed_bitsize, rngelements14);
    public static BloomFilter filter15 = new BloomFilter(fixed_bitsize, rngelements15);
    public static BloomFilter filter16 = new BloomFilter(fixed_bitsize, rngelements16);
    public static BloomFilter filter17 = new BloomFilter(fixed_bitsize, rngelements17);
    public static BloomFilter filter18 = new BloomFilter(fixed_bitsize, rngelements18);
    public static BloomFilter filter19 = new BloomFilter(fixed_bitsize, rngelements19);
    public static BloomFilter filter20 = new BloomFilter(fixed_bitsize, rngelements20);
    public static BloomFilter filter21 = new BloomFilter(fixed_bitsize, rngelements21); 

    public static void printMatrix(Object[][] matrix){
		for (Object[] row : matrix)
		{
			// traverses through number of rows
			for (Object element : row)
			{
				// 'element' has current element of row index
				System.out.print( element  + "\t");
			}
			System.out.println();
		}
	}
    
	public static void main(String[] args) {
		
		System.out.println("file 0 size: "+rngelements1);
		System.out.println("file 1 size: "+rngelements2);
		System.out.println("file 2 size: "+rngelements3);
		System.out.println("file 3 size: "+rngelements4);
		System.out.println("file 4 size: "+rngelements5);
		System.out.println("file 5 size: "+rngelements6);
		System.out.println("file 6 size: "+rngelements7);
		System.out.println("file 7 size: "+rngelements8);
		System.out.println("file 8 size: "+rngelements9);
		System.out.println("file 9 size: "+rngelements10);
		System.out.println("file 10 size: "+rngelements11);
		System.out.println("file 11 size: "+rngelements12);
		System.out.println("file 12 size: "+rngelements13);
		System.out.println("file 13 size: "+rngelements14);
		System.out.println("file 14 size: "+rngelements15);
		System.out.println("file 15 size: "+rngelements16);
		System.out.println("file 16 size: "+rngelements17);
		System.out.println("file 17 size: "+rngelements18);
		System.out.println("file 18 size: "+rngelements19);
		System.out.println("file 19 size: "+rngelements20);
		System.out.println("file 20 size: "+rngelements21);
		
		Random random = new Random();
        HashSet<Integer> set1 = new HashSet<>(rngelements1);

        while(set1.size()< rngelements1) {
            while (!set1.add(random.nextInt(max)));
        }
        assert set1.size() == rngelements1;	    
        filter1.addAll(set1);
        //System.out.println("filter "+ filter1);
        //System.out.println("Set 1 Bloom filter:" + filter1.bloom);
        //System.out.println("k hashes for set 1: " + filter1.k);
        //System.out.println("k hashes for set 2: " + filter2.k);


        //*************************SET 2*************************************************
        HashSet<Integer> set2 = new HashSet<>(rngelements2);
        while(set2.size()< rngelements2) {
            while (!set2.add(random.nextInt(max)));
        }
        assert set2.size() == rngelements2;
        filter2.addAll(set2);
        
        //System.out.println("\nSet 2 = "+ set2);

        //System.out.println("Set 2 Bloom filter:" + filter2.bloom);
        HashSet<Integer> set3 = new HashSet<>(rngelements3);
        while(set3.size()< rngelements3) {
            while (!set3.add(random.nextInt(max)));
        }
        assert set3.size() == rngelements3;
        filter3.addAll(set3);
        
        HashSet<Integer> set4 = new HashSet<>(rngelements4);
        while(set4.size()< rngelements4) {
            while (!set4.add(random.nextInt(max)));
        }
        assert set4.size() == rngelements4;
        filter4.addAll(set4);
        
        HashSet<Integer> set5 = new HashSet<>(rngelements5);
        while(set5.size()< rngelements5) {
            while (!set5.add(random.nextInt(max)));
        }
        assert set5.size() == rngelements5;
        filter5.addAll(set5);
        
        HashSet<Integer> set6 = new HashSet<>(rngelements6);
        while(set6.size()< rngelements6) {
            while (!set6.add(random.nextInt(max)));
        }
        assert set6.size() == rngelements6;
        filter6.addAll(set6);
        
        HashSet<Integer> set7 = new HashSet<>(rngelements7);
        while(set7.size()< rngelements7) {
            while (!set7.add(random.nextInt(max)));
        }
        assert set7.size() == rngelements7;
        filter7.addAll(set7);
        
        HashSet<Integer> set8 = new HashSet<>(rngelements8);
        while(set8.size()< rngelements8) {
            while (!set8.add(random.nextInt(max)));
        }
        assert set8.size() == rngelements8;
        filter8.addAll(set8);
        
        HashSet<Integer> set9 = new HashSet<>(rngelements9);
        while(set9.size()< rngelements9) {
            while (!set9.add(random.nextInt(max)));
        }
        assert set9.size() == rngelements9;
        filter9.addAll(set9);
        
        HashSet<Integer> set10 = new HashSet<>(rngelements10);
        while(set10.size()< rngelements10) {
            while (!set10.add(random.nextInt(max)));
        }
        assert set10.size() == rngelements10;
        filter10.addAll(set10);
        
        HashSet<Integer> set11 = new HashSet<>(rngelements11);
        while(set11.size()< rngelements11) {
            while (!set11.add(random.nextInt(max)));
        }
        assert set11.size() == rngelements11;
        filter11.addAll(set11);
        
        HashSet<Integer> set12 = new HashSet<>(rngelements12);
        while(set12.size()< rngelements12) {
            while (!set12.add(random.nextInt(max)));
        }
        assert set12.size() == rngelements12;
        filter12.addAll(set12);
        
        HashSet<Integer> set13 = new HashSet<>(rngelements13);
        while(set13.size()< rngelements13) {
            while (!set13.add(random.nextInt(max)));
        }
        assert set13.size() == rngelements13;
        filter13.addAll(set13);
        
        HashSet<Integer> set14 = new HashSet<>(rngelements14);
        while(set14.size()< rngelements14) {
            while (!set14.add(random.nextInt(max)));
        }
        assert set14.size() == rngelements14;
        filter14.addAll(set14);
        
        HashSet<Integer> set15 = new HashSet<>(rngelements15);
        while(set15.size()< rngelements15) {
            while (!set15.add(random.nextInt(max)));
        }
        assert set15.size() == rngelements15;
        filter15.addAll(set15);
        
        HashSet<Integer> set16 = new HashSet<>(rngelements16);
        while(set16.size()< rngelements16) {
            while (!set16.add(random.nextInt(max)));
        }
        assert set16.size() == rngelements16;
        filter16.addAll(set16);
        
        HashSet<Integer> set17 = new HashSet<>(rngelements17);
        while(set17.size()< rngelements17) {
            while (!set17.add(random.nextInt(max)));
        }
        assert set17.size() == rngelements17;
        filter17.addAll(set17);
        
        HashSet<Integer> set18 = new HashSet<>(rngelements18);
        while(set18.size()< rngelements18) {
            while (!set18.add(random.nextInt(max)));
        }
        assert set18.size() == rngelements18;
        filter18.addAll(set18);
        
        HashSet<Integer> set19 = new HashSet<>(rngelements19);
        while(set19.size()< rngelements19) {
            while (!set19.add(random.nextInt(max)));
        }
        assert set19.size() == rngelements19;
        filter19.addAll(set19);
        
        HashSet<Integer> set20 = new HashSet<>(rngelements20);
        while(set20.size()< rngelements20) {
            while (!set20.add(random.nextInt(max)));
        }
        assert set20.size() == rngelements20;
        filter20.addAll(set20);
        
        HashSet<Integer> set21 = new HashSet<>(rngelements21);
        while(set21.size()< rngelements21) {
            while (!set21.add(random.nextInt(max)));
        }
        assert set21.size() == rngelements21;
        filter21.addAll(set21);
        
        
        
        
        
        //System.out.println("Set 1 = "+ set1);
	    //System.out.println("Set 2 = "+ set2);
	    //System.out.println("Set 3 = "+ set3);
	    //System.out.println("Set 4 = "+ set4);
	    //System.out.println("Set 5 = "+ set5);
	    
        //*****************************intersection and union**************************************************
        Set<Integer> intersection = Sets.intersection(set1, set2);
        //Set<Integer> intersection1 = Sets.intersection(set1, set3);

        //System.out.printf("\nIntersection of two Sets %s and %s in Java is %s %n", //PRINTS OUT THE INTERSECTION SET
          //      set1.toString(), set2.toString(), intersection.toString());

        Set<Integer> union = Sets.union(set1, set2);
        //Set<Integer> union1 = Sets.union(set1, set3);

        
        //System.out.printf("Union of two Sets        %s and %s in Java is %s %n", // PRINTS OUT THE UNION SET
          //              set1.toString(), set2.toString(), union.toString());
        
        //System.out.println("intsize- "+ intersection.size());
        //System.out.println("unionsize- "+ union.size());

        double ActualJac= Double.valueOf(intersection.size()) / Double.valueOf(union.size());
        //double ActualJac1= Double.valueOf(intersection1.size()) / Double.valueOf(union1.size());
        //System.out.println("Jaccard Coefficient:     " + Double.valueOf(intersection.size()) / Double.valueOf(union.size()));
        //System.out.println("Jaccard Coefficient of Plaintext:     " + ActualJac);

        filter1.bloom.trimToSize();
        //System.out.println("\n bit1 size :                 " + filter1.bloom.size());
        //System.out.println(" bit2 size :                 " + filter2.bloom.size() +"\n");


        
        //Object[] array1= filter1.bloom.toArray();
        //Object[] array2 = filter2.bloom.toArray();
        
        
        Object [][] matrix = new Object[2][NUMBER_RANGE];
        matrix[0]= filter1.bloom.toArray();
        matrix[1]= filter2.bloom.toArray();
        //matrix[2]= filter3.bloom.toArray();
        //matrix[3]= filter4.bloom.toArray();
        //matrix[4]= filter5.bloom.toArray();
        //matrix[5]= filter6.bloom.toArray();
        //matrix[6]= filter7.bloom.toArray();
        //matrix[7]= filter8.bloom.toArray();
        //matrix[8]= filter9.bloom.toArray();
        //matrix[9]= filter10.bloom.toArray();
        //matrix[10]= filter11.bloom.toArray();
        //matrix[11]= filter12.bloom.toArray();
        //matrix[12]= filter13.bloom.toArray();
        //matrix[13]= filter14.bloom.toArray();
        //matrix[14]= filter15.bloom.toArray();
        //matrix[15]= filter16.bloom.toArray();
        //matrix[16]= filter17.bloom.toArray();
        //matrix[17]= filter18.bloom.toArray();
        //matrix[18]= filter19.bloom.toArray();
        //matrix[19]= filter20.bloom.toArray();
        //matrix[20]= filter21.bloom.toArray();

        
        int j = 0;
		System.out.println("\nnumber of cols: " + matrix[j].length);
		System.out.println("number of rows: " + matrix.length);

        //printMatrix(matrix);

        //Object[][] array3 = (Object[][]) filter2.bloom.toArray();

        //*************************************************************************************************************************
        double ClosestJac = 0;
        
        for (int m= 1; m < matrix.length; m++) { //iterate and compare from the 1st row to the row. not including 1st vs 1st
		System.out.println("COMPARING FILE 0 TO FILE "+ m);
		//double ClosestJac = 10;
        	
        int numzeros = 0;
        for(int p = 0; p < matrix[j].length; p++ ) { //iterate through the columns to find where both are zero 
        	if (matrix[0][p].equals(matrix[m][p]) && matrix[0][p].equals(0)) {
       			numzeros++;
       		}
       	}
        float intervalue = 0;
        for(int q = 0; q < matrix[j].length; q++ ) { //iterate through the columns to find where both are equal to 1
        		if (matrix[0][q].equals(1) && matrix[m][q].equals(1)) {
        			intervalue++;
        		}
        }
		float unionvalue = 0;
		for(int u = 0; u < matrix[j].length; u++ ) { // iterate through the j columns to find where either are equal to 1 and count++
			if (matrix[0][u].equals(1) || matrix[m][u].equals(1)) {
				unionvalue++;
			}
		}
		
		float filter1size = 0;
		for(int x = 0; x < matrix[0].length; x++ ) { //iterate through matrix [0] or only the first row and count the number of 1's
				if (matrix[0][x].equals(1)) {
		        	filter1size++;
				}
		}
		float filter2size = 0;
		for(int y = 0; y < matrix[m].length; y++ ) { //iterate through the matrix[m] or the rows after the 1st and count the number of 1's
				if (matrix[m][y].equals(1)) {
					filter2size++;
				}
		}
        
        
		//System.out.println("bloomfilter1 size:      "+ filter1size);
		//System.out.println("bloomfilter2 size:      "+ filter2size);
		//System.out.println("\nUnionvalue:      "+ unionvalue);
		//System.out.println("Intervalue:      "+ intervalue);
		float Jac= (intervalue/unionvalue);
		//System.out.println("Jaccard test using loop:      "+ Jac);
        System.out.println("\nNumber of zero pairs: "+ numzeros);

        final float ApproxUnion= filter1.bloom.size() - (numzeros); // |Bx U By| = Length - (# of zero pairs)
        final float ApproxInter= (filter1size + filter2size) - ApproxUnion; // |Bx|+|By|-|Bx U By|

        // also |A U B| = |A| + |B| - |A n B|

        System.out.println("\nApproximate Union:        "+ ApproxUnion);
        System.out.println("Approximate Intersection: "+ ApproxInter);

        float ApproxJac= (ApproxInter/ApproxUnion);
        //System.out.println("Jaccard Coefficient of Plaintext:                  " + ActualJac);

        System.out.println("Jaccard Coefficient of BF using Algorithm          " + ApproxJac);

        //double PE= (Math.abs(Jac - ActualJac)/ ActualJac)*100;
        //double Accuracynew = Jac/ActualJac;
        //double accuracy= 100.0 - PE;
        //double Percentdif = ((Math.abs(Jac-ActualJac) / ((Jac+ActualJac)/2)) *100);
        //System.out.println("\nPercent Difference: " + Percentdif);
        //System.out.println("PE:      "+ PE);
        //System.out.println("Accuracy:"+accuracy);
        //System.out.println("New Accuracy:"+Accuracynew);
        if(ClosestJac<ApproxJac) {
        	ClosestJac = ApproxJac;
        }
        System.out.println("\nFile that is most similar to file 0 has a JAC of "+ ClosestJac);
        //printMatrix(matrix);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

}
} 
