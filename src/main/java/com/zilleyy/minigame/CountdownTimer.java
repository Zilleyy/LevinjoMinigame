package com.zilleyy.minigame;

import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Consumer;

/**
 * Author: Zilleyy
 * <br>
 * Date: 10/03/2021 @ 12:35 pm AEST
 */
public class CountdownTimer extends BukkitRunnable {

    // Our scheduled task's assigned id, needed for canceling
    private Integer assignedTaskId;

    // Seconds and shiz
    private int seconds;
    private int secondsLeft;
    private int interval;

    // Actions to perform while counting down, before and after
    @Setter private Consumer<Void> everyUpdate;
    @Setter private Consumer<Void> beforeTimer;
    @Setter private Consumer<Void> afterTimer;

    // Construct a timer, you could create multiple so for example if
    // you do not want these "actions"
    public CountdownTimer(final int seconds, final int interval, final Consumer<Void> everyUpdate, final Consumer<Void> beforeTimer, final Consumer<Void> afterTimer) {
        this.seconds = seconds;
        this.secondsLeft = seconds;
        this.interval = interval;

        this.beforeTimer = beforeTimer;
        this.afterTimer = afterTimer;
        this.everyUpdate = everyUpdate;

        this.runTaskTimer(Central.getInstance(), 0L, 20L);
    }

    public CountdownTimer(final int seconds, final int interval) {
        this.seconds = seconds;
        this.secondsLeft = seconds;
        this.interval = interval;

        this.runTaskTimer(Central.getInstance(), 0L, 20L);
    }

    /**
     * Runs the timer once, decrements seconds etc...
     * Really wish we could make it protected/private so you couldn't access it
     */
    @Override
    public void run() {
        // Is the timer up?
        if (secondsLeft < 1) {
            // Do what was supposed to happen after the timer
            afterTimer.accept(null);

            // Cancel timer
            if (assignedTaskId != null) Bukkit.getScheduler().cancelTask(assignedTaskId);
            return;
        }

        // Are we just starting?
        if (secondsLeft == seconds) beforeTimer.accept(null);

        // Do what's supposed to happen every update.
        if(this.secondsLeft % this.interval == 0) everyUpdate.accept(null);

        // Decrement the seconds left
        secondsLeft--;
    }

    /**
     * Gets the total seconds this timer was set to run for
     *
     * @return Total seconds timer should run
     */
    public int getTotalSeconds() {
        return seconds;
    }

    /**
     * Gets the seconds left this timer should run
     *
     * @return Seconds left timer should run
     */
    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void stopTask() {
        Bukkit.getScheduler().cancelTask(this.assignedTaskId);
    }

}