package week4;

import java.io.*;
import java.util.*;

public class boj_9935 {

    //Stack 내용물 뺄때는 for문 쓰지마라 (stack.size는 pop할때마다 줄어드니까 범위로 쓰지마라)
    //처음부터 그냥 while(isEmpty써라)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String boomStr = br.readLine();
        Stack<Character> stack = new Stack<>();


        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));

            if(stack.peek()==boomStr.charAt(boomStr.length()-1)&&stack.size()>=boomStr.length()){
                Stack<Character> tempStack = new Stack<>();
                int check=0;
                for(int j=0; j<boomStr.length(); j++){
                    if(stack.peek()==boomStr.charAt(boomStr.length()-j-1)){
                        tempStack.push(stack.pop());
                        check++;
                    }
                }
                if (check != boomStr.length()) {
                    while(!tempStack.isEmpty()){
                        stack.push(tempStack.pop());
                    }
                }
            }
        }


        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            sb.reverse();
            String answer = sb.toString();
            System.out.println(answer);
        }
    }
}
