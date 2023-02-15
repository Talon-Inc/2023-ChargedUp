// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import static frc.robot.Constants.OperatorConstants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;

public class DriveDistance extends CommandBase {
  private double endLeftPosition;
  private double endRightPosition;
  private double leftRevs, rightRevs;
  private double distance;
  private boolean leftFlag, rightFlag, left, right;
  private DriveTrain driveTrain;
  // private final XboxController controller = new XboxController(CONTROLLER_PORT);
  /** Creates a new DriveDistance. */
  public DriveDistance(double leftRevs, double rightRevs, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
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
    endLeftPosition = driveTrain.getDriveEncoder()[0] + leftRevs;
    endRightPosition = driveTrain.getDriveEncoder()[1] + rightRevs;
    
    if (endLeftPosition > driveTrain.getDriveEncoder()[0])
      left = true;

    if (endRightPosition > driveTrain.getDriveEncoder()[1])
      right = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftMove = driveTrain.getDriveEncoder()[0];
    double rightMove = driveTrain.getDriveEncoder()[1];
    double speed = .1;
    System.out.println("Left: " + leftMove + "; Right: " + rightMove);
    
    if (left) {
      if (endLeftPosition > leftMove) {
        driveTrain.moveLeftMotors(speed);
      }
      else {
        driveTrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }
    else {
      if (endLeftPosition < leftMove) {
        driveTrain.moveLeftMotors(-speed);
      }
      else {
        driveTrain.moveLeftMotors(0);
        leftFlag = true;
      }
    }

    if (right) {
      if (endRightPosition > rightMove) {
        driveTrain.moveRightMotors(speed);
      }
      else {
        driveTrain.moveRightMotors(0);
        rightFlag = true;
      }
    }
    else {
      if (endRightPosition < rightMove) {
        driveTrain.moveRightMotors(-speed);
      }
      else {
        driveTrain.moveRightMotors(0);
        rightFlag = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0,  0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (leftFlag && rightFlag)
      return true;
    return false;
  }
}
