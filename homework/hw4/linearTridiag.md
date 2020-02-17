**Routine Name:** linearTridiag

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** This method is used with general linear elliptic equations in which it takes an array of coefficients and 
makes a tridiagional matrix.

**Input:** 
* int n - the size of mesh points used in the system of equations. (number of spaces between points)
* double[] a - array of coefficents for the general linear equation.

**Output:** a two dimensional array which is storing the tridiagional matrix

**Usage/Example:**

To use the linearTridiag method, a call as follows is nessesary. 

    double[][] A = TridiagMatrix.linearTridiag(a.length, a);
    
a in this case is the array of coefficients and the method returns a two demensional array that is saved to the array A.

**Implementation/Code:** The following is the code for linearTridiag

     public static double[][] linearTridiag(int n, double[] a){
         double[][] output = new double[3][n];

         double[] avea = new double[n+1];
         avea[0] = a[0];
         avea[avea.length-1] = a[a.length-1];
         for (int i = 0; i < a.length-1; i++) {
             avea[i+1] = .5 * (a[i] + a[i+1]);
         }

         for (int i = 0; i < n - 1; i++) {
             output[1][i] = -1 * (avea[i] + avea[i+1]);
         }
         for (int i = 0; i < n - 2; i++) {
             output[0][i] = avea[i+1];
             output[2][i] = avea[i+1];
         }
         return output;
     }

**Last Modified:** February/2020
