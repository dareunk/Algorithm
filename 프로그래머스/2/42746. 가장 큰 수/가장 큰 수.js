function solution(numbers) {
    let numArr = [];
    
    for(let i=0;i<numbers.length;i++){
       numArr.push(String(numbers[i]));
    }
    
    numArr.sort((a,b)=>{
        return Number(b+a) - Number(a+b)
    });
    
    let answer = numArr.join('');
    if(Number(answer) == 0) return "0";
    else return answer;
}