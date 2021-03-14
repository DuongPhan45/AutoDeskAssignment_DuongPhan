
public class ValidMountainArray {
	/*
	 * Function return true if and only if the given array is a valid mountain array
	 * Time complexity: O(n); Space complexity: O(1)
	 */

	public static boolean validMountainArray(int[] arr) {
		int current = 0; // pointer to the current element

		// check the all-increasing subarray
		while (current < arr.length - 1 && arr[current + 1] > arr[current])
			current++;

// 		current would be the peak value after the increasing part if is a mountain array 
//		if max is the first/last element, then fail
		if (current == 0 || current == arr.length - 1)
			return false;

		// check for strictly decreasing sub-array
		while (current < arr.length - 1 && arr[current + 1] < arr[current])
			current++;

		if (current < arr.length - 1)
			return false;// not a strictly decreasing sub-array
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = { 1, 2, 3, 4, 5, 4, 3 };
		int[] test2 = { 1, 2, 3, 3, 5, 4, 3 };
		int[] test3 = { 1, 2, 3, 4, 5, 3, 3 };
		int[] test4 = { 1, 2, 3, 4, 5 };
		System.out.println(validMountainArray(test1));
		System.out.println(validMountainArray(test2));
		System.out.println(validMountainArray(test3));
		System.out.println(validMountainArray(test4));
	}

}
