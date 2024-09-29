package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.formatter;

import org.springframework.stereotype.Service;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormFormatterResultOutputPort;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.exception.BusinessRuleException;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.exception.messages.MessageLoader;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.exception.messages.MessagesConstant;

@Service
public class FormFormatterResultAdapter implements IFormFormatterResultOutputPort {

    @Override
    public void returnResponseErrorTeacherRequired(String message) {
        throw new BusinessRuleException(400, 
         MessageLoader.getInstance().getMessage(MessagesConstant.EM013, message));
    }
    
}
    

