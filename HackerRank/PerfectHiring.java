package HackerRank;
import java.util.Scanner;

public class PerfectHiring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long p = scan.nextInt();
        long x = scan.nextInt();
        long max = Long.MIN_VALUE;
        int position = 1;
        int maxPos = 1;
        while(position <= n){
            long c = scan.nextInt();
            long score = p*c;
            if(score > max){
                max = score;
                maxPos = position;
            }               
            p = p - x;
            position++;
        }
        System.out.println(maxPos);
        scan.close();        
	}

}
