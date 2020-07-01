package Calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	static int GETCOUNTER;
	
	public static int Add(String numbers) {
		GETCOUNTER++;
		if(numbers.isEmpty()) {
		return 0;
		}
		else {
			String[] addNum;
			if(numbers.startsWith("//")) {
				addNum=splitUsingCustomDelimeter(numbers);
			}
			else{
				addNum= numbers.split(",|\n");
			}
			int i,sum=0;
			List<String> arrNumNeg= new ArrayList<>();
			for(i=0;i<addNum.length;i++) {
				int num=Integer.parseInt(addNum[i]);
				if(num<0) {
					arrNumNeg.add(addNum[i]);
				}
				else if(num>1000){
					continue;
					
				}
				else {
					sum=sum+num;
				}
			}
			if(arrNumNeg.size()>0) {
				throw new RuntimeException("negatives not allowed: " + arrNumNeg);
			}
			return sum;
		}
		

	}
	
	private static String[] splitUsingCustomDelimeter(String numbers) {
		Matcher del = Pattern.compile("-?\\d+").matcher(numbers);
		int a,j=0;
		List<Integer> addNum = new ArrayList<Integer>();
		for(a=0;a<numbers.length()-1;a++) {
			if(del.find()) {
				 int num= Integer.parseInt(del.group());
				 addNum.add(num);
			}
		}
		String str = "" ;
		 for(j=0;j<addNum.size();j++) {
				int num1=addNum.get(j);
				str=str+num1;
				}
		String strArray[] = str.split("");
		return strArray;
	}
	
	public static int GetCalledCount(){
		return GETCOUNTER;
	}
	
	public static void main(String[] args) {

	}

}
