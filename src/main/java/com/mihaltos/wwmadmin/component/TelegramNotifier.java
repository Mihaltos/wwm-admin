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
            if (event instanceof InstanceStatusChangedEvent statusEvent) {
                String serviceName = instance.getRegistration().getName();
                String newStatus = statusEvent.getStatusInfo().getStatus();

                // Иконка в зависимости от статуса
                String icon = "UP".equals(newStatus) ? "✅" : "❌";
                String message = String.format("%s Сервис: *%s*%nСтатус изменился на: *%s*",
                        icon, serviceName, newStatus);

                sendToTelegram(message);
            }
        });
    }

    private void sendToTelegram(String text) {
//        String url = "https://telegram.org<ВАШ_ТОКЕН>/sendMessage?chat_id=<ВАШ_ID>&parse_mode=Markdown&text=" + text;
//        try {
//            new RestTemplate().getForObject(url, String.class);
//        } catch (Exception e) {
//            System.err.println("Ошибка отправки в Telegram: " + e.getMessage());
//        }
    }
}


