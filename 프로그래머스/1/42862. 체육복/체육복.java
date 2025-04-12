import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // -1 or +1 학생에게만 체육복 대여가 가능
        // 체육복을 최대한 많이 공유해 최대한 많은 학생이 수업을 들어야 함
        // 체육복 도난 학생 번호 int[] lost, 여별 옷 가진 학생 번호 int[] reserve
        
        // case1. 전체 학생이 도난당한 경우
        // case2. n이 2인 경우 
        // case3. 여벌 체육복을 가져온 학생이 도난을 당하는 경우는 자기가 입고 다른 학생에게는 체육복을 빌려주지 않음(완전 중요한 히든 케이스) -> lost[2,3]이고 reserve[1,2]인 경우를 생각 !
        // 도난당하거나 여벌을 가진 학생의 번호는 중복되지 않기 때문에 그 외의 경우는 생각 X
        
        //** lost와 reverse 배열을 오름차순으로 정렬(테스트 케이스)
        // 당연히 오름차순으로 정렬되어 있을 거라고 생각하지 말자...
        int[] student = new int[n];
        for(int i : lost) student[i-1]-=1;
        for(int i : reserve) student[i-1] +=1;

        for(int i=0;i<student.length;i++){
            if(student[i] == 1){
                if(i!=0&&student[i-1]==-1){
                    student[i-1]+=1;
                    student[i]-=1;
                }else if(i!=n-1&&student[i+1]==-1){
                    student[i+1]+=1;
                    student[i]-=1;
                }
            }
        }
        // student배열 내에서 0인 경우 찾아 개수 반환
        answer = (int)Arrays.stream(student).filter(i->i>=0).count();
        return answer;
    }
}