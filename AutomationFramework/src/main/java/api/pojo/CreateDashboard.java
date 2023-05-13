package api.pojo;

public class CreateDashboard {
    public CreateDashboard(String name, String description, boolean share) {
        this.name = name;
        this.description = description;
        this.share = share;
    }

    private String name;
    private String description;
    private boolean share;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }




}
