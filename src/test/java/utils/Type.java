package utils;

public enum Type {
    ASSIGNED_ROUTE ("Assigned Route"),
    DIRECT_BOOKING("Direct Booking"),
    TICKET_BOOKING("Ticket Booking")
    ;

    private String value;
    Type(String value) {
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
