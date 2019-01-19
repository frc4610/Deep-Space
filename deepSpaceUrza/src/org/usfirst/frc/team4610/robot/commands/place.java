package org.usfirst.frc.team4610.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class place extends Command {

    public place(/*object*/) {
    	//places a hatch or cargo
    	//requires(mechanism);
    	//this.Object = object;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//check to see if safe, stop drive base
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//needed commands to make move
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//sensor place/ mechanism moved || Robot.interrupted;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stop all moving parts save for drive base
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
