🧭 MASTER TASK LIST — REAL-TIME STUDY BOARD

## 🟦 PHASE 0 — PROJECT BOOTSTRAP (DONE ✅)

- ✔ Architecture diagram finalized
- ✔ API list + JWT rules finalized
- ✔ Context .md files created
- ✔ docker-compose.yml finalized
- ✔ Infra containers (Postgres, Redis) running

👉 Status: COMPLETE

---

## 🟦 PHASE 1 — API GATEWAY (ENTRY POINT)

### 🎯 Goal
Backend entry point runs successfully inside Docker.

### Task 1.1 — Create API Gateway Spring Boot project
- Generate Spring Boot app
- Dependencies:
    - Spring Web
    - Spring Security (no config yet)
- Done when:
    - App starts locally with `./mvnw spring-boot:run`

### Task 1.2 — Configure application.yml
- Set:
    - application name
    - port from env (SERVER_PORT)
- Done when:
    - App starts using env-based port

### Task 1.3 — Add /health endpoint
- Controller with:
    - GET /health
    - Returns `{ "status": "UP" }`
- Done when:
    - `curl localhost:8080/health` works

### Task 1.4 — Write Dockerfile for API Gateway
- Multi-stage build
- Runs jar
- Exposes correct port
- Done when:
    - `docker-compose up api-gateway` starts successfully

### Task 1.5 — Test Gateway inside Docker
- Hit /health via browser/Postman
- Done when:
    - Response received from container

### Task 1.6 — Git commit
```bash
git commit -m "API Gateway skeleton with Docker support"
```

---

## 🟦 PHASE 2 — AUTH SERVICE (IDENTITY)

### 🎯 Goal
User can register, login, and receive JWT.

### Task 2.1 — Create Auth Service Spring Boot project
- Dependencies:
    - Spring Web
    - Spring Security
    - Spring Data JPA
    - PostgreSQL Driver
    - Validation

### Task 2.2 — Configure DB connection
- Use env vars from Docker
- Connect to Postgres container
- Done when:
    - App starts without DB errors

### Task 2.3 — Create User entity
- Fields:
    - id
    - email
    - passwordHash
    - createdAt

### Task 2.4 — Implement Register API
- POST /auth/register
- Hash password (BCrypt)
- Done when:
    - User row inserted into DB

### Task 2.5 — Implement Login API
- POST /auth/login
- Validate password
- Generate JWT
- Done when:
    - JWT returned on valid login

### Task 2.6 — Implement /auth/me
- Extract user from JWT
- Return user details

### Task 2.7 — Dockerize Auth Service
- Write Dockerfile
- Run via compose
- Done when:
    - `docker-compose up auth-service` starts cleanly

### Task 2.8 — Connect Gateway → Auth Service
- Route /auth/** via gateway
- Done when:
    - Gateway forwards auth requests correctly

### Task 2.9 — Git commit
```bash
git commit -m "Auth service with JWT authentication"
```

---

## 🟦 PHASE 3 — ROOM SERVICE (ROOM MANAGEMENT)

### 🎯 Goal
Users can create, join, and list rooms.

### Task 3.1 — Create Room Service project
- Dependencies:
    - Spring Web
    - Spring Data JPA
    - PostgreSQL Driver

### Task 3.2 — Create Room entities
- Room
- RoomMember

### Task 3.3 — Implement APIs
- POST /rooms
- POST /rooms/{id}/join
- POST /rooms/{id}/leave
- GET /rooms

### Task 3.4 — JWT extraction
- Read userId from JWT (header)

### Task 3.5 — Dockerize Room Service
- Dockerfile
- Run container

### Task 3.6 — Gateway routing
- Route /rooms/**

### Task 3.7 — Git commit
```bash
git commit -m "Room service with room lifecycle APIs"
```

---

## 🟦 PHASE 4 — COLLABORATION SERVICE (REALTIME CORE)

### 🎯 Goal
Realtime drawing sync works.

### Task 4.1 — Create Collaboration Service project
- Dependencies:
    - Spring WebSocket
    - Redis
    - PostgreSQL

### Task 4.2 — WebSocket configuration
- Endpoint: /ws
- JWT validation on connect

### Task 4.3 — Room join over WebSocket
- JOIN_ROOM event
- Maintain session → room mapping

### Task 4.4 — Drawing broadcast
- Handle DRAW event
- Publish to Redis
- Broadcast to room users

### Task 4.5 — Presence tracking
- Track users online per room
- Broadcast presence updates

### Task 4.6 — Board snapshot persistence
- Save board JSON to DB or storage
- Fetch on join

### Task 4.7 — Dockerize Collaboration Service
- Dockerfile
- Redis connectivity test

### Task 4.8 — Gateway WebSocket routing
- Forward /ws correctly

### Task 4.9 — Git commit
```bash
git commit -m "Collaboration service with realtime drawing"
```

---

## 🟦 PHASE 5 — WEBRTC SIGNALING (VOICE)

### 🎯 Goal
Users can talk via mic (P2P audio).

### Task 5.1 — WebRTC signaling events
- WEBRTC_OFFER
- WEBRTC_ANSWER
- ICE_CANDIDATE
- MIC_STATUS

### Task 5.2 — Relay signaling via WebSocket
- No audio handling
- Only message forwarding

### Task 5.3 — Frontend mic toggle
- Enable/disable audio track
- Send mic status updates

### Task 5.4 — Git commit
```bash
git commit -m "WebRTC signaling support"
```

---

## 🟦 PHASE 6 — AI SERVICE (OPTIONAL / BONUS)

### 🎯 Goal
Explain board content using AI.

### Task 6.1 — Create AI Service project
- Spring Web
- REST client

### Task 6.2 — Implement /ai/explain
- Fetch board snapshot
- Send to AI API
- Return summary

### Task 6.3 — Dockerize AI Service

### Task 6.4 — Gateway routing
- Route /ai/**

### Task 6.5 — Git commit
```bash
git commit -m "AI service for board explanation"
```

---

## 🟦 PHASE 7 — FRONTEND (LAST)

### 🎯 Goal
Users can use the system end-to-end.

### Task 7.1 — Login & Register UI
### Task 7.2 — Room creation & join UI
### Task 7.3 — Canvas drawing
### Task 7.4 — WebSocket integration
### Task 7.5 — Mic ON/OFF (WebRTC)
### Task 7.6 — AI explanation UI

---

## 🟦 PHASE 8 — FINAL POLISH

- README
- Architecture explanation
- Screenshots
- Deployment notes

---

## 🧠 GOLDEN RULES WHILE EXECUTING

1. One task → finish → commit
2. If stuck → stop, don't jump ahead
3. Backend before frontend
4. Realtime after REST
5. Voice after drawing

---

## 🎯 WHAT YOU SHOULD DO RIGHT NOW

👉 Start with Task 1.1: API Gateway project creation

When done, come back and say:

**"API Gateway project created."**

We'll proceed task by task from there.