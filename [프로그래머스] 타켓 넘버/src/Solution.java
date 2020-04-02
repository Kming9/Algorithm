import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        int N = numbers.length;
        dfs(numbers, 0, 0, target, N);
        return answer;
    }
    
    void dfs(int[] numbers, int i, int sum, int tar, int N){
        if(i==N){
            if(sum==tar) answer++;
            return;
        }
        
        dfs(numbers, i+1, sum-numbers[i], tar, N);
        dfs(numbers, i+1, sum+numbers[i], tar, N);
    }
}