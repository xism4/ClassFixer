package de.xbrowniecodez.classfixer.processor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.utils.Logger;
import de.xbrowniecodez.classfixer.processor.entry.ZipEntryProcessor;

public class Processor {

    private final ZipEntryProcessor zipEntryProcessor;

    public Processor(String input, ZipEntryProcessor zipEntryProcessor) {
        this.zipEntryProcessor = zipEntryProcessor;
        try {
            process(input);
        } catch (IOException e) {
            Logger.log("Error processing file: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void process(String input) throws Throwable {
        Logger.log("Processing...");

        File file = new File(input);

        try (ZipFile zip = new ZipFile(file);
             ZipOutputStream out = new ZipOutputStream(new FileOutputStream(input.replace(".jar", "") + "-Output.jar"))) {

            processEntries(zip, out);
        }
    }

    private void processEntries(ZipFile zip, ZipOutputStream out) throws Throwable {
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            zipEntryProcessor.process(zip, zipEntry, out);
        }
    }
}
