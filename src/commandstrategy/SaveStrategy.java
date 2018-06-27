package commandstrategy;

import java.util.*;

public interface SaveStrategy {

	public void save(Deque<Command> data);

}
