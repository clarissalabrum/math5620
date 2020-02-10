**Routine Name:** LUDecomp

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** LUDecomp initiates a tridiagional matrix of an indicated size 
and then preforms a LU Decomposition of the matrix.

**Input:** The Class constructor requires a number of steps, the function values at the 
steps in the form of an array, the Dirichlet Boundary conditions called alpha and beta, and
the h which is found with the step size.

**Output:** The class will create an object of the LUDecomp in which it will print out 
the final solution to the console.

**Usage/Example:**

To create an instance of the class a statement of the following form is needed.

    new LUDecomp(n, f, alpha, beta, h);
    
Where n, f, alpha, beta, and h were described in the input section. if n were to be 8, f(x)
were defined to be 0, alpha is 1 and beta is 3. then the output would look like the following.

    Solution for 8 Mesh Points
    1.0
    0.6900634765625
    0.380126953125
    0.26025390625
    0.2705078125
    0.416015625
    0.76953125
    1.5078125
    3.0
    
THe LUDecomp solves the equation in the form Ax=b, in which the points printed out are the
x matrix values.

**Implementation/Code:** The following is the code for LUDecomp

[LUDecomp](https://github.com/clarissalabrum/math5620/blob/master/homework/hw3/LUDecomp.java)
    
    public class LUDecomp {
        private double[] b;
        private double[] Y;
        private double[] sol;
        private double[][] A;
        private double[][] L;
        private double[][] U;
        private int size;
    
        public LUDecomp(int width, double[] f, double alpha, double beta, double h) {
            size = width;
    
            A = new double[size - 1][size - 1];
            U = new double[size - 1][size - 1];
            L = new double[size - 1][size - 1];
    
            initA();
            initLU();
    
            b = rhs(f, alpha, beta, h);
            Y = forwardElim();
            sol = backwardElim();
    
            printSolution(alpha, beta);
        }
    
        private void initA(){
            for (int i = 0; i < (size-1); i++){
                A[i][i] = -2;
                if(i < (size - 2)) {
                    A[i][i+1] = 1;
                }
                if(i > 0) {
                    A[i][i-1] = 1;
                }
            }
        }
    
        private void initLU(){
            for (int i = 0; i < size - 1; i++) {
                // U Matrix
                for (int k = i; k < size - 1; k++) {
                    int sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (L[i][j] * U[j][k]);
                    U[i][k] = A[i][k] - sum;
                }
                // L Matrix
                for (int k = i; k < size - 1; k++) {
                    if (i == k)
                        L[i][i] = 1; // Diagonal as 1
                    else {
                        int sum = 0;
                        for (int j = 0; j < i; j++)
                            sum += (L[k][j] * U[j][i]);
                        L[k][i] = (A[k][i] - sum) / U[i][i];
                    }
                }
            }
        }
    
        private double[] rhs(double[] f, double alpha, double beta, double h){
            b = new double[size -1];
            double hsq = h * h;
            b[0] = (f[0] * hsq) - alpha;
            b[size -2] = (f[size -2] * hsq) -beta;
            for (int i = 1; i < (size - 2); i++){
                b[i] = f[i] * hsq;
            }
            return b;
        }
    
        private double[] forwardElim() {
            double[] y = new double[size -1];
            y[0] = b[0] / L[0][0];
            for (int i = 1; i < b.length; i++) {
                double sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += L[i][j] * y[j];
                }
                y[i] = b[i] - sum;
            }
            return y;
        }
    
        private double[] backwardElim() {
            double[] x = new double[size-1];
            x[size - 2] = Y[size - 2] / U[size - 2][size - 2];
            for (int i = size - 3; i >= 0; i--){
                double sum = 0;
                for (int j = i + 1; j < Y.length; j++) {
                    sum += U[i][j] * x[j];
                }
                x[i] = (Y[i] - sum) / U[i][i];
            }
            return x;
        }
    
        private void printSolution(double alpha, double beta) {
            System.out.println("Solution for " + size + " Mesh Points");
            System.out.println(alpha);
            for (int i = 0; i < sol.length; i++) {
                System.out.println(sol[i]);
            }
            System.out.println(beta);
        }
    }

**Last Modified:** February/2020