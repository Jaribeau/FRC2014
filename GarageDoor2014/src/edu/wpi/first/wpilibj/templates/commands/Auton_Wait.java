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
public class Auton_Wait extends CommandBase {
    
    double endTime = 0.0;
    double timeInSeconds = 0.0;
        
    public Auton_Wait(double timeInSeconds) 
    {
        this.timeInSeconds = timeInSeconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        endTime = Timer.getFPGATimestamp() + timeInSeconds;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        if(endTime != 0 && Timer.getFPGATimestamp() < endTime)
            return false;
        else
            return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        System.out.println("FINISHED!     Time: " + Timer.getFPGATimestamp());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
