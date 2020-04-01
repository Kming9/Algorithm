import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int ans, temp, n, m, seq, T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int[] rate = new int[n+1];
			int[] weight = new int[m+1];
			int[] info = new int[m+1];
			PriorityQueue<Integer> empty = new PriorityQueue<>();
			Queue<Integer> wait = new LinkedList<>(); 
			
			for(int k=1; k<=n; k++) {
				rate[k] = Integer.parseInt(br.readLine());
				empty.add(k);
			}
			for(int k=1; k<=m; k++) weight[k] = Integer.parseInt(br.readLine());
			
			ans = 0;
			seq = 2*m;
			for(int k=0; k<seq; k++) {
				temp = Integer.parseInt(br.readLine()); //몇 번째 차량인지
				if(temp>0) {
					if(empty.isEmpty()) wait.add(temp);
					else {
						info[temp] = empty.poll();
						ans += rate[info[temp]] * weight[temp]; // (*)
					}
				}else {
					temp *= -1;
					empty.add(info[temp]);
					if(!wait.isEmpty()) {
						temp = wait.poll();
						info[temp] = empty.poll();
						ans += rate[info[temp]] * weight[temp]; // 계산하는 부분을 method로 빼기(유지보수 생각하면) - *
					}
				}
			}
			bw.append(String.format("#%d %d\n", i, ans));
		}
		bw.close();
	}
}
