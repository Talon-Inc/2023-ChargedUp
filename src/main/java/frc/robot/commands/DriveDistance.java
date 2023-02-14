// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.ejml.dense.row.linsol.LinearSolver_FDRB_to_FDRM;

import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;


public class DriveDistance extends CommandBase {
  private double endLeftPosition;
  private double endRightPosition;
  private double leftRevs, rightRevs;
  private double distance;
  private boolean leftFlag, rightFlag;
  private DriveTrain driveTrain;
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
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    endLeftPosition = driveTrain.getDriveEncoder()[0] + leftRevs;
    endRightPosition = driveTrain.getDriveEncoder()[1] + rightRevs;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftMove = driveTrain.getDriveEncoder()[0];
    double rightMove = driveTrain.getDriveEncoder()[1];

    (controller.getXButton()){
      driveTrain.moveLeftMotors(rightMove);();

    if (endLeftPosition > leftMove) {
      driveTrain.moveLeftMotors(.4);
    }
    else if (endLeftPosition < leftMove) {
      driveTrain.moveLeftMotors(-.4);
    }
    else {
      driveTrain.moveLeftMotors(0);
      leftFlag = true;
    }

    if (endRightPosition > rightMove) {
      driveTrain.moveRightMotors(.4);
    }
    else if (endRightPosition < rightMove) {
      driveTrain.moveRightMotors(-.4);
    }
    else {
      driveTrain.moveRightMotors(0);
      rightFlag = true;
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
