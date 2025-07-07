package week14;

public class pro_43105 {
	class Solution {
		public int solution(int[][] triangle) {
			int answer = 0;
			int triangleHeight = triangle.length;

			int[][] sum = new int[triangleHeight][];

			sum[0] = new int[1];
			sum[0][0] = triangle[0][0];

			for(int i=1; i<triangleHeight; i++){
				sum[i] = new int[i+1];
				for(int j=0; j<=i; j++){
					if(j==0){
						sum[i][j] = sum[i-1][j]+triangle[i][j];
					}
					else if(j==i){
						sum[i][j] = sum[i-1][j-1]+triangle[i][j];
					}
					else{
						sum[i][j] = Math.max(sum[i-1][j-1],sum[i-1][j])+triangle[i][j];
					}
				}
			}

			for (int val : sum[triangleHeight - 1]) {
				answer = Math.max(answer, val);
			}

			return answer;
		}
	}
}
