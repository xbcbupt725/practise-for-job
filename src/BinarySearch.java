
public class BinarySearch {
	public static void main(String[] args){
		int nums[] = {1,3,5,7,9};
		System.out.println(biSearch(nums,100));
	}
	
	public static int biSearch(int[] nums, int key){
		int begin = 0;
		int end = nums.length-1;
		int middle = 0;
		while(begin <= end){
			middle = begin + (end-begin)/2;
			if(nums[middle] == key){
				return middle;
			}else if(nums[middle] > key){
				end = middle-1;
			}else{
				begin = middle +1;
			}
		}
		return -1;
	}
}
