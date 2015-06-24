package CTC.ArrayStrings;

public class CheckReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckReverse test = new CheckReverse();
		
		System.out.println(test.checkReverse("mim", "mim"));
	}
	
	public boolean checkReverse(String s,String t){
		boolean result = true;
		
		if(s == null || t == null) return false;
		if(s.length() != t.length()) return false;
		if(s.equals(t)) return true;
		
		int len = s.length();
		for(int i = 0; i < len/2; i++){
			if(s.charAt(i) != t.charAt(len-1-i)) return false;
		}
		
		return result;
	}

}
