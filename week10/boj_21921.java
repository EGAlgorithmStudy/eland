package week10;

import java.io.*;
import java.util.*;

public class boj_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitor = new int[N];
        int xVisitor = 0;
        int howMany = 1;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<X; i++){
            xVisitor += visitor[i];
        }

        int maxVisitor = xVisitor;

        for(int i=X; i<N; i++) {
            xVisitor = xVisitor + visitor[i] - visitor[i - X];
            if(xVisitor>maxVisitor){
                howMany = 1;
                maxVisitor = xVisitor;
            }
            else if(maxVisitor==xVisitor){
                howMany++;
            }

        }

        if(maxVisitor==0){
            System.out.println("SAD");
        }
        else{
            System.out.println(maxVisitor);
            System.out.println(howMany);
        }


    }
}
