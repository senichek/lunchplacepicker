package com.olexiy.lunchplacepicker.utils.exceptions;

public class TooLateToVoteException extends RuntimeException {
    public TooLateToVoteException(String message) {
        super(message);
    }
}