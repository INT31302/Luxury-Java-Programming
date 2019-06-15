public class statementTest {

	public static void main(String[] args) {
		int sum = 0;
		System.out.println("WhileTest : " + WhileTest(sum));
		
		sum = 0;
		System.out.println("ForTest : " + ForTest(sum));
		
		sum = 0;
		System.out.println("DoWhileTest : " + DoWhileTest(sum));
	}
    public static int WhileTest(int sum)
	{
    	int i = 0;
    	while (i < 100)
    	{
    		sum+=i;
    		i +=2;
    	}
		return sum;
	}
    
    public static int ForTest(int sum)
    {
    	for(int i=0; i<100; i+=2) {sum+=i;}
    	return sum;
    }
    
    public static int DoWhileTest(int sum)
	{
    	int i = 0;
    	do
    	{
    		sum+=i;
    		i +=2;
    	}
    	while (i < 100);
		return sum;
	}
}
