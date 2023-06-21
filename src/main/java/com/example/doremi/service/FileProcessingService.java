package com.example.doremi.service;

import com.example.doremi.enums.CommandOperator;
import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;

import java.io.*;

public class FileProcessingService {
    private final File file;
    private final BufferedReader reader;

    public FileProcessingService(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        reader = new BufferedReader(new FileReader(file));
    }

    public Command processLine() throws InvalidInputException, IOException {
        String inputString = reader.readLine();
        if(inputString == null){
            return null;
        }
        if(isEmpty(inputString)){
            processLine();
        }
        try{
            return CommandService.getInstance().getCommandFromString(inputString);
        }catch(InvalidInputException e){
            System.out.println(e.getMessage());
            return processLine();
        }
    }

    private boolean isEmpty(String line) {
        return line==null || line.length()==0 || line.trim().isEmpty() || line.trim().startsWith("#");
    }
}

