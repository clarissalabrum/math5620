**Routine Name:** enneadiag

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Initializes a 9-point matrix into a 9 x width array

**Input:** The routine requires the stencils size (nx and ny)

**Output:** The routine returns the initialized array. Values specified in the code.

**Usage/Example:**

In order to create an initalized enneadiagional matrix the following line needs to be used in the code.

    double[][] A = EnneadiagMatrix.enneadiag(nx.ny);

**Implementation/Code:** The following is the code for enneadiag

    public static double[][] enneadiag(int nx, int ny){
        int width = nx * ny;
        double[][] output = new double[9][width];

        for (int i = 0; i < width; i++) {
            output[0][i] = 1;       //U_i-1.j-1
            output[1][i] = 4;       //U_i  .j-1
            output[2][i] = 1;       //U_i+1.j-1
            output[3][i] = 4;       //U_i-1.j
            output[4][i] = -20;     //U_i  .j
            output[5][i] = 4;       //U_i+1.j
            output[6][i] = 1;       //U_i-1.j+1
            output[7][i] = 4;       //U_i  .j+1
            output[8][i] = 1;       //U_i+1.j+1
        }
        return output;
    }

**Last Modified:** April/2020
