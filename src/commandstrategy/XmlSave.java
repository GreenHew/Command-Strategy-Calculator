package commandstrategy;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class XmlSave implements SaveStrategy {

	@Override
	public void save(Deque<Command> data) {
		Iterator<Command> iterator = data.iterator();
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element root = doc.createElement("commands");
			doc.appendChild(root);

			while (iterator.hasNext()) {
				Command command = iterator.next();
				Element element = doc.createElement(getCommandTag(command));
				root.appendChild(element);
				Element operation = doc.createElement("op");
				operation.appendChild(doc.createTextNode(command.getLogString()));
				element.appendChild(operation);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("xmlCommands.xml"));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public String getCommandTag(Command command) {
		if (command instanceof AddCommand)
			return "AddCommand";
		if (command instanceof SubtractCommand)
			return "SubtractCommand";
		if (command instanceof MultiplyCommand)
			return "MultiplyCommand";
		if (command instanceof DivideCommand)
			return "DivideCommand";
		if (command instanceof UndoCommand)
			return "UndoCommand";
		if (command instanceof PlusMinusCommand)
			return "PlusMinusCommand";
		else
			return null;
	}

}
