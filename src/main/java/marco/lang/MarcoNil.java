package marco.lang;

public class MarcoNil implements MarcoObject {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoNil) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nil";
    }
}