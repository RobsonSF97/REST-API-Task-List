# List API

A REST API where you can add, search, update and delete your tasks

## 🚀 TECHNOLOGIES


## 📋 FEATURES

### Implemented
- [x] Task domain model (Entity)
- [x] Data access layer (Repository)
- [x] Business rules (Service)
- [x] Domain exceptions (not found, duplicate title, empty title)
- [x] Case-insensitive duplicate title validation

### Planned
- [ ] REST API endpoints (CRUD)
- [ ] Global exception handler (`@ControllerAdvice`)
- [ ] DTOs and request validation
- [ ] Thymeleaf web interface
- [ ] Unit and integration tests


## 👨‍💻 RELEASES
| 0.1.0 | 2026-08-18 | - Added TaskEntity with JPA mapping (title, description, completed, createdAt)
- Added TaskService with create, find, list and delete operations
- Added domain exceptions: TaskNotFoundException, DuplicateTitleException, EmptyTitleException
- Enforced business rules: unique title (ignore case), non-blank title, default completed = false, auto createdAt
