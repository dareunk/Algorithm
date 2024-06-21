import java.util.LinkedHashMap;

// 여기서 시간 단축을 하기 위해서는 map을 제작하다가 사용자가 원하는 단어를 찾으면 map만들기를 중단하는 코드도 포함하면 좋을 듯
class Solution {
    LinkedHashMap<String, Integer> dictionary;
    int dictionaryIndex = 0;
    String userWord;
    char[] order = {'A','E','I','O','U'};
    
    public void setDictionary(String w){
            dictionary.put(w, dictionaryIndex++);
            if(w == userWord) return;
            if(w.length() == 5) return;
            for(int i=0;i<order.length;i++) setDictionary(w+order[i]);    
    }
    public int solution(String word) {
        int answer = 0;
        userWord = word;
        dictionary = new LinkedHashMap<>();
        setDictionary("");
        answer = dictionary.get(word);
        return answer;
    }
}