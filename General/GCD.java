package General;

public class GCD {

	public static void main(String[] args)
	{
		int num1 = 24546789;
		int num2 = 329876;
		GCD obj = new GCD();
		System.out.println("The GCD is: "+obj.gcd(num1,num2));
	}
	
	public int gcd(int num1, int num2)
	{
		if(num2 == 0) return num1;
		
		return gcd(num2, num1%num2);
	}
}
