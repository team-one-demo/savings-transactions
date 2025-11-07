FROM eclipse-temurin:21-jdk-jammy as build
WORKDIR /workspace/app

# Copy maven files first for better layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make the mvnw script executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Runtime stage
FROM eclipse-temurin:21-jre-jammy
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency

# Copy the dependency application layer by layer
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Set the entrypoint
ENTRYPOINT ["java","-cp","app:app/lib/*","com.bank.transactionsservice.TransactionsServiceApplication"]

# Add health check
HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget -q --spider http://localhost:8080/actuator/health || exit 1