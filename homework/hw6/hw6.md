# Homework 6

Working on it I promise!!!

## Task 1

Using the [runner code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/Task1.java). The problem is solved using the 
[Gauss Seidel Method](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/gaussSeidel.md)

These are the results:

    iterations: 23
     2.50  6.50  2.25
     3.00 17.00  9.50
    -7.00  3.00  4.00
    
These mathch the results of the jacobi iteration in Tasksheet 5.

## Task 2

[conjugateGradient](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/conjugateGradient.md)
## Task 3

Using this [runner code](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/Task3.java) with [conjugateGradient](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/conjugateGradient.md)
solves this problem.

## Task 4

Create Main Matrix [enneadiag](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/enneadiag.md)

Create RHS Matrix [enneaRHS](https://github.com/clarissalabrum/math5620/blob/master/homework/hw6/enneaRHS.md)

## Task 5

## Task 6

According to a paper by [J. Brakley Rosser](https://pdf.sciencedirectassets.com/271503/1-s2.0-S0898122199X00010/1-s2.0-0898122175900358/main.pdf?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEOn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJIMEYCIQDjcgywo6ciGFzNxX1ZvR9jVCjWii2Vl996llDG5yjkHAIhAObj8N5C5Qf2hms2t890ix92wZ3b3dWq4b%2BV6oF9x1F7Kr0DCPL%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEQAxoMMDU5MDAzNTQ2ODY1IgxIcSyHQlSDHtQWRasqkQPcSt2nDYHCmLQSYvPwBoHCask8w3mFSntzET%2BPhKcUgA2Bc9bgmmxyJIPjIvv1Pwz0inmcULzN2wGj4fUa4Oog1%2F4Auw6fgAxHKL45w%2FeHhQcDNtF%2Bf1Hdd6GUVZXreO9wK8Dwg%2FW5b0h1NENkGUyt3XhTznK0RuKTM6yNbI0EWn%2FzAk7aBegEWZa2jYcQ4O3AJDXZKQIUqs12lKb0q9H3F4bhfvtwiDSO2ZbNcJfQVWvZkLv8%2FiZ31p9AEQqXqDNytp8Nq0HdA9VErkg%2FWnHYIq7sfWNpwTWoFDScq1X1fwUZnabet41UXhXxz8Ab6Yc09QE8JO8MIHH4a8dRf9JUJyvJMi7DgnGmiRy502ZYNv7gO%2BhRW%2BIoS1L3jcCOhvAjQQCbIHPSMpm9%2FuxlL4tLhJNdeLib7mcUfb2sIemXUwzzN3oiO6wgkcPvzUbWN0cTtjdO%2BJWuQUU%2BTptv%2BkL3X8WF93hK6Rfcc6X%2BijUYeW3QMusvgnUSCbji%2FN86iFr2NEeIdM8sIQZgj6Utjk0PSDCHqb30BTrqAYxG%2B47ndb7kG4UIndTqVB4TRBurtTthH95%2BrNGbGMfQv9rSEP0SpuhPxrvo%2FpiE6hCEGDC5IPAvo%2BbP7tReUCy7TNp0lhVlxn%2BPyZ8kBRpYot8uJd2GxqtBH2%2BqxXQsG%2BrqJKlsy9NbfyGpwJBWinV52IR%2BDnX64VH4mkBazSFCOaF3FrWZHdEgpaRdVjvPiKjV%2FiM8gzFuAuHKJ95TlV%2BCClCL7eb2TX5NsUCAQlV%2F0Bn1S%2FMJnvbb14DlhHbe3U0Hk6dIZkVZ1v%2BPV9iiPQsk7rZJdYgLvMzjRbzHPBBPFyw8HyU2xBVAvQ%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200409T174822Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAQ3PHCVTYTF7K7SQR%2F20200409%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=affc32b4dfc52ff5ca4024951b71ca0e8bd6af9a495dfe1027984b8b44883939&hash=52e39cd06295811bd6aa5ca9cbc755b3f1667479b84aa709c69475be45dc7115&host=68042c943591013ac2b2430a89b270f6af2c76d8dfd086a07176afe7c76c2c61&pii=0898122175900358&tid=spdf-22b35d01-deb8-4b84-89b6-e9ae956774d8&sid=5bb27fbd5885f3437c4b4716e263b9af0da0gxrqa&type=client) a 9-point stencil ususally only has the accuracy of O(h^2) unless the problem has f(x,y) = 0 in which case it can result in O(h^6). O(h^2) is the same as what you would get with a 5-point stencil so a 9-point stencil does not have a distinct advatange in terms of accuracy. According to our book, the 9-point stencil is able to reach that level of accuracy when f(x,y) = 0 by canceling out part of the truncation error reducing it to O(h^4). The 9-point stencil is more useful for problems where f(x,y) = 0.
