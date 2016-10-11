import java.util.*;

public class UnitTest {
	public Vector<String> strings; 
	
	public UnitTest(){
		strings = new Vector<String>();
		strings.add("");
		strings.add("13,2");
		strings.add("34");
		strings.add("1,2,3,4");
		strings.add("23,1,567");
		strings.add("1\n2,3");
		strings.add("2,-4");
		strings.add("2,-4,3,-5,-6,7,8,9");
		strings.add("1001,2");
		strings.add("1001,2,3");
		strings.add("1001,2,-3");

	}
	public String testAdd(){
		//System.out.println("in testAdd");
		StringCalculator sc = new StringCalculator();
		String testRes = "$\n";
		for(int i=0; i<strings.size(); i++){
			//System.out.println("in for loop");
			try{
				//System.out.println("in try loop");
				//System.out.println(strings.elementAt(i));
				testRes.concat(String.valueOf(sc.Add(strings.elementAt(i))));
				//System.out.println(sc.Add(strings.elementAt(i)));
			}catch(NegExc err){
				if(err.noArr[0] == 0){
					//System.out.println(err.message + " " + err.no);
					testRes.concat(err.message + " " + err.no);
				}
				else
				{
					//System.out.print(err.message + " ");
					testRes.concat(err.message + " ");
					for(int j=0; j< sc.negCount-1; j++){
						//System.out.print(err.noArr[j] + ", ");
						testRes.concat(err.noArr[j] + ", ");
					}
//					System.out.println(err.noArr[sc.negCount-1]);
					testRes.concat(String.valueOf(err.noArr[sc.negCount - 1]));
				}
				
			}
		}
		return testRes;
	}

	public Boolean checkTest(String testStr)
	{
		String correctString = "$\n";
		correctString.concat("0\n");
		correctString.concat("15\n");
		correctString.concat("34\n");
		correctString.concat("10\n");
		correctString.concat("591\n");
		correctString.concat("6\n");
		correctString.concat("negative numbers not allowed -4\n");
		correctString.concat("negative numbers not allowed -4, -5, -6\n");
		correctString.concat("2\n");
		correctString.concat("5\n");
		correctString.concat("negative numbers not allowed -3\n");

		if(testStr.equals(correctString))
			return true;

		return false;
				
	}

}