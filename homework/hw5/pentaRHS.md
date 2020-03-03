**Routine Name:** pentaRHS

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Initializes the right hand side for a PDE 
numerical solution

**Input:** The pentaRHS method has a few parameters in order for it to run.

* int nx - width of the grid including the boundaries
* double[] bottom - boundary conditions
* double[] left - boundary conditions
* double[] right - boundary conditions
* double[] top - boundary conditions
* double[] f - functional values of the BVP problem
* double h -size between points

**Output:** The method will return an array with the right hand side matrix.

**Usage/Example:**

To initialize the right hand side matrix a call to the pentaRHS method needs
to be made. The call looks like the following:

    double[] F = PentadiagMatrix.pentaRHS(nx, bottom, left, right, top, f, h);

This call returns the matrix that represents the right hand side which can be
used to further solve the PDE.

**Implementation/Code:** The following is the code for pentaRHS.

[pentaRHS]()

    public static double[] pentaRHS(int nx, double[] bottom, double[] left, double[] right,
                               double[] top, double[] f, double h){
        int width = (nx * nx) - 2;

        for (int k = 0; k < width; k++) {
            int row = k / (nx - 2);
            int col = k % (nx - 2);

            f[k] = f[k] * h * h;
            if (row - 1 == -1) {f[k] = f[k] - bottom[k];}
            if (row + 1 == nx - 1) {f[k] = f[k] - top[k];}
            if (col - 1 == -1) {f[k] = f[k] - left[k];}
            if (col + 1 == nx -1) {f[k] = f[k] - right[k];}
        }
        return f;
    }

**Last Modified:** March/2020