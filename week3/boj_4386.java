package week3;

import java.io.*;
import java.util.*;

public class boj_4386 {

    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[][] starPos = new double[n][3];
        ArrayList<double[]> starLine = new ArrayList<>();
        parent = new int[n];
        double costSum = 0;

        //starPos [[1,1.0,1.0], [2,1.0,2.0] ~~~]
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            starPos[i][0] = i;
            starPos[i][1] = Double.parseDouble(st.nextToken());
            starPos[i][2] = Double.parseDouble(st.nextToken());
        }

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                //i번째와 j번째 점을 이었을때
                double[] temp = {i,j,dist(starPos[i][1],starPos[i][2],starPos[j][1],starPos[j][2])};
                starLine.add(temp);
            }
        }

        //starLine에 있는 객체 a 기준으로 a[2] 기준 오름차순 정렬
        starLine.sort(Comparator.comparingDouble(a -> a[2]));

        for(int i=0; i<n*(n-1)/2; i++){
            boolean check = union((int) starLine.get(i)[0], (int) starLine.get(i)[1]);

            if(check){
                costSum += starLine.get(i)[2];
            }
        }
        System.out.println(costSum);
        //System.out.println(String.format("%.2f",costSum));        -> 소수점 2자리에서 반올림.
    }

    public static int find(int x){      //부모를 찾는 함수
        if(parent[x] ==x){          //부모가 자기자신 (루트)
            return x;
        }

        //parent[x]!=x  //부모가 다르면
        return parent[x] = find(parent[x]);     //위로 올라가기
    }

    public static boolean union(int x, int y){

        //각 x와 y의 부모
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y] = x;
            return true;
        }
        return false;
    }

    public static double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }


}
