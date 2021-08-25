package lab06;

public class Sort {
	public static void main(String[] args) {
		int[] arr = {7, 4, 5, 1, 3};
		printArr(arr);
		bubbleSort(arr, arr.length);
		printArr(arr);
	}
	public static void bubbleSort(int arr[], int n) {
		// To do
		
		for(int i = arr.length - 1; i >= 0; i--) {
			for(int j = 1; j <= i; j++) {
				if(arr[j-1] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
	public static void printArr(int arr[]) {
		// To do
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
	}
}
