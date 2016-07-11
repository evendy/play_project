package cn.evendy.uniots.module;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by evendy .
 */
public class Alarm implements Serializable {
    public static final int TYPE_REPEAT_ONLY = 0;
    public static final int TYPE_REPEAT_WORKDAY = 1;
    public static final int TYPE_REPEAT_MON_TO_FIR = 2;
    public static final int TYPE_REPEAT_EVERYDAY = 3;

    public static final boolean STATE_OPEN = true;
    public static final boolean STATE_CLOSE = false;

    private Calendar time;
    private int repeatType;
    private boolean state;
    private int soundIndex;

    public Alarm() {
    }

    public Calendar getTime() {

        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getSoundIndex() {
        return soundIndex;
    }

    public void setSoundIndex(int soundIndex) {
        this.soundIndex = soundIndex;
    }
}
