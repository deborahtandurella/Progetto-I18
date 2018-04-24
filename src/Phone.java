public class Phone {
    private String id;
    private Button [] buttons;

    public Phone(String id, Button buttons) {
        this.id = id;
        this.buttons = new  Button[12];
    }

    public String getId() {
        return id;
    }

    public Button[] getButtons() {
        return buttons;
    }
}
