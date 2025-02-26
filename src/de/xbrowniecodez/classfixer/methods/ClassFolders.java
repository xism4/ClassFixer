package de.xbrowniecodez.classfixer.methods;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.utils.Writer;

public class ClassFolders {

	public void process(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out) throws Throwable {
		if (isClassDirectory(zipEntry)) {
			ZipEntry newEntry = createNewEntry(zipEntry);
			newEntry.setTime(System.currentTimeMillis());

			writeEntryToOutput(zip, zipEntry, out, newEntry);
		}
	}

	private boolean isClassDirectory(ZipEntry zipEntry) {
		return zipEntry.isDirectory() && zipEntry.getName().endsWith(".class/");
	}

	private ZipEntry createNewEntry(ZipEntry zipEntry) {
		String newName = zipEntry.getName().replace(".class/", ".class");
		return new ZipEntry(newName);
	}

	private void writeEntryToOutput(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out, ZipEntry newEntry) throws Throwable {
		out.putNextEntry(newEntry);

		try (InputStream zipInputStream = zip.getInputStream(zipEntry)) {
			Writer.writeToFile(out, zipInputStream);
		}
	}
}
