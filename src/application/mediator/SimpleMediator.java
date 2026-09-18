package application.mediator;

import java.util.HashMap;
import java.util.Map;

import domain.result.Result;

public class SimpleMediator implements Mediator {

    private final Map<Class<?>, CommandHandler<?, ?>> handlers = new HashMap<>();

    public <R extends Result<?>, C extends Command<R>> void register(Class<C> commandType, CommandHandler<C, R> handler) {
        handlers.put(commandType, handler);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends Result<?>, C extends Command<R>> R send(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No hay un Handler registrado para " + command.getClass().getName());
        }
        return handler.handle(command);
    }
}