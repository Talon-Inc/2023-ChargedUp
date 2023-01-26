// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Pneumatics extends SubsystemBase {

//Variables
  private Compressor comp = null;
  private DoubleSolenoid sol1 = null;

  /** Creates a new Pneumatics. */
  public Pneumatics() {
    comp = new Compressor(PneumaticsModuleType.valueOf("CTREPCM"));
    comp.enableDigital();
    sol1 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 0, 1);
    }
    
    public void sol1Open() {
      sol1.set(DoubleSolenoid.Value.kForward);
    }

    public void sol1Close() {
      sol1.set(DoubleSolenoid.Value.kReverse);
    }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
