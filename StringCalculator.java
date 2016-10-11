public class StringCalculator {
	public static int negCount;
	public int Add(String numbers) throws NegExc
	{
		negCount = 0;
		//System.out.println(numbers);
		int sum = 0;
		int[] negs = new int[numbers.length()];
		negs[0] = 0;
		int count = 0;
		String[] tokens = new String[numbers.length()];
		
		for(int i=0; i<numbers.length(); i++)
			tokens[0] = "0";
		
		
		if(numbers == "")
			return 0;
		else if(numbers.contains(",") || numbers.contains("\n"))
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
		StringCalculator sc = new StringCalculator();
		String str;
		//str = "";
		//str = "13,2";
		//str = "34";
		//str = "1,2,3,4";
		//str = "23,1,567";
		//str = "1\n2,3";
		//str = "2,-4,3,-5,-6,7,8,-9";
		str = "1001,2,3";
		try{
		System.out.println(sc.Add(str));
		}catch(NegExc err){
			if(err.noArr[0] == 0)
				System.out.println(err.message + " " + err.no);
			else
			{
				System.out.print(err.message + " ");
				for(int i=0; i< negCount-1; i++)
					System.out.print(err.noArr[i] + ", ");
				System.out.println(err.noArr[negCount-1]);
			}
			
		}
	}
}

