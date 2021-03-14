
public class LongestMountainArray {
	/*
	 * Function returns the length of the longest mountain subarray, return 0 if
	 * there is no mountain subarray 
	 * Time complexity: O(n); Space complexity: O(1)
	 */

	public static int longestMountain(int[] arr) {
		int max = 0; // longest mountain subarray
		int current = 0; // current index of arr

		while (current < arr.length - 1) {
			// check for increasing subarray
			int init = current; // intial index when start to explore a mountain

			while (current < arr.length - 1 && arr[current + 1] > arr[current])
				current++;

			int peak = current - 1;// index of which may be the peak

			// check for decreasing subarray
			while (current < arr.length - 1 && arr[current + 1] < arr[current])
				current++;

			if (peak != init - 1 && peak != current - 1) {// update max if a valid mountain with greater lenghth than
															// max
				int len = current - init + 1;// length of the mountain discovered
				if (max < len)
					max = len;

			}

			// continue the loop when seeing 2 equal elements
			while (current < arr.length - 1 && arr[current + 1] == arr[current])
				current++;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] test1 = { 1, 1, 1, 1, 1 };
		int[] test2 = { 1, 2, 3, 4 };
		int[] test3 = { 4, 3, 2, 1 };
		int[] test4 = { 1, 2, 1, 2, 3, 2, 4, 1 };
		int[] test5 = { 1, 2, 3, 2, 3, 4, 5, 6, 5, 4 };

		System.out.println(longestMountain(test1));
		System.out.println(longestMountain(test2));
		System.out.println(longestMountain(test3));
		System.out.println(longestMountain(test4));
		System.out.println(longestMountain(test5));
	}
}