/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public static TalonSRX m_Rave;


public Drive (){
  m_Rave = new TalonSRX(5);
  m_Rave.setInverted(true);
}

public double Position(){
    return m_Rave.getSelectedSensorPosition();
}

public void SetPower(double power){
 m_Rave.set(ControlMode.PercentOutput, -power);
}

public void ResetEncoders(){
m_Rave.setSelectedSensorPosition(0);
}

public void ReportToDashboard(){
SmartDashboard.putNumber("Encoder Value", Position());
}

public void resetGyro(){
// m_gyro.reset();
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
