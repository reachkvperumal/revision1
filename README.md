# revision1
Interview Kickstart Revision V1
### https://www.programiz.com/dsa

## Tech Stack
* JDK 11.05

https://stackoverflow.com/questions/12952024/how-to-implement-infinity-in-java

| #Operation              |    #Result     |
| ----------------------- | ---------------|
| n ÷ ±Infinity           | 0              |
| ±Infinity × ±Infinity   | ±Infinity      |
| ±nonzero  ÷ 0           | ±Infinity      |
| ±Infinity × ±Infinity   | ±Infinity      |
|  Infinity  + Infinity   |  Infinity      |
| ±0 ÷ ±0                 |  NaN           |
|  Infinity -  Infinity   |  NaN           |
| ±Infinity ÷ ±Infinity   |  NaN           |
| ±Infinity × 0           |  NaN           |


```

https://www.hackerearth.com/practice/notes/abhinav92003/why-output-the-answer-modulo-109-7/
10^9 +7 = 1000000007
        1. (a + b) % c = ( (a % c) + (b % c)) % c
            (a + b + c) % M is the same as ( ( ( a + b ) % M ) + c ) % M.

        2. (a - b) % c = ( (a % c) - (b % c)) % c
        3. (a * b) % c = ( (a * c) - (b * c)) % c
        4. (a / b) % c NOT EQUAL TO ( ( a % c ) / ( b % c ) ) % c
        So, modulo is distributive over +, * and - but not / .
```

## Table of contents
* Sorting
* Recursion
* Tree
* Graph
* Dynamic Programming
* Concurrency
