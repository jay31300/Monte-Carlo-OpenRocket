package net.sf.openrocket.gimbalextension;

public class PIDController {
	
	private final double Kp, Ki, Kd;
	private double integral = 0;
	private double previousError = 0;
	
	PIDController(double Kp, double Ki, double Kd) {
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
	}
	
	/**
	 * Runs the PID controller
	 * @param error
	 * @param time The time since this was last run
	 * @return
	 */
	public double run(double error, double time) {
		this.integral += error * time;
		double derivative = (error - previousError) * time;
		previousError = error;
		return (Kp * error) + (Ki * this.integral) + (Kd * derivative);
	}
}
