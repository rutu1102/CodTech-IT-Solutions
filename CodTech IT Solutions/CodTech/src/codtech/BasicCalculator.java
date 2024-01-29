package codtech;
import java.util.Scanner;

public class BasicCalculator
{
	public static void main(String[] args) 
	{

	    Double number1, number2, result;
	    char operator;
	 
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter first number :");
	    number1 = input.nextDouble();

	    System.out.println("Enter second number :");
	    number2 = input.nextDouble();

	    System.out.println("Enter +:Addition , -:Subtraction , *:Multiplication , /:Division");
	    operator = input.next().charAt(0);
	    
	    
	    switch (operator) {

	      // performs addition between numbers
	      case '+':
	        result = number1 + number2;
	        System.out.println(number1 + " + " + number2 + " = " + result);
	        break;

	      // performs subtraction between numbers
	      case '-':
	        result = number1 - number2;
	        System.out.println(number1 + " - " + number2 + " = " + result);
	        break;

	      // performs multiplication between numbers
	      case '*':
	        result = number1 * number2;
	        System.out.println(number1 + " * " + number2 + " = " + result);
	        break;

	      // performs division between numbers
	      case '/':
	        result = number1 / number2;
	        System.out.println(number1 + " / " + number2 + " = " + result);
	        break;

	      default:
	        System.out.println("Invalid operator!");
	        break;
	    }

	    input.close();
	  }
	}

