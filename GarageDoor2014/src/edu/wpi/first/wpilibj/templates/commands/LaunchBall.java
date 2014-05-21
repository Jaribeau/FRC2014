/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class LaunchBall extends CommandBase 
{
    boolean isLaunchComplete;   //Checks if the launcher should be launching or retracting
    double launchPower;
    double launchTime;
    double currentTime;
    double endTime;
    boolean isRetracted;
    boolean retractInitialized; //For initializing the retract setting
    private String launchType;
    
    public LaunchBall() 
    {
        requires(launcher);
    }//End of default constructor
    
    public LaunchBall(String launchType) 
    {
        this.launchType = launchType;
        requires(launcher);
        
    }//End of constructor

    // Called just before this Command runs the first time
    protected void initialize()
    {
        //endTime = Timer.getFPGATimestamp() + launchTime;
        isLaunchComplete = false;
        isRetracted = false;
        initializeLaunchType();
        endTime = Timer.getFPGATimestamp() + launchTime;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        currentTime = Timer.getFPGATimestamp();
        
        if(currentTime < endTime)      //Launch
        {
            launcher.setSpeed(launchPower);
            System.out.println("Launching...");
        }
        else if(currentTime >= endTime && currentTime <= (endTime + RobotMap.RETRACT_TIME))    //End of launch
        {
            launcher.setSpeed(RobotMap.RETRACT_POWER);
            System.out.println("Retracting...");
        }
        else
        {
            System.out.println("Retracting Finished!");
            launcher.setSpeed(0.0);
            isRetracted = true;
        }
    }//End of execute

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {       
        if(!isRetracted)  //Ball Launch
            return false;
        else
        {
            System.out.println("SHOT END");
            return true;
        }
    }//End of isFinished()

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
    
    
    
    
    
    void initializeLaunchType()
    {
        if(launchType.equals("LONG"))
        {
            launchPower = RobotMap.LONG_LAUNCH_POWER;
            launchTime = RobotMap.LONG_LAUNCH_TIME;
        }
        else if(launchType.equals("TRUSS"))
        {
            launchPower = RobotMap.TRUSS_LAUNCH_POWER;
            launchTime = RobotMap.TRUSS_LAUNCH_TIME;
        }
        else if(launchType.equals("SAFE"))
        {
            launchPower = RobotMap.SAFE_LAUNCH_SPEED;
//            launchPower = RobotMap.SAFE_LAUNCH_SPEED += voltageCompensation();
            launchTime = RobotMap.SAFE_LAUNCH_TIME;
        }
        
        else if(launchType.equals("PASS"))
        {
            launchPower = RobotMap.SHORT_PASS_POWER;
            launchTime = RobotMap.SHORT_PASS_TIME;
        }
        
    }//End of setLaunchType
}
