package commandstrategy;

import java.util.*;

public class CalculatorModel {

	Double op1 = null;
	Double op2 = null;
	String operator = null;
	boolean isCalculating = false;
	boolean operatorIsSet = false;

	Deque<Command> commandStack = new ArrayDeque<Command>();
	Deque<Command> commandLog = new ArrayDeque<Command>();


	public void setOperand(double val) {
		if (op1 == null)
			op1 = val;
		else {
			op2 = val;
			isCalculating = true;
		}
	}


	public Double setOperator(String op) {
		Double result = null;
		if (operator != null) {
			result = calculate();
		}
		operator = op;
		operatorIsSet = true;
		return result;
	}


	public Double calculate() {
		NumericCommand command = new NumericCommand();
		if (op1 == null || op2 == null || operator == null)
			return null;
		switch (operator) {
		case "+":
			command = new AddCommand(op1, op2);
			break;
		case "-":
			command = new SubtractCommand(op1, op2);
			break;
		case "*":
			command = new MultiplyCommand(op1, op2);
			break;
		case "/":
			command = new DivideCommand(op1, op2);
			break;
		}
		operator = null;
		command.execute();
		commandStack.addFirst(command);
		commandLog.addLast(command);
		op1 = command.result;
		isCalculating = false;
		operatorIsSet = false;
		return op1;
	}


	public Double plusMinus(String op) {
		Double num = Double.valueOf(op);
		NumericCommand command = new PlusMinusCommand(num);
		command.execute();
		commandStack.addFirst(command);
		commandLog.addLast(command);
		if (isCalculating && operatorIsSet)
			op2 = command.result;
		else
			op1 = command.result;
		return command.result;
	}


	public Double undo() {
		if (commandStack.peekFirst() == null)
			return null;
		Command undo = new UndoCommand();
		commandLog.addLast(undo);
		Command lastCommand = commandStack.removeFirst();
		op1 = lastCommand.getPrevState();
		return op1;
	}


	public void clear() {
		op1 = op2 = null;
		operator = null;
	}


	public void saveTextFile() {
		SaveStrategy save = new TextSave();
		save.save(commandLog);
	}


	public void saveXmlFile() {
		SaveStrategy save = new XmlSave();
		save.save(commandLog);
	}

}
