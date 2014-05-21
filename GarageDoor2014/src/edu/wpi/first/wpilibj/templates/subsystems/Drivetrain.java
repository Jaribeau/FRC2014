/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;

/**
 *
 * @author Jared
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //Driver Station
    public DriverStationLCD driverStation;

    //Initialize drive motor Talons
    Talon leftDriveMotor1 = new Talon(RobotMap.LEFT_DRIVE_MOTOR_1);
    Talon leftDriveMotor2 = new Talon(RobotMap.LEFT_DRIVE_MOTOR_2);
    Talon leftDriveMotor3 = new Talon(RobotMap.LEFT_DRIVE_MOTOR_3);
    
    Talon rightDriveMotor1 = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_1);
    Talon rightDriveMotor2 = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_2);
    Talon rightDriveMotor3 = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_3);
    
    //Initialize RobotDrive modules, motors are split into two, as the constructor is limited to 4 motors
    public RobotDrive drive1;
    public RobotDrive drive2;
    
    //Initialize drivetrain encoders and gyroscope
    public Encoder leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_1, RobotMap.LEFT_DRIVE_ENCODER_2);
    public Encoder rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_1, RobotMap.RIGHT_DRIVE_ENCODER_2);
//    public Gyro gyro = new Gyro(RobotMap.GYRO);
    
    //Inialize shifter solenoids
    DoubleSolenoid shifters = new DoubleSolenoid(RobotMap.SHIFTERS_SOLENOID_A, RobotMap.SHIFTERS_SOLENOID_B);
    

    public Drivetrain()
    {
        //Initialize driverStation object
        driverStation = DriverStationLCD.getInstance();
        
        drive1 = new RobotDrive(leftDriveMotor1, leftDriveMotor2, rightDriveMotor1, rightDriveMotor2);
        drive2 = new RobotDrive(leftDriveMotor3, rightDriveMotor3);
        leftDriveEncoder.setDistancePerPulse(-1.0);
        rightDriveEncoder.setDistancePerPulse(-1.0);
        leftDriveEncoder.start();
        rightDriveEncoder.start();
        
    }//End of constructor
    

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    
    
    /**
     * Drive the robot using a single {@link GenericHID} device. With 1 {@link GenericHID} device, it is assumed that Y will be for the speed and X will be for the curve. 
     * 
     * @param stick The {@link GenericHID} device to use for Arcade single-stick driving. The Y-axis will be for forward/backwards and the X-axis for left/right.
     * 
     * @since 1.0
     * @see RobotDrive#arcadeDrive(edu.wpi.first.wpilibj.GenericHID)
     */
    public void arcadeDrive(Joystick stick)
    {
            drive1.arcadeDrive(stick);
            drive2.arcadeDrive(stick);
    }// End of arcadeDrive method
    
    //Custom drive code to enable deadband customization
    public void customDrive(Joystick stick)
    {
        if(Math.abs(stick.getY()) <= 0.2 && Math.abs(stick.getX()) <= 0.2)
        {
            drive1.drive(0, 0);
            drive2.drive(0, 0);
        }
        else
        {
            drive1.drive(stick.getY(), stick.getX());
            drive2.drive(stick.getY(), stick.getX());
        }
    }// End of arcadeDrive method
    
    //Method to shift to high drive gear
    public void shiftHigh()
    {
        shifters.set(DoubleSolenoid.Value.kForward);
    }//End of shiftHigh()
    
    //Method to shift to low drive gear
    public void shiftLow()
    {
        shifters.set(DoubleSolenoid.Value.kReverse);
    }//End of shiftLow()
    
    //Method to manually set the drivetrain motor speeds based on motor percent
    public void setDrivePercent(double leftSpeed, double rightSpeed)
    {
            drive1.setLeftRightMotorOutputs(leftSpeed, rightSpeed);
            drive2.setLeftRightMotorOutputs(leftSpeed, rightSpeed);
    }//End of setDrivePercent
    
    public void resetEncoders()
    {
//       leftDriveEncoder.reset();
//       rightDriveEncoder.reset();
    }
    
    public void resetGyro()
    {
//       gyro.reset();
    }

    public void driveStraight(int percentSpeed) 
    {
//        double angle = gyro.getAngle();
//        drive1.drive(percentSpeed*0.01, angle * RobotMap.GYRO_HEADING_KP);
//        drive2.drive(percentSpeed*0.01, angle * RobotMap.GYRO_HEADING_KP);
    }
    
}//End of Drivetrain Class
