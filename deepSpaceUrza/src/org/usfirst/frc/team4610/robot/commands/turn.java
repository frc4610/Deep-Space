package org.usfirst.frc.team4610.robot.commands;

import org.usfirst.frc.team4610.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class turn extends Command {

	private double degrees;
	private double speed;
	
    public turn(double Degrees, double Speed) {
    	//turn Degrees degrees at speed Speed
    	requires(Robot.driveBase);
    	this.degrees = Degrees;
    	this.speed = Speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveBase.resetEnc(2);
    	Robot.gyro.reset();
    	//stop extraneous moving parts
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(degrees > 0)
    	{
    		Robot.driveBase.set(ControlMode.PercentOutput, -speed, speed);
    	}
    	else if(degrees < 0)
    	{
    		Robot.driveBase.set(ControlMode.PercentOutput, speed, -speed);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((degrees - Robot.gyro.getAngle() <= Robot.acceptedTurnTolerance)&&(degrees - Robot.gyro.getAngle() >= -Robot.acceptedTurnTolerance))||Robot.interrupt;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.resetEnc(2);
    	Robot.gyro.reset();
    	Robot.driveBase.set(ControlMode.PercentOutput, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveBase.resetEnc(2);
    	Robot.gyro.reset();
    }
}
