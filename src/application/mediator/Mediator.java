package application.mediator;

import domain.result.Result;

public interface Mediator {
    public <R extends Result<?>, C extends Command<R>> R send(C command);
}