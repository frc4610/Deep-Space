package org.usfirst.frc.team4610.robot.commands;

import org.usfirst.frc.team4610.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {

	private double sec;
    public Delay(double Sec) {
    	//stops for Sec seconds
    	requires(Robot.driveBase);
    	this.sec = Sec;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveBase.resetEnc(2);
    	Robot.driveBase.set(ControlMode.PercentOutput, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.autoTimeSec >= sec||Robot.interrupt;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.resetEnc(2);
    	Robot.driveBase.set(ControlMode.PercentOutput, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveBase.resetEnc(2);
    	Robot.driveBase.set(ControlMode.PercentOutput, 0, 0);
    }
}
