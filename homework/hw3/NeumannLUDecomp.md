**Routine Name:** NeumannLUDecomp

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** This class initializes a tridiagional matrix A and the right
hand side matrix b with Neumann boundary conditions and solves it 
using LU decomposition

**Input:** The Class constructor requires a number of steps, the function values at the 
steps in the form of an array, the Neumann Boundary conditions called alpha and beta, and
the h which is found with the step size.

**Output:** The class will create an object of the LUDecomp in which it will print out 
the final solution to the console.

**Usage/Example:**

To create an instance of the class a statement of the following form is needed.

    new NeumannLUDecomp(n, f, alpha, beta, h);
    
Where n, f, alpha, beta, and h were described in the input section. The NeumannLUDecomp 
solves the equation in the form Ax=b, in which the points printed out are the
x matrix values.

Test Case: Homogeneous Neumann Boundary Conditions

If n were to be 8, f(x) were defined to be 10sin(2PIx), alpha is 0 and beta is 0,
then the output would look like the following.

    Solution for 8 Mesh Points
    -1.5088834764831844
    -1.5088834764831844
    -1.3983980419227864
    -1.1316626073623883
    -0.7544417382415922
    -0.3772208691207961
    -0.11048543456039805
    1.3877787807814457E-17
    1.3877787807814457E-17
    
Test Case: Unit Fluxes

If n were to be 8, f(x) were defined to be 10sin(2PIx), alpha is -10 and beta is 1,
then the output would look like the following.
    
    Solution for 8 Mesh Points
    -0.41513347648318455
    -0.5713834764831845
    -0.6171480419227865
    -0.5066626073623884
    -0.28569173824159233
    -0.06472086912079619
    0.045764565439601904
    0.078125
    0.0625


**Implementation/Code:** The following is the code for NeumannLUDecomp

[NeumannLUDecomp](https://github.com/clarissalabrum/math5620/blob/master/homework/hw3/NeumannLUDecomp.java)

    public class NeumannLUDecomp {
        private double[] b;
        private double[] Y;
        private double[] sol;
        private double[][] A;
        private double[][] L;
        private double[][] U;
        private int size;
    
        public NeumannLUDecomp(int width, double[] f, double alpha, double beta, double h) {
            size = width;
    
            A = new double[size + 1][size + 1];
            U = new double[size + 1][size + 1];
            L = new double[size + 1][size + 1];
    
            initA();
            initLU();
    
            b = rhs(f, alpha, beta, h);
            Y = forwardElim();
            sol = backwardElim();
    
            printSolution(alpha, beta);
        }
    
        private void initA(){
            for (int i = 0; i < (size+1); i++){
                A[i][i] = -2;
                if(i < (size - 2)) {
                    A[i][i+1] = 1;
                }
                if(i > 0) {
                    A[i][i-1] = 1;
                }
            }
            A[0][0] = -1;
            A[size][size] = -1;
        }
    
        private void initLU(){
            for (int i = 0; i < size + 1; i++) {
                // U Matrix
                for (int k = i; k < size + 1; k++) {
                    int sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (L[i][j] * U[j][k]);
                    U[i][k] = A[i][k] - sum;
                }
                // L Matrix
                for (int k = i; k < size + 1; k++) {
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
            b = new double[size + 1];
            double hsq = h * h;
            b[0] = alpha * hsq;
            b[size] = beta * hsq;
            for (int i = 1; i < (size); i++){
                b[i] = f[i] * hsq;
            }
            return b;
        }
    
        private double[] forwardElim() {
            double[] y = new double[size +1];
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
            double[] x = new double[size+1];
            x[size] = Y[size] / U[size][size];
            for (int i = size - 1; i >= 0; i--){
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
            for (int i = 0; i < sol.length; i++) {
                System.out.println(sol[i]);
            }
        }
    }

**Last Modified:** February/2020