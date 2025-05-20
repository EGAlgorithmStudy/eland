package week7;

import java.io.*;
import java.util.*;

public class boj_9466 {

    static boolean[] visited;
    static int[] student;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());

            student = new int[n+1];
            visited = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++){
                student[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j, new ArrayList<>());
                }
            }
            System.out.println(n - count);
        }
    }

    public static void dfs(int j,ArrayList<Integer> connectStudent){
        visited[j] = true;
        connectStudent.add(j);
        int connect = student[j];

        if (!visited[connect]) {
            dfs(connect, connectStudent);
        } else {
            // 이미 방문한 학생
            int idx = connectStudent.indexOf(connect);
            if (idx != -1) {            //idx==-1은 connectStudent에 connect가 없을 때
                count += connectStudent.size() - idx;
            }
        }
    }


}
