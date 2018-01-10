# rockpaperscissor

Das Spiel Rock, Paper, Scissor (Schere Stein Papier) ist eine SpringBoot Anwendung, die über Restaufrufe gespielt werden kann.

Um den Service zu starten, muss über Maven das Projekt erst gepackt werden:

```$    mvn package```

und danach die Springboot Anwendung gestartet werden

`$  java -jar target/rockpaperscissor-1.0.0.jar`

Danach ist der Webserver hochgefahren und läuft auf dem Port 8080.

`http://localhost:8080`

Um die Restaufrufe zu testen, kann die Swagger UI gen

`http://localhost:8080/swagger-ui.html`

Dort können dann die verschiedenen Restaufrufe getestet und ein Spiel gestartet werden.