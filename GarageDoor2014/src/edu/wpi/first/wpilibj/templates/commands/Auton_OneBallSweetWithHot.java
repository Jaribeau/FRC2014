/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class Auton_OneBallSweetWithHot extends CommandGroup {
    
    public Auton_OneBallSweetWithHot() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
//        addSequential(new Auton_CheckHotGoal());
        addSequential(new DriveToDistance(5, 50));  // drive straight to set distance at set speed(feet, percent speed)
        addParallel(new MoveIntake("EXTEND"));
        addParallel(new ActivateIntakeRoller("FORWARD"));
        addSequential(new Auton_Wait(1.0));
        addSequential(new ActivateIntakeRoller("OFF"));
        
        if(!RobotMap.hot)
            addSequential(new Auton_Wait(4.0));
        
        addSequential(new LaunchBall("SAFE"));
    }
}
