package katas.java.composite.directories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DirectoryTest {

    @Test
    public void inexistantDirectory() {
        Directory directoryMock = Mockito.spy(new Directory());
        directoryMock.setPath("nothing");
        verify(directoryMock, times(0)).createChildDirectory(anyString());
    }

    @Test
    public void createDirectoryWithTwoSubDirectories() {
        Directory directoryMock = Mockito.spy(new Directory());
        directoryMock.setPath("/home/matthieu/dev/sandbox/directory");
        verify(directoryMock, times(1)).createChildDirectory("folderOne");
        verify(directoryMock, times(1)).createChildDirectory("folderTwo");
    }

    @Test
    public void createDirectoriesWithOneSubDirectoryAndOneFile() {
        Directory directoryMock = Mockito.spy(new Directory());
        directoryMock.setPath("/home/matthieu/dev/sandbox/directoryTwo");
        verify(directoryMock, times(1)).createChildDirectory("subfolder");
        verify(directoryMock, times(1)).createFile("file.txt");
    }

    @Test
    public void oneByteFile() {
        Directory directoryMock = Mockito.spy(new Directory());
        directoryMock.setPath("/home/matthieu/dev/sandbox/directoryTwo");
        Assertions.assertEquals(1, directoryMock.getSize());
    }
}
