package de.xbrowniecodez.classfixer.processor.factory;

import de.xbrowniecodez.classfixer.processor.Processor;
import de.xbrowniecodez.classfixer.processor.entry.ZipEntryProcessor;
import de.xbrowniecodez.classfixer.processor.folder.ClassFoldersZipProcessor;

public class ProcessorFactory {
    public static void createProcessor(String input) {
        ZipEntryProcessor processor = new ClassFoldersZipProcessor();
        new Processor(input, processor);
    }
}
