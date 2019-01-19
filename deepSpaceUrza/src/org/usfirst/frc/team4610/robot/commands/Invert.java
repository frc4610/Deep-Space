package org.usfirst.frc.team4610.robot.commands;

import org.usfirst.frc.team4610.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Invert extends Command {

	public int set;
    public Invert(int Set) {
    	//invert the front/back of the robot
    	this.set = Set;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.front = set;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(this.set ==0)
    	{
    		return !Robot.m_oi.buttonR3.get();
    	}
    	else
    	{
    		return !Robot.m_oi.buttonR4.get();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
