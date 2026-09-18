package application.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import domain.result.Result;

public class SimpleMediator implements Mediator {
    private final Map<Class<?>, CommandHandler<?, ?>> handlers = new HashMap<>();

    public <R extends Result<?>, C extends Command<R>> void register(Class<C> commandType, CommandHandler<C, R> handler) {
        Objects.requireNonNull(commandType, "commandType cannot be null");
        Objects.requireNonNull(handler, "handler cannot be null");

        if (handlers.containsKey(commandType)) {
            throw new IllegalStateException(
                    "A handler is already registered for " + commandType.getName());
        }

        handlers.put(commandType, handler);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends Result<?>, C extends Command<R>> R send(C command) {
        Objects.requireNonNull(command, "command cannot be null");

        Class<C> commandType = (Class<C>) command.getClass();
        CommandHandler<C, R> handler = (CommandHandler<C, R>) handlers.get(commandType);

        if (handler == null) {
            throw new IllegalArgumentException(
                    "There is no registered handler for " + commandType.getName());
        }

        return handler.handle(command);
    }
}
