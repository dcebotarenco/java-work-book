package Determinant_matrix;
import java.util.*;
/**
 * 
 * @author Dan Cebotarenco
 *
 * <blockquote>I decided to implement a recursive solution for a determinant. 
 * Not quite exponentially slower, the speed of the algorithm is more of O(n!). 
 * For a size 7 matrix, you need 7! recursions, and for a size 10 matrix, you need 10! recursions. It also takes decimal values, 
 * It finds the determinant for any size matrix.</blockquote>
 */
public class matrix_determinant {		
		/**
		 * Scanning Input Stream from KeyBoard.
		 */
		public static Scanner in = new Scanner(System.in);
		/**
		 * Dimension of matrix NxN.
		 */
		public static int N = 0;
		/**
		 * Max number when user enter a number.
		 */
		public static int NMAX = 10;
		/**
		 * Matrix.
		 */
		public static double A[][];
	 
		/**
		 * Function for inputing the dimension of {@link #A} matrix nxn.
		 */
			public static void Input()
			{
				System.out.print("Enter a number:");
				N = in.nextInt();
				while(N > NMAX)
				{
					System.out.println("Number to big : ).. Re Enter:");
					N = in.nextInt();
				}		
				A = new double[N][N];		
			}

			/**
			 * Function for inputting {@link #N} in  function {@link #Input()}, and Inputing elements of {@link #A} matrix.
			 */
			public static void InputM()
			{
				Input();
				for(int i=0; i<N; i++)
				{
					for(int j=0; j<N; j++)
					{
						A[i][j] = in.nextInt();
					}
				}
			}
			/**
			 * Printing {@link #A} 
			 */
			public static void mPrint(double m[][])
			{
				for (int i=0; i < N; i++)
				{
					for (int j=0; j<N; j++)
					{
						System.out.printf("%.2f ",m[i][j]);
					}
					System.out.print("\n");
				}
			}
			
			/**
			 * Pretty self-explanatory of function, It basically finds the determinant of a 4x4 matrix by 
			 * summing and multiplying the determinants of 3x3 matrixes, and so on. Using the data structure stack in java, which allows 
			 * returns to help find the larger determinant until it is finished, returning the final answer. Note that the code becomes
			 * progressively slower as the size of the matrix increases.
			 * @param arr Array to be Inputed by User.
			 * @return
			 */
        public static double determinant(double[][] arr) 
        {
                double result = 0;
                if (arr.length == 1) 
                {
                        result = arr[0][0];
                        return result;
                }
                if (arr.length == 2)
                {
                        result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
                        return result;
                }
                for (int i = 0; i < arr[0].length; i++) 
                {
                        double temp[][] = new double[arr.length - 1][arr[0].length - 1];

                        for (int j = 1; j < arr.length; j++)
                        {
                                for (int k = 0; k < arr[0].length; k++) 
                                {

                                        if (k < i) 
                                        {
                                                temp[j - 1][k] = arr[j][k];
                                        } else if (k > i) 
                                        {
                                                temp[j - 1][k - 1] = arr[j][k];
                                        }
                                }
                        }
                        result += arr[0][i] * Math.pow(-1, (int) i) * determinant(temp);
                }
                return result;
        }
        /**
		 * In main is called Functions
		 * @param args Console
		 */
        public static void main(String[] args) 
        {
        	InputM();
		System.out.print("\nInputed Matrix:\n");
		mPrint(A);

		System.out.printf("\nDeterminant = %.2f",determinant(A));
        }
}