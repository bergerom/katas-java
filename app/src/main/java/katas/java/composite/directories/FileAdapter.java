package katas.java.composite.directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileAdapter implements FileSystemElement{
    private Long size;
    private File file;

    public FileAdapter() {

    }

    public Long getSize() {
        return size;
    }

    public void setPath(String path) {
        this.file = new File(path);
        try {
            size = Files.size(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
