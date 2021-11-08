package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	private final double batteryLeft;
    private final double batteryRequired;

    /**
     * Construct new instance of the exception.
     * 
     * @param batteryLeft
     *            battery level left in the robot
     * @param batteryRequired
     *            battery level required to do the action
     */
    public NotEnoughBatteryException(final double batteryLeft, final double batteryRequired) {
        super();
        this.batteryLeft = batteryLeft;
        this.batteryRequired = batteryRequired;
    }

}
