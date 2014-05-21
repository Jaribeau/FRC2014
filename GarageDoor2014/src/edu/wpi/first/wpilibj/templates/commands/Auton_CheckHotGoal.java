/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.templates.subsystems.VisionSystem;

/**
 *
 * @author Jared
 */
public class Auton_CheckHotGoal extends CommandBase {
    
//    VisionSystem vision;
    boolean isHot;
    
    public Auton_CheckHotGoal() 
    {
        System.out.println("RIGHT HERE BABY");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        vision = new VisionSystem();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
//        vision.robotInit();
//        vision.autonomous();    //Checks hot goal
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
