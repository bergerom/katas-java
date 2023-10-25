package katas.java.composite.directories;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory implements FileSystemElement {

    protected FileSystemElement parent;
    private File file;
    protected final List<FileSystemElement> elements = new ArrayList<>();

    public Directory() {
    }

    public void setPath(String path) {
        file = new File(path);
        if (!file.exists() || file.list() == null) {
            return;
        }
        List<Directory> subDirectories = Arrays.stream(file.list())
                .map(filePath -> this.file.getPath() + "/" + filePath)
                .map(File::new)
                .filter(File::isDirectory)
                .map(f -> createChildDirectory(f.getName()))
                .toList();
        elements.addAll(subDirectories);

        List<FileAdapter> files = Arrays.stream(file.list())
                .map(filePath -> this.file.getPath() + "/" + filePath)
                .map(File::new)
                .filter(f -> !f.isDirectory())
                .map(f -> createFile(f.getName()))
                .toList();
        elements.addAll(files);
    }


    @Override
    public Long getSize() {
        return elements
                .stream()
                .map(FileSystemElement::getSize)
                .reduce(Long::sum)
                .orElse(0L);
    }

    public Directory createChildDirectory(String name) {
        Directory directory = new Directory();
        directory.setParent(this);
        directory.setPath(file.getPath() + "/" + name);
        return directory;
    }

    private void setParent(Directory directory) {
        this.parent = directory;
    }

    public FileAdapter createFile(String fileName) {
        FileAdapter fileAdapter = new FileAdapter();
        fileAdapter.setParent(this);
        fileAdapter.setPath(file.getPath() + "/" + fileName);
        return fileAdapter;
    }
}
