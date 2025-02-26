package de.xbrowniecodez.classfixer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipOutputStream;

public class Writer {
    public static void writeToFile(ZipOutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] buffer = new byte[4096];
        try (inputStream) {
            int data;
            while ((data = inputStream.read(buffer)) != -1) { // reead until stream finish
                outputStream.write(buffer, 0, data);
            }
        } finally {
            outputStream.closeEntry();
        }
    }
}
