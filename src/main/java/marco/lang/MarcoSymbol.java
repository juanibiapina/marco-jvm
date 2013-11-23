package marco.lang;

import marco.internal.Environment;

public class MarcoSymbol implements MarcoForm {
    private String value;

    public MarcoSymbol(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return environment.lookUp(value);
    }

    public String getValue() {
        return value;
    }
}
