package com.codegym.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;
    FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            getFileList().add(rootPath.relativize(path));
        }else if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path cont : stream) {
                    try {
                        collectFileList(cont);
                    } catch (IOException ignore) {

                    }
                }
            }
        }
    }

    public List<Path> getFileList() {
        return fileList;
    }
}
