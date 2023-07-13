package namtdph08817.android.demoreadjson.entity;

public class UserModel {
    private String name;
    private String craft;

    public UserModel() {
    }

    public UserModel(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public String getCraft() {
        return craft;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }
}
