/*
 * 打印杨辉三角形
 *  	1    
 * 	   1 1   
 *    1 2 1  
 *   1 3 3 1 
 *  1 4 6 4 1
 * 
 * @xubocheng
 */
public class PrintTriangle {
	public static void main(String[] args){
		print(5);
	}

   
	private static void print(int n) {
		int[][] nums = new int[n][2 * n - 1];
		for (int i = 0; i < nums.length ; ++i) {
			for (int j = 0; j < nums[0].length; ++j) {
				if (i == 0) {
					nums[i][n - 1] = 1;
					break;
				} else {
					int a = 0, b = 0;
					if (j - 1 >= 0) {
						a = nums[i - 1][j - 1];
					}
					if (j + 1 < nums[0].length) {
						b = nums[i - 1][j + 1];
					}
					nums[i][j] = a + b;
				}
			}
		}
		// 0 用来填充空位，打印
		for(int i = 0; i < nums.length; ++i){
			for(int j = 0; j < nums[0].length;++j){
				if(nums[i][j] == 0){
					System.out.print(" ");
				}else{
					System.out.print(nums[i][j]);
				}	
			}
			System.out.println();
		}
	}
}