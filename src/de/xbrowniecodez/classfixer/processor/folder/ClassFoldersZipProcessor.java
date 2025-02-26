package de.xbrowniecodez.classfixer.processor.folder;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.methods.ClassFolders;
import de.xbrowniecodez.classfixer.processor.entry.ZipEntryProcessor;

public class ClassFoldersZipProcessor implements ZipEntryProcessor {
    @Override
    public void process(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out) throws Throwable {
        ClassFolders classFolder = new ClassFolders();
        classFolder.process(zip, zipEntry, out);
    }
}
