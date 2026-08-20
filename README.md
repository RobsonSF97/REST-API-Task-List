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
- [x] REST API endpoints (CRUD)
- [x] Global exception handler (`@ControllerAdvice`)
- [x] DTOs and request validation
- [ ] Unit and integration tests


## 👨‍💻 RELEASES
| 0.2.0 | 2026-08-20 | - Added all API requests to TaskController, including validations and HTTP status responses.
- Created TaskMapper to handle the conversion between DTOs and entities, and vice versa.
- Created DTOs to handle request and response data.
- Added TaskControllerAdvice to provide better responses when exceptions are thrown.
- Added the update operation to TaskService.|
| 0.1.0 | 2026-08-18 | - Added TaskEntity with JPA mapping (title, description, completed, createdAt)
- Added TaskService with create, find, list and delete operations
- Added domain exceptions: TaskNotFoundException, DuplicateTitleException, EmptyTitleException
- Enforced business rules: unique title (ignore case), non-blank title, default completed = false, auto createdAt. |
