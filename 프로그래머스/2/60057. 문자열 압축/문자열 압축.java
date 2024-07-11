import java.util.HashSet;

class Solution {
    public int solution(String s) {

        HashSet<String> set = new HashSet<>();
        int minCompressionLength = 1000;
        // 압축 후 문자열이 가장 짧게 구성되도록 구현
        // 최대는 s 문자열 길이/2부터 시작해서 체크하는 식으로 구성
        // 최소 문자 길이를 저장하는 변수 설정해 찾으면 대체하는 식으로 구성
        if(s.length()==1) return 1;
        int max = s.length() / 2;
        while(max>=1){
            String str = compressionString(s, max);
            if(str.length() < minCompressionLength) minCompressionLength = str.length();
            max--;
        }
        
        
        return minCompressionLength;
    }
    public String compressionString(String s, int max){
        String result = "";
        int repeat = 1;
        
        for(int start=max;start<=s.length();start+=max){
            String current = "";
            if(start+max<=s.length()) current= s.substring(start,start+max);
            int end=start;
            if(start+max>s.length()) end=s.length();
            String previous = s.substring(start-max, end);
            if(current.equals(previous)) repeat++;
            else{
                if(repeat == 1) result += previous;
                else {
                    result += (Integer.toString(repeat) + previous);
                }
                repeat = 1;
            }
        }
        return result;
    }
}