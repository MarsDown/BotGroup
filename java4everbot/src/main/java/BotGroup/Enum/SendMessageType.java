package BotGroup.Enum;

public enum SendMessageType {
    WELCOME_MESSAGE("welcome message"),
    WARNING_MESSAGE("warning message"),
    RESTRICT_MESSAGE("restrict_message");

   private String type;

   private SendMessageType(String type)
   {
       this.type = type;
   }


}
