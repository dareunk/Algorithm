#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    // if there is no the remainder, when they order answer pizzas which have 6 pieces each
    
    int num = 1;
    
    // if the result is 0, then put num to answer
    while(((num*6) % n ) != 0){
        num++;
    }
    answer = num; 
    return answer;
}