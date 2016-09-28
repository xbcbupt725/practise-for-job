public class QuickSort {
	public static void main(String[] args){
		int[] nums = {7,2,8,6,3,1,4,9,5};
		QuickSort(nums,0,nums.length-1);
		for(int i : nums){
			System.out.println(i);
		}
	}
	static void QuickSort(int[] nums,int begin,int end){
		if(begin >= end)
			return;
		int low = begin;
		int high = end;
		int key = nums[low];
		while(low < high){
			while(low < high && nums[high] > key){
				high--;
			}
			nums[low] = nums[high];
			while(low < high && nums[low] < key){
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low] = key;
		int middle = low + (high-low)/2;
		QuickSort(nums,begin,middle-1);
		QuickSort(nums,middle+1,end);
	}
}