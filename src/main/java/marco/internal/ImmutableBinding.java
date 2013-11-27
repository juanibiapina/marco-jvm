package marco.internal;

import marco.lang.MarcoObject;
import marco.lang.exception.MarcoImmutabilityError;

public class ImmutableBinding extends Binding {
    public ImmutableBinding(String var, MarcoObject value) {
        super(var, value);
    }

    @Override
    public void mutate(MarcoObject value) {
        throw new MarcoImmutabilityError(this);
    }
}