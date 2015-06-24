package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class BeginEnd {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
//        int len = scan.nextInt();
        String inp = scan.next();
        int len = inp.length();
        int scoreSum = 0;
//        HashSet<Character> scoreSet = new HashSet<Character>();
////        for(char ch : scoreSet.to){
        	
//        }
        for(int i = 0; i < len; i++){
        	char ch = inp.charAt(i);
        	for(int j = len-1; j >= i; j--){
        		if(ch == inp.charAt(j)) {
        			System.out.println(ch);
        			scoreSum = scoreSum + 1;
        		}
        	}
        	
//            for(int j = 1; j <= len - i; j++){
//                String sub = inp.substring(i,i+j);
//                
//                if(scoreMap.containsKey(sub))
//                    scoreSum = scoreSum + scoreMap.get(sub);
//                else{
//                    int score = fScore(sub);
//                    scoreMap.put(sub, score);
//                    scoreSum = scoreSum + score;
//                }
//            }
        }
        
        System.out.println(scoreSum);
        scan.close();
    }
//    
//    private static int fScore(String str){
//        int len = str.length();
//        if(str.charAt(0) == str.charAt(len-1)) return 1;
//        return 0;
//    }
}
