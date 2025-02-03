package components.utility;


public class PasswordEntry {
    private String name;
    private String password;
    private String category;
    private String login;
    private String website;

    public PasswordEntry(String name, String password, String category, String login, String website) {
        this.name = name;
        this.password = password;
        this.category = category;
        this.login = login;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
