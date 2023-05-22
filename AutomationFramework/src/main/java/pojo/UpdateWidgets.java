package pojo;


public class UpdateWidgets {
    private boolean share ;
    private int widgetId;
    private String widgetName;
    private WidgetOptions widgetOptions;
    private WidgetPosition widgetPosition;
    private WidgetSize widgetSize;
    private String widgetType;

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public int getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(int widgetId) {
        this.widgetId = widgetId;
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public WidgetOptions getWidgetOptions() {
        return widgetOptions;
    }

    public void setWidgetOptions(WidgetOptions widgetOptions) {
        this.widgetOptions = widgetOptions;
    }

    public WidgetPosition getWidgetPosition() {
        return widgetPosition;
    }

    public void setWidgetPosition(WidgetPosition widgetPosition) {
        this.widgetPosition = widgetPosition;
    }

    public WidgetSize getWidgetSize() {
        return widgetSize;
    }

    public void setWidgetSize(WidgetSize widgetSize) {
        this.widgetSize = widgetSize;
    }

    public String getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }


}
