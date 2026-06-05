# Valorant Skins Database and Website Design

This project uses the uploaded Clubhub project as the template, but changes the topic to Valorant skins.

## Includes
- `Main.java`
- `Database.java`
- `RouteHandler.java`
- `Input.java`
- `valorant.db`
- `sqlite-jdbc-3.23.1.jar`
- `index.html`
- `skins.html`
- `analysis.html`
- `activity.html`
- `style.css`
- `script.js`

## Database
Tables:
- `collections`
- `skins`

The database has 100 Valorant skin records.

## Java server routes
- `/skins`
- `/collections`
- `/weapons`
- `/rarities`
- `/analysis`

## Run server

```bash
javac -cp sqlite-jdbc-3.23.1.jar: Main.java
java -cp sqlite-jdbc-3.23.1.jar: Main
```

If that does not work in Codespaces, use:

```bash
javac -cp sqlite-jdbc-3.23.1.jar:. Main.java
java -cp ".:sqlite-jdbc-3.23.1.jar" Main
```

## Website
Open `index.html` with Live Server.

If you are using Codespaces, open the **Ports** tab, make port **8500** public, copy the 8500 URL, and replace this line in `script.js`:

```js
let link = "http://localhost:8500/";
```

with your public 8500 URL.
