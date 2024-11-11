package ro.praz.img;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

public class Photo implements AutoCloseable {
    private final Path path;
    private FileInputStream fis = null;

    public Path getPath() {
        return path;
    }

    public Photo(String p) throws InvalidPathException, FileNotFoundException {
        path = Paths.get(p).toAbsolutePath();
        if(Files.exists(path)){
            fis = new FileInputStream(path.toFile());
        }
        else throw new InvalidParameterException("Invalid path");
    }

    public byte[] readNextBytes(int len) throws IOException {
        return fis.readNBytes(len);
    }

    @Override
    public void close() throws Exception {
        if(fis != null)
            fis.close();
    }
}
