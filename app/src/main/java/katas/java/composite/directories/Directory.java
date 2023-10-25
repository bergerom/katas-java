package katas.java.composite.directories;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory implements FileSystemElement {
    private File file;
    protected final List<FileSystemElement> elements = new ArrayList<>();

    public Directory() {

    }

    public Directory(List<FileSystemElement> subDirectories) {
        this.elements.addAll(subDirectories);
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
                .map(f -> createChildDirectory(f.getPath()))
                .toList();
        elements.addAll(subDirectories);

        List<FileAdapter> files = Arrays.stream(file.list())
                .map(filePath -> this.file.getPath() + "/" + filePath)
                .map(File::new)
                .filter(f -> !f.isDirectory())
                .map(f -> createFile(f.getPath()))
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
        directory.setPath(file.getPath() + "/" + name);
        this.elements.add(directory);
        return directory;
    }

    public FileAdapter createFile(String fileName) {
        FileAdapter fileAdapter = new FileAdapter();

        fileAdapter.setPath(file.getPath() + "/" + fileName);
        this.elements.add(fileAdapter);

        return fileAdapter;
    }
}
