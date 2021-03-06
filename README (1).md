# Calma
Данный репозиторий создан в рамках реализации проекта по созданию мобильного приложения для дыхательных упражнений.

Приложение включает в себя возможность проведения дыхательного упражнения с нативными указаниями, 
а также возможность настройки упражнения и сохранения последней настройки.
## Screenshots
- Стартовый экран 
    - <img src="https://github.com/IvAlexsay/Calma/blob/main/screenshots/1.jpg" width="200">
- Экран настроек 
    - <img src="https://github.com/IvAlexsay/Calma/blob/main/screenshots/2.jpg" width="200">
- Экран упражнения 
    - <img src="https://github.com/IvAlexsay/Calma/blob/main/screenshots/3.jpg" width="200">
## Features
- Анимированное изображение во время упражнения, указывающие текущее дествие(расширение -> вдох, статитичность -> задержка дыхания, сужение -> выдох).
- Меняющиеся текстовые директивы(Вдох, задержка, выдох).
- Вибрация и звук при смене текущего действия. Предусмотрено отключение данных средств в настройках.
- Возможность выбора готовой настройки упражнения, либо задания собственной через интуитивно понятный интерфейс в настройках.
- Темная тема, синхронизированная с системой.
## Library Used
- Foundation - Components for core system capabilities, Kotlin extensions and support for multidex and automated testing.
    - AppCompat - Degrade gracefully on older versions of Android.
    - Android KTX - Write more concise, idiomatic Kotlin code.
- Architecture - A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence.
    - View Binding - Declaratively bind observable data to UI elements.
    - Lifecycles - Create a UI that automatically responds to lifecycle events.
    - Navigation - Handle everything needed for in-app navigation.
    - ViewModel - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
    - WorkManager - Manage your Android background jobs.
- UI - Details on why and how to use UI Components in your apps - together or separate
    - Animations & Transitions - Move widgets and transition between screens.
    - Fragment - A basic unit of composable UI.
    - Layout - Lay out widgets using different algorithms.
    - NumberPicker - specil widget for pick number bu slide screen(https://github.com/ShawnLin013/NumberPicker).
### Table of contents
* [Классы приложения](classes.md)
* [Экраны приложения](screens.md)
* [Функционал кнопок приложения](functional.md)
## Contributors
- [Ивакин Алексей](https://github.com/IvAlexsay)
- [Редченко Евгений](https://github.com/Nutsheil)
