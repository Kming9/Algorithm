import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, s, T = Integer.parseInt(st.nextToken());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Integer[] inputs = new Integer[N];
			
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<N; k++) inputs[k] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(inputs, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			
			s = bi(M, inputs);
			if(M==inputs[s]) s+=1;
			
			int temp, max = -1;
			out: for(; s<N-1; s++) {
				for(int k=1; k<N-s; k++) {
					temp = inputs[s] + inputs[s+k];
					if(temp == M) {
						max = M;
						break out;
					}
					else if(temp > M) continue;
					else {
						if(max < temp) max = temp;
						break;
					}
				}
			}
			bw.append("#"+i+" "+max+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static int bi(int target, Integer[] inputs) {
		int mid = 0, left = 0, right = inputs.length-1;
		
		while(right >= left) {
			mid = (right + left)/2;

			if(target == inputs[mid]) break;
			
			if(target > inputs[mid]) right = mid-1;
			else left = mid+1;
		}
		
		return mid;
	}
}
