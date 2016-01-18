package ml.math;

public class IncompatibleOperandException extends RuntimeException {

  public IncompatibleOperandException() {
    super();
  }

  public IncompatibleOperandException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public IncompatibleOperandException(String message, Throwable cause) {
    super(message, cause);
  }

  public IncompatibleOperandException(String message) {
    super(message);
  }

  public IncompatibleOperandException(Throwable cause) {
    super(cause);
  }

}