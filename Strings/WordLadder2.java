package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


class WordNode{
    String word;
    int numSteps;
    WordNode pre;
 
    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}
 
//Explanation: Node at the same level, with same next element will add that element in the queue twice.
//It can be noted that the next same element can be observed to be in the both sets at the same time. UnVisited and Visited
public class WordLadder2  {
	
	public static void main(String[] args) {
		WordLadder2 test = new WordLadder2();
		Set<String> wordDict =  new HashSet<String>();		
		test.createDict(wordDict);
		List<List<String>> result = test.findLadders("hit", "cog", wordDict);
		System.out.println(result.size());
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
 
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));
 
        dict.add(end);
 
        int minStep = 0;
 
        HashSet<String> visited = new HashSet<String>();  
        HashSet<String> unvisited = new HashSet<String>();  
        unvisited.addAll(dict);
 
        int preNumSteps = 0;
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;
 
            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }
 
                if(top.numSteps == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
 
            }
 
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }
 
            preNumSteps = currNumSteps;
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        visited.add(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
 
 
        }
 
        return result;
    }
    
    public void createDict(Set<String> wordDict)
	{
		String[] words = 
//			{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba",
//				"to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb",
//				"if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh",
//				"wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
			{"hot","dot","dog","lot","log"};
		//{"a","b","c"};
		//{"miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"};
		for(String word : words){
			wordDict.add(word);
		}
	}
}