package week1;
import java.util.*;
//R 2번이면 똑같으니까 안해도 되나? => 일단 다 짜고 생각

public class boj_5430 {

    static boolean isReversed;
    static int start;
    static int end;
    static boolean isError;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();

        for(int i=0; i<testCnt; i++){
            String[] function = sc.next().split("");
            int arrSize = sc.nextInt();
            int[] arr = new int[arrSize];

            String array = sc.next();

            if(arrSize > 0){
                array = array.substring(1, array.length() - 1);     // [ ]날리기
                String[] elements = array.split(",");
                for(int j = 0; j < arrSize; j++){
                    arr[j] = Integer.parseInt(elements[j]);
                }
            }

            isReversed = false;
            start = 0;
            end = arrSize - 1;
            isError = false;


            for(int j=0; j< function.length; j++){
                if(function[j].equals("R")){
                    Rfunction(arr);
                }
                else if(function[j].equals("D")){
                    Dfunction(arr);
                }

            }
            // 연산 끝
            if(isError){
                System.out.println("error");
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if(!isReversed){        //안 뒤집혔으면 정상 출력
                    for(int j = start; j <= end; j++){
                        sb.append(arr[j]);
                        if(j != end) {
                            sb.append(",");
                        }
                    }
                }
                else {            //뒤집혔으면 뒤에서 부터 출력
                    for(int j = end; j >= start; j--){
                        sb.append(arr[j]);
                        if(j != start) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }

    }

    public static void Rfunction(int[] arr){
        isReversed = !isReversed;

    }

    public static void Dfunction(int[] arr){
        if(start > end){        //지울게 없음
            isError = true;
            return;
        }

        if(!isReversed){        //안뒤집어졌으면 앞에 지우기
            start++;
        } else {            //아니면 뒤 지우기
            end--;
        }
    }



}
