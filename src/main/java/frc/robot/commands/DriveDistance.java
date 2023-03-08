// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Sensor;

public class DriveDistance extends CommandBase {
  private double endLeftPosition;
  private double endRightPosition;
  private double leftRevs, rightRevs;
  public boolean leftFlag, rightFlag, left, right, flag, toggle;
  private Drivetrain drivetrain;
  private Sensor sensor;
  //private Sensor sensor;
  // private final XboxController controller = new XboxController(CONTROLLER_PORT);
  /** Creates a new DriveDistance. */
  public DriveDistance(double leftRevs, double rightRevs, Drivetrain drivetrain, Sensor sensor, boolean toggle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.sensor = sensor;
    //this.sensor = sensor;
    addRequirements(drivetrain);
    // distance = inches;
    this.leftRevs = leftRevs;
    this.rightRevs = rightRevs;
    leftFlag = false;
    rightFlag = false;
    left = false;
    right = false;
    flag = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.sensor = new Sensor();
    endLeftPosition = drivetrain.getDriveEncoder()[0] + leftRevs;
    endRightPosition = drivetrain.getDriveEncoder()[1] + rightRevs;
    
    if (endLeftPosition > drivetrain.getDriveEncoder()[0])
      left = true;

    if (endRightPosition > drivetrain.getDriveEncoder()[1])
      right = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftMove = drivetrain.getDriveEncoder()[0];
    double rightMove = drivetrain.getDriveEncoder()[1];
    double leftspeed = .34;
    double rightspeed = .36;
    //System.out.println("Left: " + leftMove + "; Right: " + rightMove);
    sensor.pigeonIMU.getYawPitchRoll(sensor.ypr_deg);
    //System.out.println(sensor.ypr_deg[2]);

    if (toggle) {
      if (sensor.ypr_deg[2] < -13 || sensor.ypr_deg[2] > 13){
        System.out.println("Activated");
        flag = true;
      }
    }

    if (left) {
      if (endLeftPosition > leftMove) {
        drivetrain.moveLeftMotors(leftspeed);
      }
      else {
        drivetrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }
    else {
      if (endLeftPosition < leftMove) {
        drivetrain.moveLeftMotors(-leftspeed);
      }
      else {
        drivetrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }

    if (right) {
      if (endRightPosition > rightMove) {
        drivetrain.moveRightMotors(rightspeed);
      }
      else {
        drivetrain.moveRightMotors(0);
        rightFlag = true;
      }
    }
    else {
      if (endRightPosition < rightMove) {
        drivetrain.moveRightMotors(-rightspeed);
      }
      else {
        drivetrain.moveRightMotors(0);
        rightFlag = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0,  0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (leftFlag && rightFlag){
      return true;
    }
    if (flag) {
      return true;
    }
    return false;
  }
}
