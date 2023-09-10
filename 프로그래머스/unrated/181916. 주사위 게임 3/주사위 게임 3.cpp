#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0;
    int min =10;
    //int indexNum = 10;
    int arr[4] = {a,b,c,d};
    for(int i=0;i<4;i++){
        if(arr[i]<min)
            min = arr[i];
           // indexNum = i;
    }
    // if four numbers is the same, you can put any numbers in calculation.
    if(a==b && b==c && c==d) answer = 1111*a;
    // There are is 4 cases
    else if(a==b && b==c) answer  = pow(10*a+d,2);
    else if(a==b && b==d) answer = pow(10*a+c,2);
    else if(a==c && c==d) answer = pow(10*a+b,2);
    else if(b==c && c==d) answer = pow(10*b+a,2);
    
    else if((a==b) && (c==d) || (a==c) && (b==d) ) answer= (a+d) * abs(a-d);
    else if((a==d) && (b==c)) answer = (a+b) * abs(a-b);
    
    else if(a==b) answer = c*d;
    else if(a==c) answer = b*d;
    else if(a==d) answer = b*c;
    else if(b==c) answer = a*d;
    else if(c==d) answer = a*b;
    else if(b==d) answer = a*c;
  
    else answer = min;
    
    return answer;
}