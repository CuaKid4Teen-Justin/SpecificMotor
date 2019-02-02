/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Constants;

/**
 * Add your docs here.
 */
public class constants {
    // kp * ep + kD * eD
    // this is where you manually input and tune constants
  public static final double kP = 0.000052;
  public static final double kD = 0.00000070001;
  public static final double tolerance = 3;

  // kP is for UnderShooting
  // kD is for OverShooting

  // kP three zeroes good, .0001 bad, .0002 "too low?"
  // don't work? kP too small
  // kP .00005 1014, .000049 954, .000051 1150. no kD

  // kp 0.00005 better without kD
}
