package CTC.ArrayStrings;

import java.lang.StringBuffer;

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompress test = new StringCompress();
		System.out.println(test.compress("aabbcccaaabbccssa"));
	}
	
	public String compress(String inp){
		if(inp == null) return "";
		if(compressCount(inp) >= inp.length()) return inp;
		StringBuffer result = new StringBuffer();
		char last = inp.charAt(0);
		int count = 1;
		result.append(last);
		for(int i = 1; i < inp.length(); i++){
			char ch =inp.charAt(i);
			if(ch == last) count++;
			else{
				result.append(count);
				result.append(ch);
				last = ch;
				count = 1;
			}
		}
		result.append(count);
		return result.toString();
	}

	public int compressCount(String s){
		int size = 0;
		if(s == null || s.isEmpty()) return size;
		
		int count = 1;
		char last = s.charAt(0);
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == last) count++;
			else{
				last = s.charAt(i);
				size += 1 + (count+"").length();
				count = 1;
			}
		}
		size += 1+(count+"").length();
		return size;
	}
}
