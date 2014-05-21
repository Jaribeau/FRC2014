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
public class Auton_Default_OneBallSweetSpot extends CommandGroup 
{
    public Auton_Default_OneBallSweetSpot() 
    {
        // If a command is run using "addParallel", the following command will
        // start at the same time. If a command is run using "addSequential",
        // the following command will not start until the previous command ends.
        
        // Commands like MoveIntake() and ActivateIntakeRoller() simply set the 
        // state of the subsytem, and therefore "end" after one execution, even
        // though the roller will stay on/the intake will stay retracted. In
        // a situation like this, use the Wait() command to add a delay.
        
        
        addSequential(new DriveToDistance(5, 50));  // drive straight to set distance at set speed(feet, percent speed)
        addParallel(new MoveIntake("EXTEND"));
        addParallel(new ActivateIntakeRoller("FORWARD"));
        addSequential(new Auton_Wait(1.0));
        addSequential(new ActivateIntakeRoller("OFF"));
        addSequential(new LaunchBall("SAFE"));
    }
}
