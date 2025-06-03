package week6;

import java.io.*;
import java.util.*;

public class boj_14876 {
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // A물통 용량
        int b = Integer.parseInt(st.nextToken()); // B물통 용량
        int c = Integer.parseInt(st.nextToken()); // 목표 A
        int d = Integer.parseInt(st.nextToken()); // 목표 B

        waterBottle(a, b, c, d);
        System.out.println(answer);
    }

    public static void waterBottle(int a, int b, int c, int d) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        //HashSet<int[]> visited = new HashSet<>(); int[]는 참조형이라 동일한 값이라도 new int[]로 넣어준 객체가 모두 달라서 늘 false로 뜸

        queue.add(new int[]{0, 0, 0}); //a에도 0 b에도 , 횟수 0번
        visited.add("0,0");


        while (!queue.isEmpty()) {
            int[] bottle = queue.poll();
            int nowA = bottle[0];
            int nowB = bottle[1];
            int count = bottle[2];


            if (nowA == c && nowB == d) {
                answer = count;
                return;
            }

            if (nowA < a) {
                int nextA = a;
                int nextB = nowB;
                String key = nextA + "," + nextB;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{nextA, nextB, count + 1});
                }
            }

            if (nowB < b) {
                int nextA = nowA;
                int nextB = b;
                String key = nextA + "," + nextB;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{nextA, nextB, count + 1});
                }
            }

            if (nowA != 0) {
                int nextA = 0;
                int nextB = nowB;
                String key = nextA + "," + nextB;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{nextA, nextB, count + 1});
                }
            }

            if (nowB != 0) {
                int nextA = nowA;
                int nextB = 0;
                String key = nextA + "," + nextB;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{nextA, nextB, count + 1});
                }
            }

            int aToB = Math.min(nowA, b - nowB);
            int nextA = nowA - aToB;
            int nextB = nowB + aToB;
            String key = nextA + "," + nextB;
            if (!visited.contains(key)) {
                visited.add(key);
                queue.add(new int[]{nextA, nextB, count + 1});
            }

            int bToA = Math.min(nowB, a - nowA);
            nextA = nowA + bToA;
            nextB = nowB - bToA;
            key = nextA + "," + nextB;
            if (!visited.contains(key)) {
                visited.add(key);
                queue.add(new int[]{nextA, nextB, count + 1});
            }
        }
    }
}
