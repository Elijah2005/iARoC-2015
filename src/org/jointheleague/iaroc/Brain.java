package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    public IOIO ioio;
    public DigitalOutput led;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
        this.ioio = ioio;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?



    }

    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);

        drag();
        // readSensors(6);
        // int getInfared = getInfraredByte();
        // driveDirect(300, -300);

        /// dashboard.log(" " + getInfared);


    }

    public void drag() throws ConnectionLostException {
        driveDirect(395,500);
    }

    public void maze() throws ConnectionLostException {
        driveDirect(500, 221);
        if (isBumpLeft()) {
            driveDirect(-250, -50);
            SystemClock.sleep(750);

            driveDirect(500, 221);
            SystemClock.sleep(450);
            driveDirect(500, 221);
        }
    }
}