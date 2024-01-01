package section1_addition.calculation;

public enum ECalculation {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");
    private final String sequence;

    private ECalculation(final String sequence) {
        this.sequence = sequence;
    }

    public static ECalculation from(String sequence) {
        for (ECalculation calculation : ECalculation.values()) {
            if (sequence.equals(calculation.sequence)) {
                return calculation;
            }
        }
        throw new IllegalArgumentException("Not Valid Sequence");
    }
}
