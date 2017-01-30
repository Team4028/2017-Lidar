package org.usfirst.frc.team4028.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	private final static int HI_TEC_PWM_PORT_NO = 0;
	private final static int ACUTONIX_PWM_PORT_NO = 9;
	
	//  A 1.0 ms pulse commands the controller to fully retract the actuator, 
	// and a 2.0 ms pulse signals it to fully extend.
	Servo _hitec = new Servo(HI_TEC_PWM_PORT_NO);
	
	Servo _actuonix = new Servo(ACUTONIX_PWM_PORT_NO);

	long _startTimeInMSec;
	double _servoCmd;
	double _servoCmdLastCycle;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
        //===================
    	// write jar (build) date & time to the dashboard
        //===================
    	Utilities.WriteBuildInfoToDashboard();
    	
		DriverStation.reportWarning("Linear Actuator Test ", false);
	}

	@Override
	public void autonomousInit() 
	{
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() 
	{


	}

	public void teleopInit() 
	{
		_startTimeInMSec = System.currentTimeMillis();
		_servoCmdLastCycle = -1.0;
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() 
	{
		// get the current timestamp
		long currentTimeInMSec = System.currentTimeMillis();
		
		// calc the delta time
		long elapsedTimeInMSec = currentTimeInMSec - _startTimeInMSec;
		
		// set the cmd based on the elsaped time
		if(elapsedTimeInMSec < 10000)
		{
			_servoCmd = 0.0;
		}
		else if (elapsedTimeInMSec < 15000)
		{
			_servoCmd = 0.1;
		}
		else if (elapsedTimeInMSec < 20000)
		{
			_servoCmd = 0.2;
		}
		else if (elapsedTimeInMSec < 25000)
		{
			_servoCmd = 0.3;
		}
		else if (elapsedTimeInMSec < 30000)
		{
			_servoCmd = 0.4;
		}
		else if (elapsedTimeInMSec < 35000)
		{
			_servoCmd = 0.5;
		}
		else if (elapsedTimeInMSec < 40000)
		{
			_servoCmd = 0.6;
		}
		else if (elapsedTimeInMSec < 45000)
		{
			_servoCmd = 0.7;
		}
		else if (elapsedTimeInMSec < 50000)
		{
			_servoCmd = 0.8;
		}
		else if (elapsedTimeInMSec < 55000)
		{
			_servoCmd = 0.9;
		}
		else if (elapsedTimeInMSec < 60000)
		{
			_servoCmd = 1.0;
		}
		else if (elapsedTimeInMSec < 65000)
		{
			_servoCmd = 0.9;
		}		
		else if (elapsedTimeInMSec < 70000)
		{
			_servoCmd = 0.8;
		}		
		else if (elapsedTimeInMSec < 75000)
		{
			_servoCmd = 0.7;
		}
		else if (elapsedTimeInMSec < 80000)
		{
			_servoCmd = 0.6;
		}
		else if (elapsedTimeInMSec < 85000)
		{
			_servoCmd = 0.5;
		}
		else if (elapsedTimeInMSec < 90000)
		{
			_servoCmd = 0.4;
		}
		else if (elapsedTimeInMSec < 95000)
		{
			_servoCmd = 0.3;
		}
		else if (elapsedTimeInMSec < 100000)
		{
			_servoCmd = 0.2;
		}
		else if (elapsedTimeInMSec < 150000)
		{
			_servoCmd = 0.1;
		}
		else
		{
			_servoCmd = 0.0;
		}
		
		// write a log msg if the cmd chg'd from the last scan cycle
		if(_servoCmdLastCycle != _servoCmd)
		{
			DriverStation.reportWarning("Linear Actuator Test: "  + _servoCmd, false);
		}
		
		// set Servo Positions
		_hitec.set(_servoCmd);
		_actuonix.set(_servoCmd);
		

		_servoCmdLastCycle = _servoCmd;
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

