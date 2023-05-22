package pojo;

public class UpdateRQ {
    private String name;
    private String description;
    private boolean share;
    private UpdateWidgets[] updateWidgets;

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

    public UpdateWidgets[] getUpdateWidgets() {
        return updateWidgets;
    }

    public void setUpdateWidgets(UpdateWidgets[] updateWidgets) {
        this.updateWidgets = updateWidgets;
    }


}
