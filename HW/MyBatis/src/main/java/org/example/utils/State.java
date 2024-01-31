package org.example.utils;

public enum State {
    ACTIVE(0),
    INACTIVE(1),
    CLOSED(2);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static State fromValue(int value) {
        for (State state : State.values()) {
            if (state.value == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid State value: " + value);
    }
}

