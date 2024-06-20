function solution(numbers) {
    var answer = new Array(numbers.length).fill(-1);
    // 시간초과 발생
    /*
    for(let i=0; i<numbers.length; i++){
        let currentNumber = numbers[i];
        for(let j=i+1;j<numbers.length;j++){
            if(currentNumber < numbers[j]) {answer[i] = numbers[j]; break;} 
        }
        if(answer[i]==null) answer[i] = -1;
    }
    */
    // stack을 이용
    var stack = [];
    for(let i=0;i<numbers.length;i++){
        while((stack.length!=0) && (numbers[stack.at(-1)] < numbers[i])){
            answer[stack.pop()] = numbers[i];
        }
        stack.push(i);
    }
    
    
    return answer;
}