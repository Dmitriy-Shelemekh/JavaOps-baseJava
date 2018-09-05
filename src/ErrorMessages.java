public enum ErrorMessages {
    NO_IN_STORAGE_ERROR("Такого резюме нет в хранилище."),
    NO_FREE_SPACE_ERROR("В хранилище резюме больше нет свободного места."),
    ALREADY_EXIST_NAME_ERROR("Резюме с таким названием уже есть в хранилище.");

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
