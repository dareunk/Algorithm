function isPrime(n){
    if(n <= 1) return false;
    for(let i=2; i<=Math.sqrt(n); i++){
        if(n % i == 0) return false;
    }
    return true;
}

function solution(n, k) {
    var answer = 0;
    // 배열의 자리 수 구하기 
    
    // k 진수로 바꾸기
    const base = n.toString(k);
    const baseArr = base.split("0");   
    for(let i of baseArr) if(isPrime(i)) answer++;
    return answer;
}



