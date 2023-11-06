package com.codegym.task.task31.task3110.command;

import com.codegym.task.task31.task3110.ConsoleHelper;
import com.codegym.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    @Override
    public void execute() throws Exception {

    }
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Enter the full path to the archive.");
        String path = ConsoleHelper.readString();
        return new ZipFileManager(Paths.get(path));
    }
}
