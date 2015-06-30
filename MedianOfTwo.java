
public class MedianOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7,9,11,13,15};
		int[] b = {2,4,6,8,10,12,14};
		System.out.println(median(a,0,a.length-1,b,0,b.length-1));
	}

	static double median(int a[], int first, int last)
	{
		if (first > last)
			return 0;
		int mid = (first + last) / 2;
		if ((first + last) % 2 == 0)
			return a[mid];
		else
			return (double) (a[mid] + a[mid+1]) / 2;
	}

	static double median(int a, int b, int c)
	{
		if (a > b)
		{ int t = a; a = b; b = t; }

		return (c < a) ? a : ( (c < b) ? c : b ); 
	}

	static double median(int a, int b, int c, int d)
	{
		if (a > b)
		{ int t = a; a = b; b = t; }

		if (c < a)
		{ int t = c; c = a; a = t; }
		else if (c > b)
		{ int t = c; c = b; b = t; }

		if (d < a)
		{ int t = d; d = a; a = t; }
		else if (d > b)
		{ int t = d; d = b; b = t; }

		return (c + d) / 2.0;
	}

	static double median(int a[], int ai, int aj, int b[], int bi, int bj)
	{
		System.out.println(ai + ", " + aj + "      " + bi + ", " + bj );

		// make a.length <= b.length
		if (aj - ai > bj - bi)
			return median(b, bi, bj, a, ai, aj);

		if (aj - ai < 0)
			return median(b, bi, bj);

		if (ai == aj)
		{
			if (bi == bj)
				return (a[ai] + b[bi]) / 2.0;
			int bm = (bi + bj) / 2;
			if ((bj - bi) % 2 == 1)
				return median(a[ai], b[bm], b[bm + 1]);
			else
				return median(a[ai], b[bm - 1], b[bm], b[bm + 1]);
		}
		if (ai + 1 == aj)
		{
			int bm = (bi + bj) / 2;
			if (bj == bi + 1)
				return median(a[ai], a[aj], b[bi], b[bj]);
			if ((bj - bi) % 2 == 0)
				return median(b[bm], Math.min(a[ai], b[bm+1]), Math.max(a[aj], b[bm-1]));
			else
				return median(b[bm], b[bm+1], Math.min(a[ai], b[bm+2]), Math.max(a[aj], b[bm-1]));
		}


		int am = (ai + aj) / 2;
		int bm = (bi + bj) / 2;

		if (a[am] == b[bm])
			return a[am];

		int cut = am - ai;

		if (a[am] > b[bm])
			return median(a, ai, aj-cut, b, bi+cut, bj);

		return median(a, ai+cut, aj, b, bi, bj-cut);
	}

}
