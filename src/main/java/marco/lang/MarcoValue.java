package marco.lang;

import marco.internal.Environment;

public abstract class MarcoValue extends MarcoObject {
    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }
}
