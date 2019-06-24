public class PrintRandomValueArray {
	public static void main(String[] args) {
		int num[][] = new int[4][4];
		
		for (int i = 0; i<num.length; i++)
		{
			for(int j = 0; j<num[i].length; j++)
			{
				num[i][j] = (int)(Math.random()*10+1);
			}
		}
		
		for(int i = 0; i<num.length; i++)
		{
			for(int j =0; j<num[i].length; j++)
			{
				System.out.print(num[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
