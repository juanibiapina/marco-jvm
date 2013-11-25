package marco.internal;

import marco.lang.exception.MarcoBindingError;
import marco.lang.exception.MarcoLookUpError;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.functions.plus;
import marco.lang.macros.def;
import marco.lang.macros.function;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, MarcoObject> env = new HashMap<>();

    public Environment() {
        bind("def", new def());
        bind("function", new function());
        bind("nil", new MarcoNil());
        bind("+", new plus());
    }

    public Environment(Map env) {
        this.env = env;
    }

    public void bind(String var, MarcoObject value) {
        if (env.containsKey(var)) {
            throw new MarcoBindingError(var, value, env.get(var));
        } else {
            env.put(var, value);
        }
    }

    public MarcoObject lookUp(String var) {
        if (env.containsKey(var)) {
            return env.get(var);
        } else {
            throw new MarcoLookUpError(var);
        }
    }

    public Environment duplicate() {
        Map newEnv = new HashMap();
        newEnv.putAll(env);
        return new Environment(newEnv);
    }

    public void rebind(String var, MarcoObject value) {
        env.put(var, value);
    }
}