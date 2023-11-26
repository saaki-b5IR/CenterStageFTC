package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "OdometryTest")
public class OdometryTest extends LinearOpMode {
    private DcMotor BLeft;
    private DcMotor BRight;
    private DcMotor FLeft;
    private DcMotor FRight;

    @Override
    public void runOpMode() {
        BLeft = hardwareMap.dcMotor.get("BLeft");
        BRight = hardwareMap.dcMotor.get("BRight");
        FLeft = hardwareMap.dcMotor.get("FLeft");
        FRight = hardwareMap.dcMotor.get("FRight");

        FLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        setZeroPowerBehavior();

        waitForStart();

        if (opModeIsActive()) {
            // Put run blocks here.
            setZeroPowerBehavior();

            while (opModeIsActive() && FLeft.getCurrentPosition() < 5000) {

                runMotors(0.25);
                telemetry.addData("Encoder Ticks:", FLeft.getCurrentPosition());
                telemetry.update();
            }
            stopMotors();

            FLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            while (opModeIsActive() && FLeft.getCurrentPosition() > -300) {

                turnRight(0.25);
                telemetry.addData("Encoder Ticks:", FLeft.getCurrentPosition());
                telemetry.update();
            }
            stopMotors();

            telemetry.addData("Encoder Ticks:", FLeft.getCurrentPosition());
            telemetry.update();
        }
    }


    public void setZeroPowerBehavior() {
        BLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void stopMotors() {
        BLeft.setPower(0);
        BRight.setPower(0);
        FLeft.setPower(0);
        FRight.setPower(0);
    }

   public void runMotors (double power) {
        BLeft.setPower(power);
        BRight.setPower(0.95 * power);
        FLeft.setPower(power);
        FRight.setPower(0.95 * power);
   }

   public void turnRight (double power) {
        BLeft.setPower(-power);
        BRight.setPower(power);
        FRight.setPower(power);
        FLeft.setPower(-power);
   }

    public void turnLeft (double power) {
        BLeft.setPower(power);
        BRight.setPower(-power);
        FRight.setPower(-power);
        FLeft.setPower(power);
    }
}
