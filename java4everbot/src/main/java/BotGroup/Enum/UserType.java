package BotGroup.Enum;

public enum  UserType {

    BOT("bot"),
    SPAMER("spamer"),
    NORMAL("normal");

    private String typeName;

    private UserType(String typeName){
        this.typeName = typeName;
    }
}
