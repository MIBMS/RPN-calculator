//MA314 Ex 7.1 Ilham 
public class calculator {

	public static void main(String[] args) 
	{
		Stack stack = new Stack(args.length);
		String string = "";
		for(int i=0; i<args.length; i++)
		{
			boolean isNotNumber = false;
			String j = args[i];
			string = string + j + " ";
			//going to assume we only have doubles and operators
			//check whether the argument is an operator
			//if not, assume it's a double, then push on the stack
			//else pop the first two elements and operate on them
			if (j.equals(".") ||j.equals("+") ||j.equals("/") ||j.equals("-"))
			{
				isNotNumber = true;
			}			
			if (isNotNumber == false)
			{
				stack.push(Double.parseDouble(j));
				//stack.show();
			}
			else if (j.equals("."))
			{
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand * secondOperand);
				//stack.show();
			}
			else if (j.equals("+"))
			{
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand + secondOperand);
				//stack.show();
			}
			else if (j.equals("-"))
			{
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand - secondOperand);
				//stack.show();
			}	
			else if (j.equals("/"))
			{
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand / secondOperand);
				//stack.show();
			}
				
		}
		//stack.show();
		System.out.println(string + " = " + stack.pop());

	}

}


class Stack {
	private double [] contents;
	private int stackSize;
	private int top;
	public Stack(int stackSize)
	{
		this.stackSize = stackSize ;
		this.contents = new double [stackSize];
		this.top = -1; // -1 means the stack is empty
	}
	
	public void push(double value)
	{	
		if (isFull())
		{
			System.out.println("Stack overflow");
		}
		else
		{
			top++;
			contents[top] = value;
		}		
	}
	
	public double pop()
	{
		if (isEmpty())
		{
			System.out.println("Stack underflow");
			return 0;
		}			
		else
		{
			double value = contents[top];
			top--;
			return value;	
		}
			
	}
	
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
	public boolean isFull()
	{
		return this.top == this.stackSize-1;
	}
	
	public void clear()
	{
		System.out.println("Clearing stack in order... ");
		int ctop = top;
		for (int i=0; i<=ctop; i++)
		{
			double j = pop();
			System.out.print(j + ", ");
		}
		System.out.println();
	}
	
	public void show()
	{
		System.out.print ("Current stack: \n");
		// Gives a snapshot of the stack
		// without changing it.
		for (int i=0; i<=top; i++)
		{
			System.out.print(contents[i] + ", ");
		}
		System.out.println();
	}	
	
}

