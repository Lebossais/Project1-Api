FROM maven:3.8.5-openjdk-17

COPY ./target/partage-recette-0.0.1-SNAPSHOT.jar partage-recette-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","partage-recette-0.0.1-SNAPSHOT.jar"]