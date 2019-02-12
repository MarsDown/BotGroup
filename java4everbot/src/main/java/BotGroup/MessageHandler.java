package BotGroup;

import BotGroup.Enum.ActionType;
import BotGroup.Enum.SendMessageType;
import BotGroup.Enum.UserType;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MessageHandler {

   private SendMessageService sendMessageService;

   private BlockUserService blockUserService;

   private UserService userService;

   private static MessageHandler messageHandler;

   private MessageHandler(){}

    public static MessageHandler getInstance(TelegramLongPollingBot bot) {

        if (messageHandler == null)
            messageHandler = new MessageHandler();

        messageHandler.init(bot);
        return messageHandler;

    }

    private void init(TelegramLongPollingBot bot){
        sendMessageService = new SendMessageServiceImp(bot);
        blockUserService = new BlockUserServiceImpl(bot);
        userService = new UserServiceImpl(bot);
    }

    public void onUpdatesReceived(List<Update> updates) {

        for (Update update : updates) {
            if (update == null)
                continue;

            if (update.hasMessage())
                messageProcess(update.getMessage());
        }

    }

    private void messageProcess(Message message) {

        try {
            System.out.println(message);
            if (BotUtil.getActionTypeUser(message).equals(ActionType.JOIN)) {
                processJoinedUsers(message);
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }


    private void processJoinedUsers(Message message) throws TelegramApiException {

        List<User> users = message.getNewChatMembers();
        for(User user:users)
        {

            System.out.println(user);
            UserType userType = userService.getUserType(user);

            if(UserType.NORMAL.equals(userType)){
                sendMessage(message,SendMessageType.WELCOME_MESSAGE);
            }
            else if(UserType.BOT.equals(userType)){
                blockUserService.kickUser(message.getChat(),user,null);
                blockUserService.kickUser(message.getChat(),message.getFrom(),null);

            }else if(UserType.SPAMER.equals(userType)){
                blockUserService.restrictUser(message.getChat(),user,null);
                blockUserService.restrictUser(message.getChat(),message.getFrom(),null);

                sendMessage(message,SendMessageType.RESTRICT_MESSAGE);
            }
        }

    }

    private void sendMessage(Message message,SendMessageType sendMessageType) throws TelegramApiException {
        Boolean oneMoreUser = false;
        oneMoreUser= message.getNewChatMembers().size()>1?true:false;
        sendMessageService.sendMessage(sendMessageType,message,oneMoreUser);

    }


}
