package commandstrategy;

import java.io.*;
import java.util.*;

public class TextSave implements SaveStrategy {

	@Override
	public void save(Deque<Command> data) {
		File file = new File("textCommands.txt");
		Iterator<Command> iterator = data.iterator();
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			while (iterator.hasNext()) {
				writer.write(iterator.next().getLogString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
