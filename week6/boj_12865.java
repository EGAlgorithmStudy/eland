package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] bag = new int[N][2];
        int[] ableBag = new int[K + 1];

        // 물품 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());  // 무게
            bag[i][1] = Integer.parseInt(st.nextToken());  // 가치
        }


        for (int i = 0; i < N; i++) {
            int weight = bag[i][0];
            int value = bag[i][1];

            // 앞에서 부터 하니까 앞에 꺼가 갱신 먼저 되서 에러뜨더라
            for (int j = K; j >= weight; j--) {
                ableBag[j] = Math.max(ableBag[j], ableBag[j - weight] + value);
            }
        }

        System.out.println(ableBag[K]);
    }
}