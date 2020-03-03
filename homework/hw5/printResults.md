**Routine Name:** printResults

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Take the results that would come from using the 
solver method and print the results with the Dirichlet boundary conditions

**Input:** Requires the following parameters

* double alpha - beginning boundary condition
* double beta - ending boundary condition
* double[] U - results

**Output:** Displays the results to the screen in one line with a comma
in between each value.

**Usage/Example:**

To call the method the code as the following needs to be used.

    TridiagMatrix.printResults(alpha, beta, U);

The output from the lines above will be in the same form as the following.

    1.0,0.9049422,0.8083358,0.7103463, . . . ,-0.8083358,-0.9049422,-1.0


**Implementation/Code:** The following is the code for printResults

[printResults]()

    public static void printResults(double alpha, double beta, double[] U){
        System.out.print(alpha + ",");
        for (int i = 0; i < U.length; i++){
            System.out.printf("%.7f,", U[i]);
        }
        System.out.print(beta);
    }

**Last Modified:** March/2020
