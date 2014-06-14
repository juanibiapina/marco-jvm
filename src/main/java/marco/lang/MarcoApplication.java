package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.Frame;

import java.util.ArrayList;
import java.util.List;

public class MarcoApplication extends MarcoObject {
    private MarcoList list;

    public MarcoApplication(MarcoList list) {
        this.list = list;
    }

    @Override
    public MarcoObject eval(Environment dynamic) {
        MarcoObject head = list.getHead();
        MarcoList tail = list.getTail();

        MarcoObject operator = head.eval(dynamic);
        List<MarcoObject> arguments = new ArrayList<>();
        for (int i = 0; i < tail.length(); i++) {
            arguments.add(tail.get(i).eval(dynamic));
        }
        return dynamic.stack(new Frame(getStartLine(), Cast.toRunnable(operator), arguments, dynamic));
    }

    @Override
    public String typeName() {
        return "Application";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoApplication) {
            MarcoApplication other = (MarcoApplication) obj;
            return list.equals(other.list);
        } else {
            return false;
        }
    }
}
