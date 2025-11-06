package es.upm.grise.profundizacion.cruiseControl;

public class SpeedSetAboveSpeedLimitException extends RuntimeException {
    public SpeedSetAboveSpeedLimitException(String message) {
        super(message);
    }
}
