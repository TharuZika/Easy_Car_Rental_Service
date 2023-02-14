package lk.ijse.easycar.util;

public class ResponseUtil {
    private String state;
    private String message;
    private Object data;

    public void setState(String state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public ResponseUtil(String state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public ResponseUtil() {
    }
}
