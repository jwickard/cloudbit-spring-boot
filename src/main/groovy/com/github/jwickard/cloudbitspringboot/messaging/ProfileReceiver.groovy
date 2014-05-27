package com.github.jwickard.cloudbitspringboot.messaging

/**
 * <p>ProfileReceiver</p>
 * <p>Receives Profile Messages From Rabbit</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
interface ProfileReceiver {
    public void receiveMessage(String msg)
}
