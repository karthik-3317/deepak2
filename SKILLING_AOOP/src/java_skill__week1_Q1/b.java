package java_skill__week1_Q1;

import java.util.Stack;

public class b implements Pattern
{
public Integer postfix(String x)
{
 Stack<Integer> stack=new Stack<>();
 for(int i=0;i<x.length();i++)
 {
 int c=x.charAt(i);
 if(Character.isDigit(c))
 {
 int a=Character.getNumericValue(c);
 stack.push(a);
 }
 else
 {
 int a=stack.pop();
 int b=stack.pop();
 if(c=='+')
 {
 stack.push(a+b);
 }
else if(c=='-')
 {
 stack.push(b-a);
 }
else if(c=='*') 
{
stack.push(a*b);
}
else if(c=='/')
{
stack.push(b/a);
}
}
}
return stack.pop();
}

	
} 
