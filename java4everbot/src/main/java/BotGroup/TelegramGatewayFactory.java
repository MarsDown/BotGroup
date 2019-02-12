package BotGroup;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramGatewayFactory {

    public static TelegramGateway getTelegramGateway(TelegramLongPollingBot bot){

        String mode = "telegram";

        if(mode.equals("mock")){
            return new TelegramGatewayMock();
        }

        return new TelegramGatewayImpl(bot);

    }

}
