package Strings;

public class AllSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AllSubstrings test = new AllSubstrings();
		String str = "mimanshu";
		System.out.println(str.substring(0,str.length()));
		ListCombination("abc");
	}
	
	static void ListCombination(String str){
		if(str != null && str.length()!=0)
			RecCombine("",str);
	}
	
	static void RecCombine(String prefix,String rest){
		if(rest.length() == 0)
			System.out.print(prefix + " ");
		else{
			RecCombine(prefix + rest.charAt(0),rest.substring(1));
			RecCombine(prefix,rest.substring(1));
			
		}
	}

}
