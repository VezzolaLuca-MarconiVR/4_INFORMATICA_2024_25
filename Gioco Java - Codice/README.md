# WhisperingGods

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name`should be
replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

--------------------------------------------------------------------------------------------------------------------

## Extensions

This project uses Ashley, Box2D, Box2D Lights, and FreeType extensions.

# Ashley

Ashley is a CES (Component-Entity-System), which provides a robust framework for building and managing game entities.
It allows developers to separate data (components) and behavior (systems) of game entities, leading to a more modular
and maintainable codebase. By using Ashley, developers can efficiently manage the state and behavior of game objects,
making it easier to develop and scale complex games. The system is designed for high performance, making it suitable
for both small and large game projects. The Engine then manages every action, calling systems on the Entityes (i.e.
on the collections of components).

Because of this, I created a package inside "io.github.vezzolaluca.whisperinggods", "io.github.vezzolaluca.whisperinggods.components"
to group everything nicely. This package, if you want, can be compared to the "Model" of MVC (Model View Controller).
I also created one more package inside ".whisperinggods", "io.github.vezzolaluca.whisperinggods.systems". Can be compared
to the "Controller" and "View" of MVC.

# Box2D



# Box2D Lights



# FreeType


