/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands
    
//    public boolean isRollerOn = false;

    //Initialize Intake Components
    
    //Inialize shifter solenoids
    DoubleSolenoid intakeActuator = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_A, RobotMap.INTAKE_SOLENOID_B);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    //Method to extend the intake
    public void extend()
    {        
        intakeActuator.set(DoubleSolenoid.Value.kReverse);
    }//End of extend()
    
    //Method to retract the intake
    public void retract()
    {
        intakeActuator.set(DoubleSolenoid.Value.kForward);
        
    }//End of retract()
}
