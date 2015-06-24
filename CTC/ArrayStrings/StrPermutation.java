package CTC.ArrayStrings;

public class StrPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrPermutation test = new StrPermutation();
		String s = "sherlocc";
		String t = "sherlcok";
		System.out.println(test.usingPrime(s, t));
		System.out.println(test.countCharacter(s, t));
	}
	
	public boolean usingPrime(String s, String t){
		boolean result = true;
		
		if(s.length() != t.length()) return false;
//		if("".eq)
		
		int[] primes = {3,5,7,11,13,
				17,19,23,29,31,
				37,41, 43, 47, 53,
				101,59,61,67,103,
				71,73,79,83,89,97};
		int prodS = 1;
		for(int ch : s.toCharArray())
			prodS = prodS * primes[ch-97];
		
		int prodT = 1;
		for(int ch : t.toCharArray())
			prodT = prodT * primes[ch-97];
		
		if(prodT != prodS) return false;
		return result;
	}
	
	public boolean countCharacter(String s, String t){
		boolean result = true;
		if(s.length() != t.length()) return false;
		int[] count = new int[26];
		
		for(int ch : s.toCharArray())
			count[ch-97]++;
		
		for(int ch : t.toCharArray()){
			count[ch-97]--;
			if(count[ch-97] < 0) return false;					
		}
		return result;
	}

}
