package tstComUtils;

public final class ResponseMap {

    private static int statusCode;
    private static String responseBody;

    public static void setResponseMap(int statusCode, String responseBody) {

        ResponseMap.statusCode = statusCode;
        ResponseMap.responseBody = responseBody;

    }

    public static int getStatusCode() {
        return statusCode;
    }

    public static void setStatusCode(int statusCode) {
        ResponseMap.statusCode = statusCode;
    }

    public static String getResponseBody() {
        return responseBody;
    }

    public static void setResponseBody(String responseBody) {
        ResponseMap.responseBody = responseBody;
    }
}
