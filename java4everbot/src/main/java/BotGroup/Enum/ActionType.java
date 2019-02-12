package BotGroup.Enum;

public enum ActionType{

    JOIN("join to group"),
    LEFT("left from group"),
    SEND_TEXT_MESSAGE("send text message"),

    UNKNOWN("unknown");

    private String actionName;

    private ActionType(String actionName)
    {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
