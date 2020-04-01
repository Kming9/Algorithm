import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long ans;
		int in, K, T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=1; i<=T; i++) {
			K = Integer.parseInt(br.readLine());
			for(int j=0; j<K; j++) {
				in = Integer.parseInt(br.readLine());
				if(in==0) stack.pop();
				else stack.push(in);
			}
			
			ans = 0;
			while(!stack.isEmpty()) {
				ans += stack.pop();
			}
			
			bw.append("#"+i+" "+ans+"\n");
		}
		bw.close();
	}
}
