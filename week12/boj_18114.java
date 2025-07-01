package week12;

import java.io.*;
import java.util.*;

public class boj_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] item = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            item[i] = Integer.parseInt(st.nextToken());
            if(item[i]==C){
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(item);

        int left = 0;
        int right = N-1;

        while(left<right){

            int sum = item[left] + item[right];

            if(sum==C){
                System.out.println(1);
                return;
            }
            else if(sum>C){
                right--;
            }
            else if(sum<C){
                left++;
            }
        }


        for(int i=0; i<N-2; i++){
            int newC = C-item[i];
            left = i+1;
            right = N-1;

            while(left<right) {
                int sum = item[left] + item[right];

                if (sum == newC) {
                    System.out.println(1);
                    return;
                } else if (sum > newC) {
                    right--;
                } else if (sum < newC) {
                    left++;
                }
            }
        }

        System.out.println(0);;
    }
}
