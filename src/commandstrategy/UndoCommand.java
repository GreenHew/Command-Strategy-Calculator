package commandstrategy;

public class UndoCommand implements Command {

	@Override
	public void execute() {
	}


	@Override
	public Double getPrevState() {
		return null;
	}


	@Override
	public String getLogString() {
		return "command undone";
	}

}
