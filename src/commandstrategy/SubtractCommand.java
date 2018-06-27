package commandstrategy;

public class SubtractCommand extends NumericCommand {

	public Double op2;


	public SubtractCommand(Double num1, Double num2) {
		op1 = num1;
		op2 = num2;
	}


	@Override
	public void execute() {
		result = op1 - op2;
	}


	@Override
	public String getLogString() {
		String log = String.valueOf(op1) + " - " + String.valueOf(op2) + " = " + String.valueOf(result);
		return log;
	}
}
