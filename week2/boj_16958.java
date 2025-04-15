package week2;

import java.io.*;
import java.util.*;

public class boj_16958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        List<Integer> special = new ArrayList<>();

        int[][] city = new int[N][2];


        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            if(check==1){
                special.add(i);
            }
            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int dist = Math.abs(city[start-1][0] - city[end-1][0]) + Math.abs(city[start-1][1] -city[end-1][1]);        //직통거리 (맨해튼 거리)

            int specialCityCnt = special.size();

            for(int j=0 ; j<specialCityCnt; j++){
                int stopOver1 = special.get(j);
                for(int k= 0; k<specialCityCnt; k++){
                    int stopOver2 = special.get(k);
                    int teleportDist = Math.abs(city[start-1][0]-city[stopOver1][0]) + Math.abs(city[start-1][1] - city[stopOver1][1])
                            + T + Math.abs(city[stopOver2][0]-city[end-1][0]) + Math.abs(city[stopOver2][1] - city[end-1][1]);          //spectial에는 0부터 제대로 넣음 (stopOver에 -1하면 안됨)

                    dist = Math.min(dist,teleportDist);
                }
            }

            System.out.println(dist);

        }

    }


}
