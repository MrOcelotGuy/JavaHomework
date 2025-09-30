package chapter20.homework;
import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-27
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #7
 * Description: The program uses a stack to evaluate postfix notation problems
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: Mr Liu you helped me understand how to do this and how to use the stack properly and how postfix notation works
 */



public class PostFixHomework
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your postfix notation equation");
        String equation = in.nextLine();

        Stack<Integer> operandStack = new Stack<>();
        String[] arrayified = equation.split(" ");

        int operand1;
        int operand2;

        for(int i = 0; i < arrayified.length; i++)
        {
            if(arrayified[i].equals("+"))
            {
                operand1 = operandStack.pop();
                operand2 = operandStack.pop();
                operandStack.push(operand2 + operand1);
            }
            else if(arrayified[i].equals("-"))
            {
                operand1 = operandStack.pop();
                operand2 = operandStack.pop();
                operandStack.push(operand2 - operand1);
            }
            else if(arrayified[i].equals("*"))
            {
                operand1 = operandStack.pop();
                operand2 = operandStack.pop();
                operandStack.push(operand2 * operand1);
            }
            else if(arrayified[i].equals("/"))
            {
                operand1 = operandStack.pop();
                operand2 = operandStack.pop();
                operandStack.push(operand2 / operand1);
            }
            else
            {
                operandStack.push(Integer.valueOf(arrayified[i]));
            }

        }
        System.out.println(operandStack);
    }
}
/*
Enter your postfix notation equation
10 5 * 10 200 40 / * + 500 -
[-400]

Process finished with exit code 0
 */