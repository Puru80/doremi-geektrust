package com.example.doremi.concrete;

import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;
import com.example.doremi.service.impl.StartSubscriptionCommandExecutor;

public class CommandExecutionFactory {

    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case START_SUBSCRIPTION:
                    executor = new StartSubscriptionCommandExecutor();
                    break;
                /*case CANCEL:
                    executor = new CancelCourseCommandExecutorImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseCommandExecutorImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseCommandExecutorImpl();
                    break;*/
                default:
                    break;
            }
        }

        return executor;
    }
}
