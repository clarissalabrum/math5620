**Routine Name:** tridiag

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** This method take the tridiagional 
initial values and creates a two dimensional array of those values.

**Input:** The method needs:

* n - size of the linear system
* asval, adval, and alval - these are the initial values that the 
tridiagional matrix should be initialized too.

**Output:** The method returns a 3xn matrix which is the initialized 
tridiagional matrix.

**Usage/Example:**

To create the initial matrix a call as the following needs to be made.

    double[][] B = TridiagMatrix.tridiag(size, 1, -2, 1);
    
B will be set the to matrix where the first column is set to 1, the second
column is -2 and the third is 1. This takes the place of the tridiagonal 
matrix with the diagonal of 1, -2, and 1

**Implementation/Code:** The following is the code for tridiag

    public static double[][] tridiag(int n, double asval, double adval, double alval){

       double[][] output = new double[3][n];

       for (int i = 0; i < n - 1; i++) {
           output[1][i] = adval;
       }
       for (int i = 0; i < n - 2; i++) {
           output[0][i] = alval;
           output[2][i] = asval;
       }
       return output;
    }

**Last Modified:** February/2020
