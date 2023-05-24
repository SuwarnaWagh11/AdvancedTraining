package controllers.constants;

public class ErrorCodeConstants {
    public static final int NOT_FOUND = 404;
    public static final int BAD_REQUEST = 400;

    public static final int CONFLICT = 409;
    public static final int ERROR_CODE_BAD_REQUEST = 4001;
    public static final int DUPLICATE_DASHBOARD_BAD_REQUEST = 4091;
    public static final int ERROR_CODE_NOT_FOUND = 40422;
    public static final String NOT_FOUND_ERROR_MESSAGE = "Dashboard with ID \''{0}\'' not found on project \''automationtestingadvancedprogram\''. Did you use correct Dashboard ID?";
    public static final String BAD_REQUEST_ERROR_MESSAGE_NAME = "Incorrect Request. [Field 'name' should not be null.] ";
    public static final String BAD_REQUEST_ERROR_MESSAGE_DUPLICATE = "Resource \''{0}\'' already exists. You couldn\''t create the duplicate.";
}
