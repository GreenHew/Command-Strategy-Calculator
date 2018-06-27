package commandstrategy;

public class NumericCommand implements Command {

	public Double op1;
	public Double result;


	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}


	@Override
	public Double getPrevState() {
		return op1;
	}


	@Override
	public String getLogString() {
		return null;
	}

}
