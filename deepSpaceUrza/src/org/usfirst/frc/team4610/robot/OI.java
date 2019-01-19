/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4610.robot;



import org.usfirst.frc.team4610.robot.commands.Invert;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//mapping of joysticks
	public  Joystick LEFT_JOY = new Joystick(0);
	public  Joystick RIGHT_JOY = new Joystick(1);
	public  Joystick BACKUP_JOY = new Joystick(2);
	public Button buttonR3 = new JoystickButton(RIGHT_JOY, 3);
	public Button buttonR4 = new JoystickButton(RIGHT_JOY, 4);
	//public Button buttonL1 = new JoystickButton(LEFT_JOY, 1);
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public OI(String driver,String operator) {
		//different diver control schemes
		if(driver.equals("Winte"))
		{
		//button1.whenPressed(new LiftBottom()); example
		 buttonR3.whenPressed(new Invert(0));//normal
		 buttonR4.whenPressed(new Invert(1));//inverted
		}
		else if (driver.equals("Nathan"))
		{
		}
		if(operator.equals("Nathan"))
		{
			
		}
		
	}
}
