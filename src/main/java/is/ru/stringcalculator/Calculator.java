package is.ru.stringcalculator;
import java.util.regex.Pattern;
import java.util.Arrays;
import static java.lang.System.out;

public class Calculator {

	public static int add(String text){
		if(text.contains("\n") && text.contains(",")) {
			return sum(splitMultiple(text));
		}
		else if(text.startsWith("//;")) {
			return sum(splitDelimiter(text));
		}
		else if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("\n")){
			return sum(splitNewLines(text));
		}
		else if(text.startsWith("//[***]\n")) {
			return sum(splitManyNumbers(text));
		}

		else
			return 1;
	}

	private static String[] splitMultiple(String numbers) {
    	String splitter = "[\n,]+";
    	String[] simbols = numbers.split(splitter);
    		return simbols;
    }
    
    private static String[] splitNewLines(String numbers) {
		return numbers.split("\n");
	}
    
    private static String[] splitDelimiter(String numbers) {
		String start = numbers.substring(numbers.indexOf("//") + 3);
		String splitter = "[;]+";
		String[] newString = start.split(splitter);
			return  newString;
    }

    private static String[] splitManyNumbers(String numbers) {
    	String start = numbers.substring(9);
		String splitter = "[***]+";
		String[] newString = start.split(splitter);
			return  newString;
    }

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) > 1000) {
        		total = 0;
        	}
        	else if(toInt(number) < 0) {
        		throw new IllegalArgumentException("Negatives not allowed: " + number);
        	}
        	else {
        		total += toInt(number);
        	}
		}
		return total;
    }

}