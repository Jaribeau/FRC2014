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
public class FlapWings extends CommandBase {
    
    String direction;
    
    
    public FlapWings() 
    {
        requires(wings);
    }
    
    public FlapWings(String direction) 
    {
        requires(wings);
        requires(intake);
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        if(direction.equals("OPEN"))
        {
            wings.openWings();
            intake.extend();
        }
        else if(direction.equals("CLOSE"))
        {
            wings.closeWings();
            intake.retract();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
