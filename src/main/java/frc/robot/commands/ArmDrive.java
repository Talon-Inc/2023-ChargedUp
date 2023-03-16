// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.ARM_FACTOR;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.lang.ModuleLayer.Controller;
import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Arm;

public class ArmDrive extends CommandBase {
  private CommandXboxController controller = null;
  private Arm arm = null;
  /** Creates a new ArmDrive. */
  public ArmDrive(Arm arm, CommandXboxController controller) {
    this.arm = arm;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double armspeed = ARM_FACTOR * controller.getRightY();
    arm.extend(armspeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
