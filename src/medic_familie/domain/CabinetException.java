package medic_familie.domain;

public class CabinetException extends RuntimeException {
    private ErrorCode errorCode;

    public CabinetException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getCode() {
        return errorCode;
    }
}
