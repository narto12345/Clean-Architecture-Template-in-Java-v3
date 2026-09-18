package application.mediator;

import domain.result.Result;

public interface CommandHandler<C extends Command<R>, R extends Result<?>> {
    public R handle(C command);
}