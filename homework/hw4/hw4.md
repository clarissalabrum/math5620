# Homework 4

## Task 1

The finite difference code for a basic general linear elliptic problem is linearTridiag. It takes an array of coefficients and returns a 
tridiagional matrix in the form of a two dimensional array.

[linearTridiag Code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/TridiagMatrix.java)

[linearTridiag Software Manual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/linearTridiag.md)

To solve the system of linear equations **AU=F** one would use the following 
commands in order.

    double[][] A = TridiagMatrix.linearTridiag(a.length, a);
    double[] F = TridiagMatrix.rhs(f, alpha, beta, h, size);
    double[] U = TridiagMatrix.solver(F, A, size);

## Task 2

The rate of convergence can be found with a newly create routine rateOfConverg

[rateOfConverg Software Manual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/rateOfConverg.md)

For this problem:
[Set Up Code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/task2_main.java)
* u(0) = u(1) = 0
* f(x) = x-x^2
* k(x) = 1
* n - powers of 2 till 2048

The exact solution is 1/6 x^3 - 1/12 x^4 - 1/12 x

The rate of convergence achieved is 0.5317018703917756.

## Task 3

For this task I had to use the method that uses a large h as the exact answer and
compare the smaller h approximations to the large one.

For this problem:
[Set Up Code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/task3_main.java)
* u(0) = u(1) = 0
* f(x) = x-x^2
* k(x) = sin(pix)
* n - powers of 2 till 2048

I used the following finite difference approximation for the problem adjusting the 
usual diagionals (1, -2, 1) with new ones for the problem.

sin(PIx)(U_i-1 - 2U_i + U_i+1) + PI * h / 2 * cos(PIx)(U_i+1 - U_i-1) = h^2 f(x)

Using this finite difference approximation the rate of convergence for the problem came out to be 1.3252816786294679.

## Task 4

Using the given array and the linearTridiag Method the following approximation was made.

    0.0,-0.0002322,-0.0004113,-0.0005800,-0.0006964,-0.0007781,-0.0009377,-0.0011408,-0.0012541,-0.0013643,-0.0015365,-0.0018394,-0.0019506,-0.0020338,-0.0021218,-0.0022514,-0.0025812,-0.0029172,-0.0030823,-0.0031791,-0.0032765,-0.0033690,-0.0034446,-0.0035130,-0.0035776,-0.0036712,-0.0038256,-0.0039150,-0.0040091,-0.0043694,-0.0046112,-0.0047290,-0.0048222,-0.0049595,-0.0051204,-0.0051945,-0.0052497,-0.0053024,-0.0053740,-0.0055470,-0.0056338,-0.0057179,-0.0057889,-0.0058311,-0.0058729,-0.0059067,-0.0059474,-0.0060387,-0.0061119,-0.0061628,-0.0062022,-0.0062286,-0.0062684,-0.0063066,-0.0063305,-0.0063749,-0.0064128,-0.0064285,-0.0064422,-0.0064667,-0.0064893,-0.0065051,-0.0065149,-0.0065200,-0.0065231,-0.0065244,-0.0065236,-0.0065201,-0.0065138,-0.0065037,-0.0064917,-0.0064814,-0.0064656,-0.0064486,-0.0064276,-0.0064005,-0.0063720,-0.0063421,-0.0062982,-0.0062494,-0.0062226,-0.0061818,-0.0058881,-0.0058036,-0.0057681,-0.0057164,-0.0056385,-0.0055904,-0.0055358,-0.0054859,-0.0054466,-0.0053944,-0.0053424,-0.0052639,-0.0051074,-0.0050491,-0.0049755,-0.0048882,-0.0047722,-0.0040032,-0.0038323,-0.0036513,-0.0034507,-0.0032233,-0.0029869,-0.0028916,-0.0028093,-0.0026374,-0.0025175,-0.0024480,-0.0023547,-0.0022469,-0.0021300,-0.0019790,-0.0018582,-0.0017234,-0.0016261,-0.0015621,-0.0014497,-0.0012576,-0.0011474,-0.0010541,-0.0009238,-0.0005818,-0.0003899,-0.0003010,-0.0002294,-0.0001178,0.0
    
[Set Up Code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/task4_main.java)

    
## Task 5

Only code needed to write was linearTridiag and rateOfConverg noted in task 2.

[linearTridiag Software Manual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw4/linearTridiag.md)

Previous methods in TridiagMatrix Class were modified

[tridiag Software Manual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/tridiag.md)

[rhs Software Manual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/rhs.md)

[solver SoftwareManual](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/solver.md)

## Task 6

Math24 helped me realize that problems in the form (k(x)u')'=f(x) are 
equivalent to u'' + p(x)u' = h(x). Solving equations of this form has the 
same process as if p(x) and h(x) were constant. The difference between
the initial value problems of this form and the boundary value problems
is that the boundary value problems do not guarantee uniqueness and existence.

[Math24](https://www.math24.net/second-order-linear-homogeneous-differential-equations-constant-coefficients/)

[personal.psu](http://www.personal.psu.edu/sxt104/class/Math251/Notes-2nd%20order%20ODE%20pt1.pdf)
