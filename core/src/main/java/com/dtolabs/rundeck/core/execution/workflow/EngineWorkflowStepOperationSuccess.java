package com.dtolabs.rundeck.core.execution.workflow;

import com.dtolabs.rundeck.core.dispatcher.DataContext;
import com.dtolabs.rundeck.core.execution.workflow.steps.StepExecutionResult;
import com.dtolabs.rundeck.core.rules.StateObj;
import com.dtolabs.rundeck.core.rules.WorkflowSystem;

/**
 * Successful result of a workflow step operation
 */
class EngineWorkflowStepOperationSuccess implements WorkflowSystem.OperationSuccess<DataContext> {
    int stepNum;
    BaseWorkflowExecutor.StepResultCapture stepResultCapture;
    private StateObj newState;

    EngineWorkflowStepOperationSuccess(
            final int stepNum,
            final StateObj newState, BaseWorkflowExecutor.StepResultCapture stepResultCapture
    )
    {

        this.stepNum = stepNum;
        this.newState = newState;
        this.stepResultCapture = stepResultCapture;
    }

    @Override
    public DataContext getResult() {
        return stepResultCapture.getResultData();
    }
    public BaseWorkflowExecutor.StepResultCapture getStepResultCapture() {
        return stepResultCapture;
    }

    @Override
    public StateObj getNewState() {
        return newState;
    }

    @Override
    public String toString() {
        return "StepSuccess{" +
               "stepNum=" + stepNum +
               ", stepResultCapture=" + stepResultCapture +
               ", newState=" + newState +
               '}';
    }
}
