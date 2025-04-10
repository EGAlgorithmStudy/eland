package week2;

import java.io.*;
import java.util.*;

public class boj_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int commands = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque();

        //switch-case 써도 되긴 함
        for(int i=0; i<commands; i++){

            String command = br.readLine();

            String[] comm = command.split(" ");

            switch (comm[0]){
                case "push_front":
                    deque.offerFirst(comm[1]);
                    break;
                case "push_back":
                    deque.offerLast(comm[1]);
                    break;
                case "pop_front":
                    String firstElement = deque.pollFirst();
                    if(firstElement==null) {
                        bw.write("-1");
                    }
                    else {
                        bw.write(firstElement);
                    }
                    bw.newLine();
                    break;
                case "pop_back":
                    String lastElement =  deque.pollLast();
                    if(lastElement==null) {
                        bw.write("-1");
                    }
                    else{
                        bw.write(lastElement);
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    boolean isEmpty = deque.isEmpty();
                    if(isEmpty){
                        bw.write("1");
                    }
                    else{
                        bw.write("0");
                    }
                    bw.newLine();
                    break;
                case "front":
                    String peekFirstElement = deque.peekFirst();
                    if(peekFirstElement==null){
                        bw.write("-1");
                    }
                    else{
                        bw.write(peekFirstElement);
                    }
                    bw.newLine();
                    break;
                case "back":
                    String peekLastElement =  deque.peekLast();
                    if(peekLastElement==null){
                        bw.write("-1");
                    }
                    else{
                        bw.write(peekLastElement);
                    }
                    bw.newLine();
                    break;
            }


        }
        bw.close();

    }

}
