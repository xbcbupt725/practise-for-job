
public class StringSentenceTest {
	public static void main(String[] args){
		System.out.println(reverseSentence("I come from China."));
	}
	
	private static void reverseString(char[] arrayStr,int begin,int end){
		while(begin < end){
			char temp = arrayStr[begin];
			arrayStr[begin] = arrayStr[end];
			arrayStr[end] = temp;
			++begin;
			--end;
		}
	}
	
	private static String reverseSentence(String s){
		char[] as = s.toCharArray();
		int begin = 0;
		int end = 0;
		reverseString(as,0,as.length-1);
		while(begin < s.length()){
			if(as[begin] == ' '){
				begin++;
				end++;
				
			}else if( end == as.length || as[end] == ' '){
				reverseString(as,begin,end-1);
				begin = end;
			}else{
				end++;
			}
			
		}
		return String.valueOf(as);
	}
	
}
