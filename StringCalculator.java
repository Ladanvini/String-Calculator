public class StringCalculator {
	public int negCount;
	public int Add(String numbers) throws NegExc
	{

		negCount = 0;
		//System.out.println(numbers);
		if(numbers == "" || numbers.length() < 1){
			return 0;
		}

		int sum = 0;
		int[] negs = new int[numbers.length()];
		negs[0] = 0;
		int count = 0;
		String[] tokens = new String[numbers.length()];
		
		
		for(int i=0; i<numbers.length(); i++)
			tokens[0] = "0";
		

		if(numbers.contains(",") || numbers.contains("\n"))
			tokens = numbers.split("[\n,]");
		else
		{
			int number = Integer.parseInt(numbers);
			if(number>0 && number<1000)
				return (Integer.parseInt(numbers));
			
			else if(number < 0)
				throw new NegExc("negative number not allowed", number);
			else
				return 0;
		}

		for(int i = 0; i<tokens.length; i++){
			int token = Integer.parseInt(tokens[i]);			
			if(token>0 && token<1000)
				sum += token;
			else if(token < 0){
				negs[count] = token;
				count++;
				negCount++;
			}
			
		}
		if(negs[0] != 0)
			throw new NegExc("negative numbers not allowed", negs);
		return sum;
	}
	public static void main(String[] args){
		UnitTest ut = new UnitTest();
		String testResults = ut.testAdd();
		
		if(ut.checkTest(testResults))
			System.out.println("Test Successful! :)");
		else
			System.out.println("Test Failed :(");
	}
}
