package week4;
import java.util.*;

public class pro_42579 {
    class Solution {
        public ArrayList<Integer> solution(String[] genres, int[] plays) {
            ArrayList<Integer> answer = new ArrayList<>();

            Map<String,Integer> songData = new HashMap<String,Integer>();

            for(int i=0; i<genres.length; i++){
                songData.put(genres[i],songData.getOrDefault(genres[i],0)+plays[i]);
            }

            ArrayList<String> genre = new ArrayList<>();
            for(String key : songData.keySet()) {
                genre.add(key);
            }
            Collections.sort(genre, (o1, o2) -> songData.get(o2) - songData.get(o1)); //key값에 해당하는 value를 내림차순으로 정렬한다.


            for(int i=0; i<genre.size(); i++){
                int maxIdx = 0;
                int secondIdx = 0;
                int maxSong = 0;
                int secondSong =0;
                int songCnt = 0;
                //1번째 거 넣기
                for(int j=0; j<genres.length; j++){
                    if(genres[j].equals(genre.get(i))){
                        songCnt++;
                    }
                    if(genres[j].equals(genre.get(i))&&maxSong<plays[j]){
                        maxSong = plays[j];
                        maxIdx = j;
                    }
                }
                answer.add(maxIdx);

                if(songCnt>1){
                    //2번째 거 넣기
                    for(int j=0; j<genres.length; j++){
                        if(genres[j].equals(genre.get(i))&&secondSong<plays[j]&&j!=maxIdx){
                            secondSong = plays[j];
                            secondIdx = j;
                        }
                    }
                    answer.add(secondIdx);
                }
            }
            return answer;
        }
    }
}
