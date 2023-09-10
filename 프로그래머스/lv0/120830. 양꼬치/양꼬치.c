#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int k) {
    int answer = 0;
    
    int free = n / 10;
    int totalDrinks = k - free;
    
    int totalPrice = n * 12000 + totalDrinks*2000;
    answer = totalPrice;
    
    return answer; 
    
}