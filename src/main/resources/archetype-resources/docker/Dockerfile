FROM openjdk:11.0.8-jdk

ARG JAR_FILE="target/${artifactId}-${version}.jar"
RUN addgroup --system --gid 1001 appuser
RUN adduser --system --uid 1001 --group appuser
COPY --chown=appuser:appuser ${JAR_FILE} app.jar
RUN mkdir /logs
RUN chmod 777 /logs
USER appuser

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=${SPRING_PROFILE}", "--db.user=${DB_USER}", "--db.pass=${DB_PASS}"]

# docker run --rm -p 8080:8080 -d --env SPRING_PROFILE=prod --env DB_USER=test --env DB_PASS=test
# docker run --rm -p 8080:8080 -d --env-file .env.prod
# .env.prod
#   SPRING_PROFILE=prod
#   DB_USER=test
#   DB_PASS=test
