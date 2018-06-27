package commandstrategy;

public interface Command {

	public void execute();


	public Double getPrevState();


	public String getLogString();

}
