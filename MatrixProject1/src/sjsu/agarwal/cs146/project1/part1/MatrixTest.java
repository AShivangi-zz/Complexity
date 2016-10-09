package sjsu.agarwal.cs146.project1.part1;
import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


/**
* The main JUnit Test class to test regular multiplication 
* and Strassen multiplication method.
* 
*
*/
public class MatrixTest extends TestCase {

	private Matrix productRegularResult, productStrassenResult; // Matrices for storing the results
	private int N; // size of the NXN matrix
	@Before
	public void setUp() throws Exception
	{
	   N = 4; // size of the matrix
	   productRegularResult = new Matrix(N);
	   productStrassenResult = new Matrix(N);
	   
	} // setUp()

	
	/* compare result matrices of regular multiplication method and Strassen multiplication method:
	 */
	@Test
	public void testProductCompare() {
	    
	     
	     //run user defined random() method to generate the matrices
		 double[][] A = Matrix.makeMatrix(N);
		 double[][] B = Matrix.makeMatrix(N);
	     // run productRegular()
		 long start1 = System.nanoTime();
	     productRegularResult = new Matrix(Matrix.productRegular(A, B));
	     //Matrix.printMatrix(productRegularResult);
	     long end1 = System.nanoTime();
	     long time1 = end1-start1;
	     System.out.println("Time taken by regular product ="+time1);
	     
	     // run productStrassen()
	     long start2 = System.nanoTime();
	     Matrix m = new Matrix(N);
		 productStrassenResult = new Matrix(m.productStrassen(A, B));
		 //Matrix.printMatrix(productStrassenResult);
		 long end2 = System.nanoTime();
	     long time2 = end2-start2;
	     System.out.println("Time taken by strassen product ="+time2);
		 
	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data(i), productStrassenResult.data(i), 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	    
	}
	
	
	/* multiplying a 2D array using the regular method:
	 */
	@Test
	public void testProductRegular() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D array in
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	      
	    // run productRegular()
	    long start1 = System.nanoTime();
		productRegularResult = new Matrix(Matrix.productRegular(array1,array2));
		//Matrix.printMatrix(productRegularResult);
	    long end1 = System.nanoTime();
	    long time1 = end1-start1;
	    System.out.println("Time taken by regular product ="+time1);
	     
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productRegularResult.data(i), 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
	
	/* multiplying a 2D array using the Strassen method:
	 */
	@Test
	public void testProductStrassen() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D array
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	      
	    // run productRegular()
		 long start1 = System.nanoTime();
	     Matrix m = new Matrix(N);
		 productStrassenResult = new Matrix(m.productStrassen(array1, array2));
		 //Matrix.printMatrix(productStrassenResult);
		 long end1 = System.nanoTime();
		 long time1 = end1-start1;
		 System.out.println("Time taken by strassen product ="+time1);
	     
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productStrassenResult.data(i), 0.0); // data[][] is a data member for storing matrix values in class Matrix.
	    }
	    
	}
	
	
	
} // class MatrixTest
