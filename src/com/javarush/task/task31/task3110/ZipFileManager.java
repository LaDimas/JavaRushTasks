package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;
    private Path source;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{

        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile));
        String fileName = source.getFileName().toString();
        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);
        InputStream is = Files.newInputStream(source);
        byte[] buffer = new byte[is.available()];
        if ((is.available() > 0)) {
            int count = is.read(buffer);
            zos.write(buffer, 0, count);
        }
        is.close();
        zos.flush();
        zos.close();

    }
}
