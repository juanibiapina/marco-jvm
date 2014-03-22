package marco.lang.functions.nil;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class nilquestion extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject arg = closure.lookUp("arg");

        return MarcoBoolean.from(arg instanceof MarcoNil);
    }
}
