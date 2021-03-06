package marco.lang.functions.bindings;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.bindings.Binding;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;
import marco.lang.error.LookUpError;

public class setbang extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoSymbol name = Cast.toSymbol(closure.lookUp("name"));
        MarcoObject value = closure.lookUp("value");

        Binding binding = dynamic.get(name.getValue());
        if (binding.isEmpty()) {
            throw new LookUpError(null, -1, name.getValue());
        }
        binding.mutate(value);

        return MarcoNil.NIL;
    }
}
