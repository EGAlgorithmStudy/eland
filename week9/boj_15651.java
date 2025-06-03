package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651 {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[M];
        dfs(1,0);


    }


    public static void dfs(int n, int depth){

        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println("");
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            dfs(n,depth+1);
            }
        }

}
