#include <string>
#include <cmath>
#include <vector>

using namespace std;

int solution(int n, int t) {
    int answer = 0;
    int i=0;
    while(i<t){
        n = n*2;
        i++;
    }
    answer = n;
    
    return answer;
}