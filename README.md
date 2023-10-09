# Conference service REST API with Modular Clean Architecture

## Introduction to Clean Architecture

![cleanArchitecture](./docs/CleanArchitecture.jpg "Clean Architecture diagram")

Clean Architecture is a software design philosophy that promotes the separation of concerns in software development. It emphasizes the organization of code into distinct layers, each with its specific responsibilities. The primary goal is to create a modular and maintainable architecture that allows for easy testing, scalability, and adaptability to changing requirements. Clean Architecture typically consists of the following layers:

1. **Entities:** Represents the core domain models and business logic of the application.
2. **Use Cases (Interactors):** Contains application-specific business rules and use cases that orchestrate the flow of data and actions within the application.
3. **Interfaces (Gateways):** Defines the interfaces for interacting with external systems, such as databases, web services, and UI components. These interfaces are implemented in the outer layers.
4. **Frameworks and Drivers:** Contains the outermost layer responsible for interacting with external frameworks, such as web frameworks, databases, and UI components.

## Project Overview

This project is an example of a conference event management REST API implemented using Kotlin and following the principles of Clean Architecture. It is designed to provide a well-structured, modular, and maintainable solution for managing conference events, registering participants, and retrieving conference details, including participant counts.
