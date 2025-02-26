package de.xbrowniecodez.classfixer;

import de.xbrowniecodez.classfixer.processor.factory.ProcessorFactory;
import de.xbrowniecodez.classfixer.utils.Logger;

public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			Logger.log("Please provide the path to the input JAR file.");
			return;
		}

		Logger.log("Starting ClassFixer v1.0 by xBrownieCodez");

		 ProcessorFactory.createProcessor(args[0]);

		Logger.log("Done! Output: " + args[0].replace(".jar", "") + "-Output.jar");
	}
}
