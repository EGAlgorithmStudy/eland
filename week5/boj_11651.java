package week5;

import java.io.*;
import java.util.*;

public class boj_11651 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                points[i][0] = Integer.parseInt(input[0]);
                points[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(points, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            for (int i=0; i<points.length; i++) {
                System.out.println(points[i][0] + " " + points[i][1]);
            }
        }
}
