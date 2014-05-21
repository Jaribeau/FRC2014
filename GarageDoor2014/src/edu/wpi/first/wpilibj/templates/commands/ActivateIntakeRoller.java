/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author Jared
 */
public class ActivateIntakeRoller extends CommandBase {
    
    String rollerState;
    double endTime = 0.0;
    
    public ActivateIntakeRoller() 
    {
        requires(roller);
        rollerState = "FORWARD";
    }
    
    public ActivateIntakeRoller(String rollerState, double time) 
    {
        endTime = Timer.getFPGATimestamp() + time;
        this.rollerState = rollerState;
        requires(roller);
    }
    
    public ActivateIntakeRoller(String rollerState) 
    {
        this.rollerState = rollerState;
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if(rollerState.equals("FORWARD"))
            roller.setForward();
        else if(rollerState.equals("REVERSE"))
            roller.setReverse();
        else if(rollerState.equals("OFF"))
            roller.setOff();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        if(endTime != 0 && Timer.getFPGATimestamp() < endTime)
        {
            return false;
        }
        else if(endTime == 0)
        {
            if(oi.driveStick.getRawButton(2) && rollerState.equals("FORWARD"))
                return false;
            else if(oi.driveStick.getRawButton(3) && rollerState.equals("REVERSE"))
                return false;
            else
                return true;
        }
        else
            return true;
    }//End of isFinished

    // Called once after isFinished returns true
    protected void end() 
    {
        roller.setOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
