/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jared
 */
public class Auton_Test extends CommandGroup {
    
    public Auton_Test() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        CommandBase.drivetrain.leftDriveEncoder.reset();
        CommandBase.drivetrain.rightDriveEncoder.reset();
        addSequential(new Auton_Wait(2.0));
        System.out.println("Starting drive.");
        addSequential(new DriveToDistance(-5, -50));  // drive straight to set distance at set speed(feet, percent speed)
//        addSequential(new Auton_Wait(2.0));
//        addSequential(new DriveToDistance(-5, -50));  // drive straight to set distance at set speed(feet, percent speed)
        
    }
}
