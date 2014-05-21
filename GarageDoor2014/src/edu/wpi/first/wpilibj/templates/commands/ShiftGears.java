/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jared
 */
public class ShiftGears extends CommandBase 
{
    String gearTo;
    
    public ShiftGears() 
    {
        requires(drivetrain);
    }//End of default constructor
    
    public ShiftGears(String gearTo) 
    {
        requires(drivetrain);
        this.gearTo = gearTo;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if(gearTo.equals("HIGH"))
            drivetrain.shiftHigh();
        else if(gearTo.equals("LOW"))
            drivetrain.shiftLow();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return true;
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
