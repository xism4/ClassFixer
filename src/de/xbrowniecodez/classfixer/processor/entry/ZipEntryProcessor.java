package de.xbrowniecodez.classfixer.processor.entry;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public interface ZipEntryProcessor {
	void process(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out) throws Throwable;
}
