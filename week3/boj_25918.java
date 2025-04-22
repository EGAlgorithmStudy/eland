package week3;

import java.io.*;

public class boj_25918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Character[] want = new Character[N];

        int leftCount =0;
        int rightCount=0;
        int count = 0;
        int maxDay = 0;

        String temp = br.readLine();

        for(int i=0; i<N; i++){
            want[i] = temp.charAt(i);
        }

        for(int i=0; i<N; i++){

            if(want[i]=='('){
                leftCount++;
                count++;

            }
            else if(want[i]==')'){
                rightCount++;
                count--;

            }
            maxDay = Math.max(maxDay,Math.abs(count));

        }

        if(leftCount!=rightCount){
            System.out.println("-1");
            return;
        }

        System.out.println(maxDay);

    }



}

