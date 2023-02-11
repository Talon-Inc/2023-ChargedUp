// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Turbo extends InstantCommand {
  private XboxController controller = null;
  public Turbo(XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (controller.getRightBumper()) { DRIVE_FACTOR = 1; }
    else { DRIVE_FACTOR = 0.5; }
  }
}
