package com.example.doremi;

import com.example.doremi.concrete.Controller;
import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;
import com.example.doremi.service.FileProcessingService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DoremiApplication {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                Controller controller = new Controller("DoReMi");
                FileProcessingService fileProcessingService = new FileProcessingService(args[0]);
                try {
                    try {
                        Command command = fileProcessingService.processLine();
                        while (command != null) {
                            controller.fulfillCommand(command);
                            command = fileProcessingService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
