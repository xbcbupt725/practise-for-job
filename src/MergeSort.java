public class MergeSort {
	public static void main(String[] args){
		int[] nums = {7,2,8,6,3,1,4,9,5};
		//int nums[] = {1,3,5,7,2,4,6,8};
		//mergeArray(nums, 0, 4, 7, new int[8]);
		MergeSort(nums,0,nums.length-1);
		for(int i : nums){
			System.out.println(i);
		}
	}

	private static void MergeSort(int[] nums,int begin,int end) {
		// TODO Auto-generated method stub
	    if(begin > end){
	    	return;
	    }
	    if(end - begin < 2){
	    	if(nums[begin] > nums[end]){
	    		int temp = nums[begin];
		    	nums[begin] = nums[end];
		    	nums[end] = temp;
	    	}
	    	
	    	return;
	    }
		int middle = begin+(end-begin)/2;
		MergeSort(nums,begin,middle);
		MergeSort(nums,middle+1,end);
		mergeArray(nums, begin, middle+1, end,new int[nums.length]);
	}
	
	static void mergeArray(int[] nums,int aFirst,int bFirst,int bEnd,int c[]){
		int af = aFirst, ae = bFirst-1;
		int bf = bFirst, be = bEnd;
		int inc = 0;
		while(af <= ae && bf <= be){
			if(nums[af] < nums[bf]){
				c[inc++] = nums[af++]; 
			}else{
				c[inc++] = nums[bf++];
			}
		}
		while(af <= ae){
			c[inc++] = nums[af++];
		}
		while(bf <= be){
			c[inc++] = nums[bf++];
		}
		inc = 0;
		af = aFirst;
		be = bEnd;
		while(af <= be){
			nums[af++] = c[inc++];
		}
	}
}