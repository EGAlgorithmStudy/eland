package week8;

import java.io.*;
import java.util.*;

public class boj_15652 {

    static int N;
    static int M;

    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(1,0);

    }

    public static void dfs(int number, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = number; i <= N; i++) {
            result[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
