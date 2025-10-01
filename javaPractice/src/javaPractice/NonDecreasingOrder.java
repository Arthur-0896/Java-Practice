package javaPractice;

public class NonDecreasingOrder {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,2,2,3};
		
		int i = 0, j = 1;
		for(; j < arr.length; j++) {
			if(arr[j] != arr[i]) {
				arr[++i] = arr[j];
			}
		}
		
		for(int k = 0; k <= i; k++) {
			System.out.print(arr[k]+ " ");
		}
	}
	
}
