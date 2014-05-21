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
public class MoveIntake extends CommandBase {
    String direction;
    
    public MoveIntake(String direction) 
    {
        requires(intake);
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        //Set solenoid value
        if(direction.equals("EXTEND"))
            intake.extend();
        else if(direction.equals("RETRACT"))
            intake.retract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
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
