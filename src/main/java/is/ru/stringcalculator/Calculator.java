package is.ru.stringcalculator;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.contains("\n") && text.contains(",")) {
			return sum(splitMultiple(text));
		}
		else if(text.contains(";")) {
			return sum(splitDelimiter(text));
		}
		else if(text.contains("//")) {
			System.out.println("Sorry tetta ma ekki");
			return -1;
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
		else if(Integer.parseInt(text) < 0) {
			return toInt(negative(text));
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
    	return numbers.split(";");
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
		    total += toInt(number);
		}
		return total;
    }

    private static String negative(String mustBePositive) {
    	if (toInt(mustBePositive) < 0) {
        	throw new IllegalArgumentException("Negatives not allowed:" + mustBePositive);
    	}
    	return mustBePositive;
    }

}