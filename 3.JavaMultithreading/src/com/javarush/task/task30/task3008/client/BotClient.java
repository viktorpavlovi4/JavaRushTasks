package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by XE on 21.07.2017.
 */
public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }
    @Override
    protected String getUserName() {
        return String.format("date_bot_%s",(int)(Math.random()*100));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText = message.split(": ");
            SimpleDateFormat sdf = null;

            if (nameAndText.length >= 2)
                switch (nameAndText[1]) {
                    case "дата" : {
                        sdf = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    }
                    case "день" : {
                        sdf = new SimpleDateFormat("d");
                        break;
                    }
                    case "месяц" : {
                        sdf = new SimpleDateFormat("MMMM");
                        break;
                    }
                    case "год" : {
                        sdf = new SimpleDateFormat("YYYY");
                        break;
                    }
                    case "время" : {
                        sdf = new SimpleDateFormat("H:mm:ss");
                        break;
                    }
                    case "час" : {
                        sdf = new SimpleDateFormat("H");
                        break;
                    }
                    case "минуты" : {
                        sdf = new SimpleDateFormat("m");
                        break;
                    }
                    case "секунды" : {
                        sdf = new SimpleDateFormat("s");
                        break;
                    }
                    default: {
                        sdf = null;
                        break;
                    }
                }

            if (sdf != null) {
                sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], sdf.format(Calendar.getInstance().getTime())));
            }
        }
    }
}
