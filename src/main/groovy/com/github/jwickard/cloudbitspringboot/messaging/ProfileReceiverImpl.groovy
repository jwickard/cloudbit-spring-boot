package com.github.jwickard.cloudbitspringboot.messaging

/**
 * <p>ProfileReceiverImpl</p>
 * <p>Receiver Implementation</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
class ProfileReceiverImpl implements ProfileReceiver {
    @Override
    void receiveMessage(String msg) {
        println(msg)
    }
}
