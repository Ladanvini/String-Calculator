public class NegExc extends Exception
{
	public String message;
	public int no;
	public int[] noArr;
	public NegExc(String msg, int num){
		noArr = new int[1];
		noArr[0] = 0;
		message = msg;
		no = num;
	}
	public NegExc(String msg, int[] num){
		message = msg;
		noArr = new int[num.length];
		for(int i=0; i<num.length; i++)
		{
			noArr[i] = num[i];
		}
	}

}