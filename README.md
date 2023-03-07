# Spring Kafka Streams implemented with Kotlin❤️

## How to setup

- Run docker compose with the following command in the project's root path
  >  docker-compose up -d
- Create topics
  >  Create two topics in the http://localhost:9021/clusters with the names **github-users** and **equal.github-user**
- Run the spring projects in the following order
  >  github-user-finder { Producer }
  >  github-user-process { Consumer and Producer }
  > github-user-service { Consumer }
- To test the project request to this url
  >  http://localhost:8080/users/find/asharafkar

## How to works

The sequence diagram shows the flow of data (from Produce to Consume)

```mermaid
sequenceDiagram
github-user-finder ->> github user api: send request to find users
github user api ->> github-user-finder: return users
github-user-finder ->> github-users topic: send all users to topic (produce data)
github-user-process-->> github-users topic: Receive all users from topic (consume data)
github-user-process ->> equal.github-user topic: send equal user to topic (produce data)
github-user-service -->> equal.github-user topic: Receive equal user from topic (consume data)

```
