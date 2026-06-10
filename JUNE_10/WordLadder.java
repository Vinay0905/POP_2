package JUNE_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        if(dict.contains(endWord)==false){
            return 0;
        }
        Queue<String> q= new LinkedList<>();

        q.offer(beginWord);
        dict.remove(beginWord);
        int level=1;
        while(q.isEmpty()==false){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord))return level;


                char[] arr=word.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char og=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String next=new String(arr);
                        if(dict.contains(next)){
                            q.offer(next);
                            dict.remove(next);
                        }

                    }
                    arr[j]=og;
                }

            }
            level++;

        }
        return 0;

    }
    public static void main(String[] args) {
    

    String beginWord = "hit";
    String endWord = "cog";

    List<String> wordList = Arrays.asList(
            "hot", "dot", "dog",
            "lot", "log", "cog"
    );

    System.out.println(
            ladderLength(beginWord, endWord, wordList)
    );
}
}
