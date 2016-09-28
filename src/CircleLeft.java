/**
 * 输出圆圈内剩下的数
 * 
 * @author Xubocheng
 *
 */

class ListNode{
	public ListNode(int val,ListNode next){
		this.val = val;
		this.next = next;
	}
	int val;
	ListNode next;
}
public class CircleLeft {
	public static void main(String[] args){
		System.out.println(left(8,3));
		System.out.println(left2(8,3));
	}
	//参数 n代表总元素的个数，参数m表示每次删除元素的步长
	private static int left(int n,int m){
		ListNode head = null,tail = null;
		for(int i = 1; i <= n; ++i){
			if(tail == null){
				head = new ListNode(i,null);
				tail = head;
			}else{
				tail.next = new ListNode(i,null);
				tail = tail.next;
			}	
		}
		tail.next = head;
		while(head.next != head){
			int count = 1;
			while(count < m - 1 ){
				count++;
				head = head.next;
			}
			head.next = head.next.next;
			head = head.next;
		}
		return head.val;
	}
	
	private static int left2(int n,int m){
		int last = 1;
		for(int i = 2; i <= n; ++ i){
			last = (last + m)% (i);
			if(last == 0){
				last = i;
			}
		}
		return last;
	}
}
