package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] arr = fileName.split("\\.");
        if (!arr[arr.length - 1].equals("txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        } else
            this.fileInputStream = new FileInputStream(fileName);

    }

    public static void main(String[] args) {
    }

    @Override
    public int read() throws IOException {
        return fileInputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return fileInputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return fileInputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return fileInputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return fileInputStream.available();
    }

    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }

    @Override
    public FileChannel getChannel() {
        return fileInputStream.getChannel();
    }

//    @Override
//    public void finalize() throws IOException {
//        fileInputStream.finalize();
//    }

    @Override
    public void mark(int readlimit) {
        fileInputStream.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        fileInputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return fileInputStream.markSupported();
    }
}

