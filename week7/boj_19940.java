package week7;

import java.io.*;
import java.util.*;

public class boj_19940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int time = Integer.parseInt(br.readLine());

            oven(time);
        }

    }

    public static void oven(int time){
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(new int[]{0,0,0,0,0});        //time, addt, mint, addo, mino
        visited.add(0);



        int addh = time/60;
        int remainTime = time%60;



        if(remainTime>35){
            addh++;
            time = remainTime-60;
        }
        else{
            time = remainTime;
        }

        while(!queue.isEmpty()){

            int[] pizzaStatus = queue.poll();
            int nowTime = pizzaStatus[0];
            int addt = pizzaStatus[1];
            int mint = pizzaStatus[2];
            int addo = pizzaStatus[3];
            int mino = pizzaStatus[4];

            if(nowTime==time){
                System.out.println(addh+" "+addt+" "+mint+" "+addo+" "+mino);
                return;
            }


            if(nowTime<time){
                int newTime = nowTime+10;
                if(!visited.contains(newTime)){
                    queue.add(new int[]{newTime,addt+1,mint,addo,mino});
                    visited.add(newTime);
                }
            }

            if(nowTime>time){
                int newTime = nowTime-10;
                if(!visited.contains(newTime)){
                    queue.add(new int[]{newTime,addt,mint+1,addo,mino});
                    visited.add(newTime);
                }
            }

            if(nowTime<time){
                int newTime = nowTime+1;
                if(!visited.contains(newTime)){
                    queue.add(new int[]{newTime,addt,mint,addo+1,mino});
                    visited.add(newTime);
                }
            }

            if(nowTime>time){
                int newTime = nowTime-1;
                if(!visited.contains(newTime)){
                    queue.add(new int[]{newTime,addt,mint,addo,mino+1});
                    visited.add(newTime);
                }
            }

        }
    }
}
