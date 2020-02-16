//  Author:   Catalina Lamboglia
//  Date  :   09/13/2019
//  Homework assignment : 1
//  Objective : Convert infix strings to postfix
//****************************************************************

import java.util.Stack;

public class InfixToPostfix
{
    public static void main(String args[])
    {
        String firstInfix = "a*b/(c-d)";
        String secondInfix = "(a-b*c)/(d*e*f+g)";
        String thirdInfix = "a/b*(c+(d-e))";
        String firstPostfix = convertToPostfix(firstInfix);
        String secondPostfix = convertToPostfix(secondInfix);
        String thirdPostfix = convertToPostfix(thirdInfix);
        System.out.println(firstPostfix);
        System.out.println(secondPostfix);
        System.out.println(thirdPostfix);
    }
    
    public static String convertToPostfix(String infix)
    {
        Stack<Character> operatorStack = new Stack<>();
        String postfix = new String();
        Character nextCharacter;
        Character topOperator;
        
        for(int i = 0; i < infix.length(); i++)
        {
            nextCharacter = infix.charAt(i); // Empty characters taken care of
            switch(nextCharacter)
            {
                // This could be way cleaner but brute force for now
                case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':
                case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':
                case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':
                case 'y':case 'z':case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':
                case 'G':case 'H':case 'I':case 'J':case 'K':case 'L':case 'M':case 'N':
                case 'O':case 'P':case 'Q':case 'R':case 'S':case 'T':case 'U':case 'V':
                case 'W':case 'X':case 'Y':case 'Z':case ' ':
                    postfix = postfix + nextCharacter;
                    break;
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while (!operatorStack.isEmpty() && 
                         (precedenceOfOperator(nextCharacter)<=precedenceOfOperator(operatorStack.peek())))
                    {
                        postfix = postfix + operatorStack.peek();
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                 case '(':
                     operatorStack.push(nextCharacter);
                     break;
                 case ')':
                     topOperator = operatorStack.pop();
                     while (!topOperator.equals('('))
                     {
                         postfix = postfix + topOperator;
                         topOperator = operatorStack.pop();
                     }
                     break;
                 default: break;
            }
        }
        while (!operatorStack.isEmpty())
        {
            topOperator = operatorStack.pop();
            postfix = postfix + topOperator;
        }
        return postfix;
        
    }
    
    public static int precedenceOfOperator(Character operator)
    {
        int valueOfOperator = 0;
        if (operator.equals('-') || operator.equals('+'))
            valueOfOperator = 1;
        if (operator.equals('*') || operator.equals('/'))
            valueOfOperator = 2;
        return valueOfOperator;
    }
}