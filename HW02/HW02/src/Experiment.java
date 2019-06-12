/*
 * Gokhan Has - 161044067
 */

/**
 * @author GokhanHas
 */

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the Experiment class to keep track of some
 * machine learning experiments and their results.
 *
 * @author GokhanHas
 */
public class Experiment {

    /**
     * Explains the experimental setup.
     */
    private String setup;

    /**
     * Represents the day of start.
     */
    private int day;

    /**
     * Represents the time of start.
     */
    private Time time;

    /**
     * Indicates whether it is completed or not.
     */
    private boolean completed;

    /**
     * Represents the output (not a valid value if the experiment
     * is not completed)
     */
    private float accuracy;

    public Experiment() {
        setup = "empty";
        day = 0;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        time = new Time(0,0,0);
        completed = false;
        accuracy = -1;
    }

    public Experiment(Experiment exp) {
        this.setup = exp.setup;
        this.day = exp.day;
        this.time = exp.time;
        this.completed = exp.completed;
        this.accuracy = exp.accuracy;
    }

    public Experiment(String isetup,int iday,Time itime,boolean icompleted,float iaccuracy) {
        setup = isetup;
        day = iday;
        time = itime;
        completed = icompleted;
        accuracy = iaccuracy;
    }

    /**
     *
     * @return the day of start.
     */
    public int getDay() {
        return this.day;
    }

    /**
     *
     * @return the experimental setup.
     */
    public String getSetup() {
        return this.setup;
    }

    /**
     *
     * @return the experiment is completed or not.
     */
    public boolean getCompleted() {
        return this.completed;
    }

    /**
     *
     * @return the output.
     */
    public float getAccuracy() {
        return this.accuracy;
    }

    /**
     *
     * @return String the properties of Experiment.
     */
    @Override
    public String toString() {
        return String.format("Setup: " + setup + "          Day: " + day + "          Time: " + time +
                "          Completed: " + completed + "          Accuracy: " + accuracy + "\n");
    }
}