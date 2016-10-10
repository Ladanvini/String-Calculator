
public class StringCalculator {

	public int Add(String numbers)
	{
		//System.out.println(numbers);
		int sum = 0;
		String[] tokens = new String[numbers.length()];
		for(int i=0; i<numbers.length(); i++)
			tokens[0] = "0";
		if(numbers == "")
			return 0;
		else if(numbers.contains(","))
			tokens = numbers.split(",");
		else
			return Integer.parseInt(numbers);

		for(int i = 0; i<tokens.length; i++){
			sum += Integer.parseInt(tokens[i]);
			//System.out.println(sum);
			
		}
		return sum;
	}
	public static void main(String[] args){
		StringCalculator sc = new StringCalculator();
		String str;
		str = "";
		//str = "13,2";
		//str = "34";
		//str = "1,2,3,4";
		//str = "23,1,567";
		System.out.println(sc.Add(str));
	}
}
