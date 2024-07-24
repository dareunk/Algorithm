//연산자 + - *
//우선순위는 다 다름
//절대값을 기준으로 가장 큰 숫자가 선택
import java.util.Stack;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    ArrayList<Character> operator = new ArrayList<>();
    ArrayList<Long> operand = new ArrayList<>();
    
    public long solution(String expression) {
        // 피연산자와 연산자를 구분해야함
        initialExpression(expression);

        // 우선순위에 따른 값 
        // 총 6가지 경우의 수
        long[] arr = new long[6];
        arr[0]= priorityCalculator('+','*','-');
        arr[1]= priorityCalculator('+','-','*');
        arr[2] = priorityCalculator('*','+','-');
        arr[3] = priorityCalculator('*','-','+');
        arr[4] = priorityCalculator('-','+','*');
        arr[5] = priorityCalculator('-','*','+');
        System.out.println(arr[2]);
        long answer = Arrays.stream(arr).max().getAsLong();
        return answer;
    }
    public long priorityCalculator(char first, char second, char third){
        ArrayList<Character> listOperator = new ArrayList<>();
        ArrayList<Long>  listOperand= new ArrayList<>();
        
        listOperator.addAll(operator);
        listOperand.addAll(operand);
        
        char[] priority = {first, second, third};
        
        for(int i=0; i<priority.length;i++){
            for(int j=0;j<listOperator.size();j++){
                if(listOperator.get(j).equals(priority[i])){
                    long t1 = listOperand.get(j);
                    long t2 = listOperand.get(j+1);
                    long result = calculator(t1,t2,priority[i]);
                    
                    listOperand.remove(j+1);
                    listOperand.remove(j);
                    listOperator.remove(j);
                    
                    listOperand.add(j,result);
                    j--;
                }
                
            }
        }
        return Math.abs(listOperand.get(0));
    }
    public long calculator(long t1, long t2, char oper){
        long result = 0;
        switch(oper){
            case '*':
                result = t1*t2;
                break;
            case '-':
                result = t1-t2;
                break;
            case '+':
                result = t1+t2;
                break;
        }
        return result;
    }
    public void initialExpression(String expression){
        String temp = "";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '-'|| expression.charAt(i) == '+'){
                operand.add(Long.parseLong(temp));
                operator.add(expression.charAt(i));
                temp="";
            }
            else temp += expression.charAt(i);
        }
        // 마지막 수도 operand에 넣어줌
        operand.add(Long.parseLong(temp));
    }
}