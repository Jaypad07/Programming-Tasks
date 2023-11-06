package com.codegym.task.task31.task3110;

import com.codegym.task.task31.task3110.exception.NoSuchZipFileException;
import java.io.IOException;


public class Archiver {

    public static void main(String[] args) throws Exception {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            }catch (NoSuchZipFileException e) {
                ConsoleHelper.writeMessage("You didn't select an archive or you selected an invalid file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error occurred. Please check the entered data.");
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Select an operation:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - Zip files into an archive");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - Add a file to an archive");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - Remove a file from an archive");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - Extract an archive");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - View the contents of an archive");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - Exit");

        int userSelection = ConsoleHelper.readInt();
        switch (userSelection) {
            case 0:
                return Operation.CREATE;
            case 1:
                return Operation.ADD;
            case 2:
                return Operation.REMOVE;
            case 3:
                return Operation.EXTRACT;
            case 4:
                return Operation.CONTENT;
            case 5:
                return Operation.EXIT;
            default:
                return null;
        }
    }
}
