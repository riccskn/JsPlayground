package com.playground.handler;

import com.playground.message.OutputMessage;
import com.playground.message.enums.OutputStatus;
import net.dv8tion.jda.api.entities.MessageEmbed;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptHandler {

    private ScriptEngine engine;

    public ScriptHandler() {
        ScriptEngineManager factory = new ScriptEngineManager();

        this.engine =  factory.getEngineByName("javascript");

    }

    public MessageEmbed handle(String script) {

        OutputMessage outputMessage = new OutputMessage();


      try {

          outputMessage.setOutputResult(String.valueOf(this.engine.eval(script)));
        outputMessage.setOutputStatus(OutputStatus.Sucess);


      }catch (ScriptException exception) {

          outputMessage.setOutputResult(exception.getMessage());
          outputMessage.setOutputStatus(OutputStatus.Failed);

      }

      return outputMessage.build();

    }



}
