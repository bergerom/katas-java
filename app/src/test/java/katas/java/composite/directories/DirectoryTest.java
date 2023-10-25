package katas.java.composite.directories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;


import static org.mockito.Mockito.*;

public class DirectoryTest {

    public String loadResourceTestDirectory(String directoryName) {
        String path = "src/test/resources/input/" + directoryName;

        File file = new File(path);
        if (!file.exists()) {
            Assertions.fail();
        }
        return file.getAbsolutePath();
    }

    @Test
    public void myTest() {
        loadResourceTestDirectory("test");
    }

    @Test
    public void inexistantDirectory() {
        Directory directoryMock = Mockito.spy(new Directory());
        directoryMock.setPath("nothing");
        verify(directoryMock, times(0)).createChildDirectory(anyString());
    }

    @Test
    public void createDirectoryWithTwoSubDirectories() {
        Directory directoryMock = Mockito.spy(new Directory());

        String directoryOne = loadResourceTestDirectory("directoryOne");
        directoryMock.setPath(directoryOne);

        verify(directoryMock, times(1)).createChildDirectory("folderOne");
        verify(directoryMock, times(1)).createChildDirectory("folderTwo");
    }

    @Test
    public void createDirectoriesWithOneSubDirectoryAndOneFile() {
        Directory directoryMock = Mockito.spy(new Directory());

        String directoryTwo = loadResourceTestDirectory("directoryTwo");
        directoryMock.setPath(directoryTwo);

        verify(directoryMock, times(1)).createChildDirectory("subfolder");
        // TODO : how to spy the subfolder Directory object?
    }

    @Test
    public void twoBytesFile() {
        Directory directoryMock = Mockito.spy(new Directory());
        String directoryTwo = loadResourceTestDirectory("directoryTwo");
        directoryMock.setPath(directoryTwo);
        Assertions.assertEquals(2, directoryMock.getSize());
    }
}
