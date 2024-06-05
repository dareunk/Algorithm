class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = ""; String currentFinger="";
        int lastLeftFinger = -1; int lastRightFinger = -1;
        String myHand = (hand.equals("right"))? "R":"L";
        
        
        for(int i=0; i<numbers.length; i++){
            
            if(currentFinger.equals("L")) lastLeftFinger = numbers[i-1];
            else if(currentFinger.equals("R")) lastRightFinger = numbers[i-1];
            
            switch(numbers[i]){
                case 1,4,7 -> currentFinger = "L";
                case 3,6,9 -> currentFinger = "R";
                case 2,5,8,0 -> {
                    // 거리 계산 
                    int leftDistance = getDistance(lastLeftFinger, numbers[i]);
                    int rightDistance = getDistance(lastRightFinger, numbers[i]);
                    if(leftDistance == rightDistance){ currentFinger = myHand; break;}
                    else if(leftDistance > rightDistance) { currentFinger = "R"; break;}
                    else {currentFinger = "L"; break;}
                }
            }
            answer += currentFinger;
        }
        
        return answer;
    }
    public int getDistance(int lastPosition, int number){
        
        int[][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};

        int totalDistance = 0;
        int[] currentPosition;
        if(lastPosition == -1) currentPosition = new int[]{3,0};
        else currentPosition = keypad[lastPosition];
        int[] futurePosition = keypad[number];
        
        int y = Math.abs(currentPosition[0] - futurePosition[0]);
        int x = Math.abs(currentPosition[1] - futurePosition[1]);
        
        return (x+y);
    }
}