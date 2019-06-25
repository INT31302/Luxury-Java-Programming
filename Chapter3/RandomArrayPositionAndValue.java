public class RandomArrayPositionAndValue {
	public static void main(String[] args) {
		int iArray[][] = new int[4][4];
		for(int i = 0; i<10; i++)
		{
			int ran1 = (int)(Math.random()*4);
			int ran2 = (int)(Math.random()*4);
			int ran3 = (int)(Math.random()*10+1);
				if(iArray[ran1][ran2] == 0)
				{
					iArray[ran1][ran2] = ran3;
				}
				else
					i--;
		}
		
		for(int i = 0; i<iArray.length; i++)
		{
			for(int j =0; j<iArray[i].length; j++)
			{
				System.out.print(iArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
