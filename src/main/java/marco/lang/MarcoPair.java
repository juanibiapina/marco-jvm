package marco.lang;

public class MarcoPair extends MarcoValue {
    private MarcoObject first;
    private MarcoObject second;

    public MarcoPair(MarcoObject first, MarcoObject second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String typeName() {
        return "Pair";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return "<" + first.convertToString() + " " + second.convertToString() + ">";
    }

    public MarcoObject getFirst() {
        return first;
    }

    public MarcoObject getSecond() {
        return second;
    }
}
