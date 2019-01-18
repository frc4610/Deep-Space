package org.usfirst.frc.team4610.robot.commands;

import org.usfirst.frc.team4610.robot.Robot;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class tankDrive extends Command {
	
	public tankDrive(){
		requires(Robot.driveBase);
	}
	
	public void initialize(){
		
	}
	
	public void execute() {
		//double throttle = ( 1.0 -Robot.m_oi.LEFT_JOY.getThrottle()) / -2.0;
		
		Robot.driveBase.set(ControlMode.PercentOutput, -Robot.m_oi.LEFT_JOY.getRawAxis(1), -Robot.m_oi.RIGHT_JOY.getRawAxis(1));
	}
	
	
	protected boolean isFinished() {

		return false;
	}
	
	protected void end() {
		
	}
	protected void interupted() {
		end();
	}
}
