package commandstrategy;

public class PlusMinusCommand extends NumericCommand {

	public PlusMinusCommand(Double num) {
		op1 = num;
	}


	@Override
	public void execute() {
		super.result = -op1;
	}


	@Override
	public String getLogString() {
		String log = "(-)" + String.valueOf(op1) + " = " + String.valueOf(result);
		return log;
	}

}
