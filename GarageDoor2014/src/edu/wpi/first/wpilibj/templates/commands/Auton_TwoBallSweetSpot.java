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
public class Auton_TwoBallSweetSpot extends CommandGroup {
    
    public Auton_TwoBallSweetSpot() 
    {
        addParallel(new MoveIntake("EXTEND"));
        addParallel(new ActivateIntakeRoller("FORWARD"));
        addSequential(new Auton_Wait(1.0));
        addSequential(new DriveToDistance(5, 50));  // drive straight (feet, percent speed)
        addSequential(new ActivateIntakeRoller("OFF"));
        addSequential(new LaunchBall("SAFE"));
        addParallel(new ActivateIntakeRoller("FORWARD"));
        addSequential(new Auton_Wait(2.0));
        addSequential(new LaunchBall("SAFE"));
    }
}
