package deckedoutdroppers;

import java.util.List;
import java.util.function.Function;

public record DispenseActionConditions(List<List<Function<DispenseAction, Boolean>>> allChecks) {
    public boolean evaluate(DispenseAction dispenseAction) {
        for (List<Function<DispenseAction, Boolean>> conditions : allChecks) {
            if (evaluateCheck(dispenseAction, conditions))
                return true;
        } return false;
    }
    
    public boolean evaluateCheck(DispenseAction dispenseAction, List<Function<DispenseAction, Boolean>> conditions) {
        for (Function<DispenseAction, Boolean> condition : conditions) {
            if (!condition.apply(dispenseAction))
                return false;
        } return true;
    }
}
