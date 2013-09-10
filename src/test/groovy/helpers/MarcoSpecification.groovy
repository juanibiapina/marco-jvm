package helpers

import marco.lang.MarcoObject
import marco.lang.MarcoRuntime
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def runtime = new MarcoRuntime();

    def MarcoObject eval(String code) {
        MarcoObject program = runtime.parse(code)
        return runtime.interpreter.eval(runtime.object, program);
    }

    def message(String message) {
        parse(message)
    }

    def parse(String message) {
        runtime.parse(message)
    }
}