/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class DriveWithJoysticks extends CommandBase {
    
    public DriveWithJoysticks()
    {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
       oi.driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_PORT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        
        /*******************************************/
        /************* DRIVER STICK ****************/
        /*******************************************/
        drivetrain.arcadeDrive(oi.driveStick);
        
//        drivetrain.driverStation.println(DriverStationLCD.Line.kUser1, 1, "LAUNCH ENC: " + launcher.launcherEncoder.getDistance());
        drivetrain.driverStation.println(DriverStationLCD.Line.kUser2, 1, "ENCs: R: " + drivetrain.rightDriveEncoder.getDistance());
        drivetrain.driverStation.println(DriverStationLCD.Line.kUser2, 1, "ENCs: L:  " + drivetrain.leftDriveEncoder.getDistance());
//        drivetrain.driverStation.println(DriverStationLCD.Line.kUser4, 1, "Launch Switch: " + launcher.launcherLimitSwitch.get());
//        drivetrain.driverStation.println(DriverStationLCD.Line.kUser4, 1, "Launch Switch: " + launcher.launcherLimitSwitch.get());
        drivetrain.driverStation.println(DriverStationLCD.Line.kUser3, 1, "Launcher Throttle: " + oi.driveStick.getRawAxis(3)*(-100));
        
        drivetrain.driverStation.updateLCD();
        
//        SmartDashboard.putNumber("Manual Launch Throttle", oi.operatorStick.getRawAxis(3));
        
    }//End of execute
    
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
