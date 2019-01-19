package org.usfirst.frc.team4610.robot.subsystems;

import org.usfirst.frc.team4610.robot.Robot;
import org.usfirst.frc.team4610.robot.commands.tankDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

	private TalonSRX RightMotor;
	private VictorSPX RightMotorFollow;
	private TalonSRX LeftMotor;
	private VictorSPX LeftMotorFollow;

	
	public DriveBase() {
		//sets up motors and encoders for talons
		this.RightMotor = new TalonSRX(1); 
		this.LeftMotor = new TalonSRX(3);
		this.RightMotorFollow = new VictorSPX(2); 
		this.LeftMotorFollow = new VictorSPX(4);
		Robot.initTalonBrake(LeftMotor);
		Robot.initTalonBrake(RightMotor);
		Robot.initTalonBrake(LeftMotorFollow);
		Robot.initTalonBrake(RightMotorFollow);
		RightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		RightMotor.setSelectedSensorPosition(0, 0 ,10);
		LeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		LeftMotor.setSelectedSensorPosition(0, 0 ,10);
		LeftMotorFollow.follow(LeftMotor);
		RightMotorFollow.follow(RightMotor);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void set(ControlMode mode, double leftvalue, double rightvalue) {
		//sets motors based on inversion
		if(Robot.front == 0)
		{
		LeftMotor.set(mode, leftvalue);
		RightMotor.set(mode, rightvalue);
		}
		else if(Robot.front == 1)
		{
		LeftMotor.set(mode, -rightvalue);
		RightMotor.set(mode, -leftvalue);
		}

	}
	
	public double getEncValue(boolean motor)//if motor is true, find right motor, false gets left. Returns encoder value
	{
		if(motor)
		{
			return RightMotor.getSelectedSensorPosition(0);
		}
		else
		{
			return LeftMotor.getSelectedSensorPosition(0);

		}
	}
	
	public void resetEnc(int motor)//0 is right, 1 is left, 2 is both
	{
		if(motor == 0)
		{
			RightMotor.setSelectedSensorPosition(0, 0 ,10);
		}
		else if(motor == 1)
		{
			LeftMotor.setSelectedSensorPosition(0, 0 ,10);
		}
		else if(motor == 2)
		{
			RightMotor.setSelectedSensorPosition(0, 0 ,10);
			LeftMotor.setSelectedSensorPosition(0, 0 ,10);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new tankDrive());
    }
}

