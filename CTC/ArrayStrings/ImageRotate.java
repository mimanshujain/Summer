package CTC.ArrayStrings;

public class ImageRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageRotate test = new ImageRotate();
		int[][] image = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for(int i = 0; i < image[0].length; i++){
			for(int j = 0; j < image[0].length; j++){
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
		test.rotate(image);
		System.out.println();
		for(int i = 0; i < image[0].length; i++){
			for(int j = 0; j < image[0].length; j++){
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void rotate(int[][] image){
		int n = image[0].length;
		
		for(int layer = 0; layer < n/2; layer++){
			int first = layer;
			int last = n - layer - 1;
			
			for(int i = first; i < last; i++){
				int top = image[layer][i];
				image[layer][i] = image[last-i][first]; //Left
				image[last-i][first] = image[last][last-i]; //Bottom
				image[last][last-i] = image[i][last]; //Right
				image[i][last] = top;
			}
		}
	}
}
