package week4;
import java.util.*;

public class pro_42577 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            HashSet<String> phoneBook = new HashSet();

            for(int i=0; i<phone_book.length; i++){
                phoneBook.add(phone_book[i]);
            }

            for(int i=0; i<phone_book.length; i++){
                //// 자기 자신과 비교하지 않기 위해, 전체 길이까지 자르지 않고 길이-1까지만 잘라야 함
                for(int j=1; j<phone_book[i].length(); j++){
                    if(phoneBook.contains(phone_book[i].substring(0,j))){

                        return false;
                    }
                }
            }


            return answer;
        }
    }
}

