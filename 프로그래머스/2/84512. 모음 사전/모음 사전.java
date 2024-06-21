import java.util.LinkedHashMap;

class Solution {
    LinkedHashMap<String, Integer> dictionary;
    int dictionaryIndex = 0;
    char[] order = {'A','E','I','O','U'};
    
    public void setDictionary(String w){
            dictionary.put(w, dictionaryIndex++);
            if(w.length() == 5) return;
            for(int i=0;i<order.length;i++) setDictionary(w+order[i]);    
    }
    public int solution(String word) {
        int answer = 0;
        dictionary = new LinkedHashMap<>();
        setDictionary("");
        answer = dictionary.get(word);
        return answer;
    }
}