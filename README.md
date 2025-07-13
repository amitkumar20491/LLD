# LLD (Low-Level Design)

A collection of notes and sample implementations for common low-level design patterns in Java.

## Projects

### 📝 LoggerImplementation
A clean, asynchronous logger implementation demonstrating:
- **Asynchronous Processing**: Non-blocking logging with producer-consumer pattern
- **Multiple Destinations**: Console, file, remote logging support
- **Custom Formatters**: Pluggable message formatting strategies
- **Thread Safety**: Concurrent logging from multiple threads
- **Proper Package Organization**: Clean separation of concerns
- **Design Patterns**: Strategy, Dependency Inversion, Open/Closed principles

**Key Features:**
- BlockingQueue-based async processing
- Configurable log levels (DEBUG, INFO, WARNING, ERROR)
- Graceful shutdown handling
- Extensible architecture for new destinations/formatters

### 🔄 ProducerConsumerBlockingQueue
Classic Producer-Consumer pattern implementation showcasing:
- **Thread Synchronization**: Safe multi-threaded data sharing
- **Bounded Buffer**: Capacity-limited queue management
- **Three Complete Implementations**: BlockingQueue, wait/notify, and Semaphore approaches
- **Generic Design**: Type-safe buffer implementation
- **Concurrency Best Practices**: Modern Java threading utilities
- **Synchronization Comparison**: Different approaches to thread coordination

**Key Features:**
- **BlockingQueue Implementation**: Production-ready, high-level approach
- **wait/notify Implementation**: Classic low-level synchronization
- **Semaphore Implementation**: Counting semaphore-based resource management
- Multiple producer/consumer thread support
- Clean abstraction with Buffer interface
- Interview-ready implementations with comprehensive discussion points
- Demonstrates spectrum from high-level to low-level synchronization

## Design Principles Demonstrated

- **Single Responsibility Principle**: Each class has one clear purpose
- **Open/Closed Principle**: Extensible without modification
- **Dependency Inversion**: Depend on abstractions, not concretions
- **Strategy Pattern**: Pluggable algorithms (formatters, destinations)
- **Producer-Consumer Pattern**: Decoupled thread communication
- **Thread Safety**: Proper synchronization mechanisms
