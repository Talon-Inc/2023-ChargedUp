// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;

public class Pneumatics extends SubsystemBase {

//Variables
  private PneumaticHub pneumaticHub = null;
  private Compressor comp = null;
  private DoubleSolenoid claw = null;

  /** Creates a new Pneumatics. */
  public Pneumatics() {
    pneumaticHub = new PneumaticHub();
    pneumaticHub.enableCompressorDigital();

    // comp = new Compressor(PNEUMATICS_MODULE_TYPE);
    // comp.enableDigital();

    claw = pneumaticHub.makeDoubleSolenoid(FORWARD_CHANNEL, REVERSE_CHANNEL);
  }
  
  public void openClaw() {
    claw.set(DoubleSolenoid.Value.kForward);
  }

  public void closeClaw() {
    claw.set(DoubleSolenoid.Value.kReverse);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
