package commandstrategy;

public class MultiplyCommand extends NumericCommand {

	public Double op2;


	public MultiplyCommand(Double num1, Double num2) {
		op1 = num1;
		op2 = num2;
	}


	@Override
	public void execute() {
		result = op1 * op2;
	}


	@Override
	public String getLogString() {
		String log = String.valueOf(op1) + " * " + String.valueOf(op2) + " = " + String.valueOf(result);
		return log;
	}

}
