package week3;

import java.io.*;
import java.util.*;

public class boj_1647 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[M][3];
        parent = new int[N+1];
        int costSum = 0;
        int maxEdge = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());     //start 집
            graph[i][1] = Integer.parseInt(st.nextToken());     //end 집
            graph[i][2] = Integer.parseInt(st.nextToken());     //cost
        }

        Arrays.sort(graph, (a, b)
                -> Integer.compare(a[2], b[2]));            //cost로 graph배열을 정렬함. (오름차순)

        for(int i=1; i<=N; i++){        //초기에는 자기자신이 부모
            parent[i] = i;
        }


        for(int i=0; i<M; i++){
            boolean check = union(graph[i][0],graph[i][1]);
            if(check){
                costSum+= graph[i][2];      //만약 유니온이 이루어진다면 cost를 더해줌
                maxEdge = Math.max(maxEdge,graph[i][2]);
            }
        }

        costSum -= maxEdge;

        System.out.println(costSum);

    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        else {          //재귀로 거슬러 올라가면서 부모 찾기(자기자신을 부모로 갖는 노드 = 루트노드 찾을때까지)
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean union(int x,int y){
        x = find(x);
        y = find(y);

        if(x!=y){           //부모가 다르면
            parent[y] = x;      //y를 x에 붙임
            return true;        //붙여짐
        }

        return false;       //안 합쳐짐
    }



}
