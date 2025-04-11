package week2;

import java.io.*;
import java.util.*;

public class boj_1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] targetNum = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            targetNum[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque();

        for(int i=0; i<N; i++){
            deque.offerLast(i+1);
        }

        for(int i=0; i<M; i++) {
            int target = targetNum[i];
            int leftCnt = 0;
            int rightCnt = 0;

            Deque<Integer> leftTemp = new ArrayDeque<>(deque);
            Deque<Integer> rightTemp = new ArrayDeque<>(deque);

            while (leftTemp.peekFirst() != target) {
                leftOper(leftTemp);
                leftCnt++;
            }
            while (rightTemp.peekFirst() != target) {
                rightOper(rightTemp);
                rightCnt++;
            }

            if (leftCnt <= rightCnt) {
                for (int j = 0; j < leftCnt; j++) {
                    leftOper(deque);
                }
                answer += leftCnt;
            }
            else {
                for (int j = 0; j < rightCnt; j++) {
                    rightOper(deque);
                }
                answer += rightCnt;
            }
            deque.pollFirst();
        }

        System.out.println(answer);
    }

    public static void leftOper(Deque<Integer> deque){          //2번 연산 (처음꺼 빼기,왼쪽으로 한칸 이동)
        int peek = deque.pollFirst();
        deque.offerLast(peek);
    }

    public static void rightOper(Deque<Integer> deque){        //3번 연산 (마지막꺼 빼기, 오른쪽으로 한칸 이동)
        int peek = deque.pollLast();
        deque.offerFirst(peek);
    }



}
