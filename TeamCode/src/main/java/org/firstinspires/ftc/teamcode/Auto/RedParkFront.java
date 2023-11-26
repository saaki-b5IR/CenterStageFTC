package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//Set Robot facing parking
//Robot is closest to wing
@Autonomous (name="RedParkFront")
public class RedParkFront extends LinearOpMode {

    private DcMotor BLeft;
    private DcMotor BRight;
    private DcMotor FLeft;
    private DcMotor FRight;
    private DcMotor Arm;
    private DcMotor Linear;
    private CRServo Claw;
    private CRServo Climber;
    private DcMotor Spool;
    private Servo shoot;

    @Override
    public void runOpMode () {
        BLeft = hardwareMap.dcMotor.get("BLeft");
        BRight = hardwareMap.dcMotor.get("BRight");
        FLeft  = hardwareMap.dcMotor.get("FLeft");
        FRight = hardwareMap.dcMotor.get("FRight");
        Arm = hardwareMap.dcMotor.get("Arm");
        Linear = hardwareMap.dcMotor.get("Linear");
        Claw = hardwareMap.crservo.get("Claw");
        Climber = hardwareMap.crservo.get("Climber");
        Spool = hardwareMap.dcMotor.get("Spool");
        shoot = hardwareMap.servo.get("shoot");

        FRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        Linear.setDirection(DcMotorSimple.Direction.REVERSE);

        Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        while (opModeIsActive()) {

            strafeMotorsLeft(0.25, 100);
            runMotorsTime(-0.5, 3000);

            brakeMotors();

            telemetry.update();
        }
    }

    public void brakeMotors(){
        BLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void runMotorsTime(double power, long motorTime) {
        BLeft.setPower(power);
        BRight.setPower(power * 0.9);
        FRight.setPower(power * 0.9);
        FLeft.setPower(power);

        sleep(motorTime);

        BLeft.setPower(0);
        BRight.setPower(0);
        FRight.setPower(0);
        FLeft.setPower(0);
    }

    public void strafeMotorsRight(double power, long motorTime) {
        BLeft.setPower(-power);
        BRight.setPower(power);
        FRight.setPower(-power);
        FLeft.setPower(power);

        sleep(motorTime);

        BLeft.setPower(0);
        BRight.setPower(0);
        FRight.setPower(0);
        FLeft.setPower(0);
    }

    public void strafeMotorsLeft(double power, long motorTime) {
        BLeft.setPower(power);
        BRight.setPower(-power);
        FRight.setPower(power);
        FLeft.setPower(-power);

        sleep(motorTime);

        BLeft.setPower(0);
        BRight.setPower(0);
        FRight.setPower(0);
        FLeft.setPower(0);
    }

    public void turnRight(double power, long motorTime) {
        BLeft.setPower(power);
        BRight.setPower(-power);
        FRight.setPower(-power);
        FLeft .setPower(power);

        sleep(motorTime);

        BLeft.setPower(0);
        BRight.setPower(0);
        FRight.setPower(0);
        FLeft.setPower(0);

    }

    public void turnLeft(double power, long motorTime) {
        BLeft.setPower(-power);
        BRight.setPower(power);
        FRight.setPower(power);
        FLeft.setPower(-power);

        sleep(motorTime);

        BLeft.setPower(0);
        BRight.setPower(0);
        FRight.setPower(0);
        FLeft.setPower(0);
    }
}
