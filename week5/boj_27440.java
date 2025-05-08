package week5;

import java.io.*;
import java.util.*;

public class boj_27440 {

    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        bfs(N);

        System.out.println(answer);

    }

    public static void bfs(Long N){

        Queue<Long[]> queue = new LinkedList<>();
        //배열로 visited check이 안됨
        HashSet<Long> visited = new HashSet<>();

        queue.add(new Long[]{N, Long.valueOf(0)});


        while(!queue.isEmpty()) {
            Long[] number = queue.poll();
            //number[0]가 현재 숫자고 number[1]이 이때까지 거쳐온 횟수
            if(number[0]==1){
                answer =  number[1];
                return;
            }

            if (number[0] % 3 == 0 && !visited.contains(number[0] / 3)) {
                visited.add(number[0]/3);
                queue.add(new Long[]{number[0]/3, number[1]+ 1});
            }

            if(number[0] % 2 ==0 && !visited.contains(number[0]/2)){
                visited.add(number[0]/2);
                queue.add(new Long[]{number[0]/2,number[1]+1});
            }
            if(number[0]-1>1&& !visited.contains(number[0]-1)){
                visited.add(number[0]-1);
                queue.add(new Long[]{number[0]-1,number[1]+1});
            }
        }
    }



}
