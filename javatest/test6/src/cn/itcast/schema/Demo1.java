package cn.itcast.schema;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*print
 			3   7
 		   2 4 6 8
 	 	  1   5   9
 */
		int num=56;
		int a[][] = new int[num/4+1][num];//向上取整
		int x=num/4;
		int y=0;
		
		boolean flag = false;
		for(int j=1;j<=num;j++) {
			a[x][y]=j;
			y++;
			
			if(flag==false) {
				x--;
			}
			else {
				x++;
			}
			if(x<0) {
				x = x+2;
				flag = true;
			}
			
			if(x>num/4) {
				flag = false;
				x = x-2;
			}
				
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j]==0&j<10) {
					System.out.print(" ");
				}else if(a[i][j]==0&j>=10) {
					System.out.print("  ");
				}else {
				System.out.print(a[i][j]);
				}
			}
		System.out.println();
		}
	}

}
