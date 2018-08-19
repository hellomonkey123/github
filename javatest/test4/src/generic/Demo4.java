package generic;

public class Demo4 {
	
	public <T> void swap(T arr[],int p1,int p2) {
		
		T tem = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = tem;
	}

	public <T> void revese(T arr[]) {
		
		int start = 0;
		int end = arr.length-1;
		
		while(start<end) {
			T tem = arr[start];
			arr[start] = arr[end];
			arr[end] = tem;
			start++;
			end--;
		}
	}
}
