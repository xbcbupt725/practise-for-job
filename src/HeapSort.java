
public class HeapSort {
	public static void main(String[] args){
		int[] nums = {7,2,8,6,3,1,4,9,5};
		heapSort(nums);
		for(int i : nums){
			System.out.println(i);
		}
	}
	static void maintainHeap(int nums[],int root,int length){
		int max = root;
		int left = getLeft(root);
		int right = getRight(root);

		if(left < length && nums[left] > nums[max]){
			max = left;
		}
		if(right < length && nums[right] > nums[max]){
			max = right;
		}
		if(max !=root){
			int temp = nums[root];
			nums[root] = nums[max];
			nums[max] = temp;
			maintainHeap(nums,max,length);
		}
	}
	
	static void buildMaxHeap(int nums[]){
		for(int i = nums.length-1; i > 0; --i){
			maintainHeap(nums,getParent(i),nums.length);
		}
	}
	
	static void heapSort(int nums[]){
		buildMaxHeap(nums);
		for(int i = nums.length-1; i > 0; --i){
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			maintainHeap(nums,0,i);
		}
	}
	static int getParent(int i){
		return (i-1)/2;
	}
	static int getLeft(int i){
		return i*2+1;
	}
	static int getRight(int i){
		return i*2+2;
	}
}

