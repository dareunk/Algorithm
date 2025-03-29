class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        // 분모가 같도록 만듦-최소공배수
        int denom = lcm(denom1, denom2);
        int num1 = numer1 * (denom/denom1);
        int num2 = numer2 * (denom/denom2);
        // 히든케이스1 : 결과가 나누어지는 경우
        int[] answer = {(num1+num2), denom};
        // 최대공약수가 1이면 서로소
        int g = gcd(answer[0],answer[1]);
        if(g==1) return answer;
        answer[0] = answer[0] / g;
        answer[1] = answer[1] / g;
        return answer;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }
}