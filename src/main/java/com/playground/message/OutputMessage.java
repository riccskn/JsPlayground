package com.playground.message;

import com.playground.message.enums.OutputStatus;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class OutputMessage {

    private String outputResult;

    private OutputStatus outputStatus;

    public OutputMessage() {

    }

    public OutputMessage(String outputResult) {
        this.outputResult = outputResult;
    }

    public OutputMessage(String outputResult, OutputStatus outputStatus) {
        this.outputResult = outputResult;
        this.outputStatus = outputStatus;
    }

    public String getOutputResult() {
        return outputResult;
    }

    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }

    public OutputStatus getOutputStatus() {
        return outputStatus;
    }

    public void setOutputStatus(OutputStatus outputStatus) {
        this.outputStatus = outputStatus;
    }

    public MessageEmbed build() {

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("**\uD83E\uDD16 Script output:**");
        embed.setFooter(this.outputResult);

        switch (this.outputStatus) {

            case Sucess:

                embed.setColor(Color.green);

                break;

            case Failed:

                embed.setColor(Color.RED);

                break;

        }

        return embed.build();

    }

}
