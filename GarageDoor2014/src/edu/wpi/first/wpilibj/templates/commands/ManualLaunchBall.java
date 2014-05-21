/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class ManualLaunchBall extends CommandBase {
    
    
    boolean isLaunchComplete;   //Checks if the launcher should be launching or retracting
    double launchPower;
    double launchTime;
    boolean isRetracted;
    double endTime;
    String launchType;
    
    
    public ManualLaunchBall(String launchType) 
    {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if(oi.driveStick.getRawAxis(3) <= 0)
            launchPower = RobotMap.RETRACT_POWER;
        else
            launchPower = oi.driveStick.getRawAxis(3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        launcher.setSpeed(launchPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        launcher.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        launcher.setSpeed(0.0);
    }
}