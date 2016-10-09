package sjsu.agarwal.cs146.project1.part1;
import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


/**
* The main JUnit Test class to test regular multiplication 
* and Strassen multiplication method for N = 16 and N = 256
* 
*
*/
public class MatrixTest2 extends TestCase {

	private Matrix productRegularResult, productStrassenResult; // Matrices for storing the results
	private Matrix productRegularResult2, productStrassenResult2;
	private Matrix productRegularResult3, productStrassenResult3;
	private int N; // size of the NXN matrix
	private int N2;
	private int N3;
	@Before
	public void setUp() throws Exception
	{
	   N = 16; // size of the matrix
	   N2 = 256;
	   N3 = 1024;
	   productRegularResult = new Matrix(N);
	   productStrassenResult = new Matrix(N);
	   productRegularResult2 = new Matrix(N2);
	   productStrassenResult2 = new Matrix(N2);
	   productRegularResult3 = new Matrix(N3);
	   productStrassenResult3 = new Matrix(N3);
	} // setUp()

	
	/* compare result matrices of regular multiplication method and Strassen multiplication method:
	 */
	@Test
	public void testProductCompare16() { //test for N= 16
	    
	     //run user defined random() method to generate the matrices
		 double[][] A = Matrix.makeMatrix(N);
		 double[][] B = Matrix.makeMatrix(N);
	     // run productRegular()
		 long start1 = System.currentTimeMillis();
	     productRegularResult = new Matrix(Matrix.productRegular(A, B));
	     // Matrix.printMatrix(productRegularResult);
	     long end1 = System.currentTimeMillis();
	     long time1 = end1-start1;
	     System.out.println("Time taken by regular product ="+time1);
	     
	     // run productStrassen()
	     long start2 = System.currentTimeMillis();
	     Matrix m = new Matrix(N);
		 productStrassenResult = new Matrix(m.productStrassen(A, B));
		 // Matrix.printMatrix(productStrassenResult);
		 long end2 = System.currentTimeMillis();
	     long time2 = end2-start2;
	     System.out.println("Time taken by strassen product ="+time2);
		 
	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data(i), productStrassenResult.data(i), 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
	}
	@Test
	public void testProductCompare512() { //test for N= 512
	    
	     //run user defined random() method to generate the matrices
		 double[][] A = Matrix.makeMatrix(N2);
		 double[][] B = Matrix.makeMatrix(N2);
	     // run productRegular()
		 long start1 = System.currentTimeMillis();
	     productRegularResult2 = new Matrix(Matrix.productRegular(A, B));
//	     Matrix.printMatrix(productRegularResult2);
	     long end1 = System.currentTimeMillis();
	     long time1 = end1-start1;
	     System.out.println("Time taken by regular product ="+time1);
	     
	     // run productStrassen()
	     long start2 = System.currentTimeMillis();
	     Matrix m = new Matrix(N);
		 productStrassenResult2 = new Matrix(m.productStrassen(A, B));
//		 Matrix.printMatrix(productStrassenResult2);
		 long end2 = System.currentTimeMillis();
	     long time2 = end2-start2;
	     System.out.println("Time taken by strassen product ="+time2);
		 
	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult2.data(i), productStrassenResult2.data(i), 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
	}
	     
	 	@Test
		public void testProductCompare1024() { //test for N= 1024
		    
		     
		     //run user defined random() method to generate the matrices
			 double[][] A = Matrix.makeMatrix(N3);
			 double[][] B = Matrix.makeMatrix(N3);
		     // run productRegular()
			 long start1 = System.currentTimeMillis();
		     productRegularResult3 = new Matrix(Matrix.productRegular(A, B));
//		     Matrix.printMatrix(productRegularResult2);
		     long end1 = System.currentTimeMillis();
		     long time1 = end1-start1;
		     System.out.println("Time taken by regular product ="+time1);
		     
		     // run productStrassen()
		     long start2 = System.currentTimeMillis();
		     Matrix m = new Matrix(N3);
			 productStrassenResult3 = new Matrix(m.productStrassen(A, B));
//			 Matrix.printMatrix(productStrassenResult2);
			 long end2 = System.currentTimeMillis();
		     long time2 = end2-start2;
		     System.out.println("Time taken by strassen product ="+time2);
			 
		     for (int i = 0; i < N; i++) {
		    	assertArrayEquals(productRegularResult3.data(i), productStrassenResult3.data(i), 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
			}
	}
} // class MatrixTest
