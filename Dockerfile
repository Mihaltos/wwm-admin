# Используем легкий образ Java 21 для M1
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Копируем уже собранный файл (путь после ./gradlew bootJar)
# В Gradle по умолчанию это build/libs/wwm.jar
COPY build/libs/wwm-admin.jar app.jar

# Запуск
ENTRYPOINT ["java", "-jar", "app.jar"]
