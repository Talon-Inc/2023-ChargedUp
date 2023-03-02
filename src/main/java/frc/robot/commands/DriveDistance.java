// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {
  private double endLeftPosition;
  private double endRightPosition;
  private double leftRevs, rightRevs;
  private double distance;
  private boolean leftFlag, rightFlag, left, right;
  private Drivetrain drivetrain;
  // private final XboxController controller = new XboxController(CONTROLLER_PORT);
  /** Creates a new DriveDistance. */
  public DriveDistance(double leftRevs, double rightRevs, Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    // distance = inches;
    this.leftRevs = leftRevs;
    this.rightRevs = rightRevs;
    leftFlag = false;
    rightFlag = false;
    left = false;
    right = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
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
    double speed = .1;
    System.out.println("Left: " + leftMove + "; Right: " + rightMove);
    
    if (left) {
      if (endLeftPosition > leftMove) {
        drivetrain.moveLeftMotors(speed);
      }
      else {
        drivetrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }
    else {
      if (endLeftPosition < leftMove) {
        drivetrain.moveLeftMotors(-speed);
      }
      else {
        drivetrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }

    if (right) {
      if (endRightPosition > rightMove) {
        drivetrain.moveRightMotors(-speed);
        System.out.println("Right move forward");
      }
      else {
        drivetrain.moveRightMotors(0);
        rightFlag = true;
      }
    }
    else {
      if (endRightPosition < rightMove) {
        drivetrain.moveRightMotors(speed);
        System.out.println("Right move backward");
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
    if (leftFlag && rightFlag)
      return true;
    return false;
  }
}
