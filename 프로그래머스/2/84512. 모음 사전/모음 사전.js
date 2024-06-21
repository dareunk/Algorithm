const order = ["A","E","I","O","U"];
let dictionary = new Map();
let dictionaryIndex = 0;

function solution(word) {
    var answer = 0;
    setDictionary("");
    answer = dictionary.get(word);
    return answer;
}
function setDictionary(w){
    // 맨 처음 ""가 0이 되고 A부터 1로 시작하게 됨
    dictionary.set(w,dictionaryIndex++);
    if(w.length == 5) return;
    for(let i=0;i<order.length;i++) setDictionary(w+order[i]);
}