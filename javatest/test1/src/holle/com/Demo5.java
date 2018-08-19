package holle.com;



import org.junit.Test;

public class Demo5 {
	@Test
	public void testSum() {
		sum(1,2,3,4,5,6);
	}
	public void sum(int ...nums) {
		int sum = 0;
		for(int i:nums) {
			sum+=i;
		}
		System.out.println(sum);
	}
	public void aa(int x, int ...nums) {
		int sum = 0;
		for(int i:nums) {
			sum+=i;
		}
		sum +=x;
		System.out.println(sum);
	}
	@Test
public void bb() {
	int[] a = {1, 2, 3, 4 ,5};
	aa(4,a);
}
}
