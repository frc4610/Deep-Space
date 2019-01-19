package org.usfirst.frc.team4610.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneum extends Subsystem {

	@SuppressWarnings("unused")
	private Compressor compressor;
	private DoubleSolenoid driveDs12;
	
	public Pneum() {
		//sets up pnuematics
		this.compressor = new Compressor();
		this.driveDs12 = new DoubleSolenoid(1,2);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void forward()
	{
		driveDs12.set(DoubleSolenoid.Value.kForward);
	}
	public void reverse()
	{
		driveDs12.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

