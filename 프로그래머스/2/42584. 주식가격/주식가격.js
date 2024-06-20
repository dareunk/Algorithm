function solution(prices) {
    var answer = new Array(prices.length).fill(0);
    var stack = [];
    
    for(let i=0; i< prices.length; i++){
        
        while(stack.length!=0 && prices[stack.at(-1)] > prices[i]){
            let index= stack.pop();
            answer[index] = i - index; 
        }
        stack.push(i);
    }
    const lastIndex = stack.pop();
    while(stack.length != 0){
        answer[stack.at(-1)] = lastIndex - stack.pop();
    }
    return answer;
}