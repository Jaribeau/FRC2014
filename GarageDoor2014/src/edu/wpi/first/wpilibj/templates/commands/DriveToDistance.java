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
public class DriveToDistance extends CommandBase 
{
    int distance = 0;
    int percentSpeed = 0;
    int distanceAndDirectionInFeet;
    boolean isFinished;
    
    public DriveToDistance() 
    {
        requires(drivetrain);
        isFinished = true;
    }
    
    public DriveToDistance(int distanceAndDirectionInFeet, int percentSpeedAndDirection) 
    {
        requires(drivetrain);
        this.distanceAndDirectionInFeet = distanceAndDirectionInFeet;
        this.percentSpeed = percentSpeedAndDirection;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        distance = distanceAndDirectionInFeet * RobotMap.TICKS_PER_FOOT;
        drivetrain.resetEncoders();
        drivetrain.resetGyro();
        drivetrain.shiftLow();
        isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        if(Math.abs(drivetrain.leftDriveEncoder.getDistance()) < Math.abs(distance))// && drivetrain.rightDriveEncoder.getDistance() < distance)
        {
            drivetrain.driveStraight(percentSpeed);
            drivetrain.driveStraight(percentSpeed);
            System.out.println("Distance: " + drivetrain.leftDriveEncoder.getDistance());
        }
        else
        {
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
            drivetrain.setDrivePercent(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
            drivetrain.setDrivePercent(0,0);
    }
}
