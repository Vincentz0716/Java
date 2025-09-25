# Copilot Instructions for Java Workspace

## Project Overview
This workspace contains multiple Java lesson directories, each with its own `Main.java` (and sometimes helper classes). The structure is organized by lesson or activity, e.g., `Lesson-03-Discussion/`, `Lesson-05-activity/`, `Lesson-07-activity/`.

## Key Patterns & Conventions
- **Single-file Java programs:** Most lessons use a single `Main.java` file as the entry point. Some may include additional helper classes (e.g., `Input.java`).
- **No build system:** There is no Maven/Gradle wrapper or project-level build file. Compilation and execution are expected to be done manually using `javac` and `java`.
- **No external dependencies:** All code is standard Java, with no third-party libraries or frameworks.
- **Image assets:** Some lesson folders contain `.PNG` files for reference (not used in code).

## Developer Workflows
- **Compile:**
  - Navigate to the lesson directory and run: `javac Main.java` (and any other `.java` files if present)
- **Run:**
  - After compiling, run: `java Main`
- **Debug:**
  - Use standard Java debugging tools. No project-specific debug configuration is present.
- **Add new lessons:**
  - Create a new folder, add `Main.java` (and any helper classes), following the existing pattern.

## Examples
- `Lesson-07-activity/Main.java` uses an additional `Input.java` for input handling.
- Image files in lesson folders are for documentation or reference, not for programmatic use.

## Recommendations for AI Agents
- When adding new lessons, follow the folder-per-lesson pattern and use `Main.java` as the entry point.
- Do not introduce build tools or external dependencies unless explicitly requested.
- Keep code self-contained within each lesson directory.
- Reference image files only in documentation, not in code.

## Key Files & Directories
- `Lesson-*/Main.java` — main entry point for each lesson/activity
- `Lesson-07-activity/Input.java` — example of a helper class
- `Lesson-*/.PNG` — reference images (not used in code)

---
For questions or changes to these conventions, update this file to keep AI agents aligned with project practices.
