public enum ErrorMessages {
    NO_IN_STORAGE_ERROR("Резюме нет в хранилище."),
    NO_FREE_SPACE_ERROR("В хранилище нет свободного места."),
    ALREADY_EXIST_NAME_ERROR("Такое резюме уже есть в хранилище.");

    String errorMsg;
    int code;

    ErrorMessages(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
