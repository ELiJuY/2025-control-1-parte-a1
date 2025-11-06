package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		
		this.speedometer = speedometer;
        this.speedSet = null;
        this.speedLimit = null;

	}

	public void setSpeedSet(int speedSet) {
		if (speedSet <= 0) {
            throw new IncorrectSpeedSetException("El speedSet no puede ser menor o igual a 0.");
        }

        if (speedLimit != null && speedSet > speedLimit) {
            throw new SpeedSetAboveSpeedLimitException("speedSet no puede ser mayor que speedLimit.");
        }
	}

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

}
