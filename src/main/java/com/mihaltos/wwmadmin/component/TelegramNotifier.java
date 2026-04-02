package com.mihaltos.wwmadmin.component;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TelegramNotifier extends AbstractStatusChangeNotifier {
    public TelegramNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> {
            if (event instanceof InstanceStatusChangedEvent) {
                String message = "Сервис " + instance.getRegistration().getName() +
                        " сменил статус на " + ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus();
                // Тут вызвать отправку в Telegram (через RestTemplate или Feign)
                System.out.println("SEND TO TG: " + message);
            }
        });
    }
}

