**Routine Name:** pentadiag

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Initializes a 2D matrix for a pentadiagonal 
matrix

**Input:** The pentadiag method has two parameters

* int nx - x width of the grid including boundary conditions.
* int ny - y width of the grid including boundary conditions.

**Output:** The method returns a double[][] matrix with the initialized values.

* double[0][] = 1
* double[1][] = 1
* double[2][] = -4
* double[3][] = 1
* double[4][] = 1

**Usage/Example:**

To call this method the following call needs to be made.

    double[][] A = PentadiagMatrix.pentadiag(nx, ny);

The method returns the matrix A which can be used to solve the PDE.

**Implementation/Code:** The following is the code for pentadiag.

[pentadiag]()

    public static double[][] pentadiag(int nx, int ny){
        int width = (nx * ny) - 2;
        double[][] output = new double[5][width];

        for (int i = 0; i < width; i++) {
            output[0][i] = 1;
            output[1][i] = 1;
            output[2][i] = -4;
            output[3][i] = 1;
            output[4][i] = 1;
        }
        return output;
    }

**Last Modified:** March/2020