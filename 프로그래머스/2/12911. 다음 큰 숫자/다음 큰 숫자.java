class Solution {
    public int solution(int n) {
    // 증가시켜가며 1의 개수만 맞는지 확인하면 되는 쉬운 문제
        
    int numberOf1 = Integer.bitCount(n);
    
    int num=0;
    int answer=n;
    while(numberOf1 != num){
        answer++;
        num = Integer.bitCount(answer);
    }
    return answer;
    }
}