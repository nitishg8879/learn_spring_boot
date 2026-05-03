package java_learn;

public enum SwitchTest {
    RED, GREEN, BLUE;
}

enum SwitchTestWeekends {
    M,
    T,
    W, THUR, F, S;
}

class SwitchTestWeekendsTest {
    public static void main(String[] args) {
        SwitchTest color = SwitchTest.BLUE;
        SwitchTestWeekends weekends = SwitchTestWeekends.M;

        String val = switch (color) {
            case RED, GREEN -> "Color is: ";
            case BLUE -> "Color is: ";
            default -> {
                yield "Unknown color";
            }
        };
    }
}
