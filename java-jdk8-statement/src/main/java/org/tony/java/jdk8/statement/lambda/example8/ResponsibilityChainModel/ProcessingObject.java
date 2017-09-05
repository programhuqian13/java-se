package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

/**
 * Created by xuanyi on 2017/9/4.
 */
public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public ProcessingObject<T> getSuccessor() {
        return successor;
    }

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if (successor != null){
            return successor.handle(r);
        }
        return r;
    }

    protected abstract T handleWork(T input);
}
