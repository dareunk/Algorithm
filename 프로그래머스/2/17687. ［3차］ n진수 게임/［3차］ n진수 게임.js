function solution(n, t, m, p) {
    var answer = '';
    const total = t*m; // 전체 loading해야하는 숫자 개수
    let order = '';
    for(let i=0;i<=total;i++){
        order += i.toString(n).toUpperCase();
    }
    
    // 튜브의 순서 p-1(index기준)부터 시작해서 m칸씩 t개 
    let gameTimes = 0;
    let index = p-1; 
    while(gameTimes < t){
        answer += order.charAt(index);
        index += m;
        gameTimes++;
    }
    
    return answer;
}